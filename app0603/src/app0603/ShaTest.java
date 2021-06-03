package app0603;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

//암호화 알고리즘 중 SHA256을 이용해보자



public class ShaTest {

	public static void main(String[] args) {
		String password="rkdtlsgur";
		try {
			MessageDigest md=MessageDigest.getInstance("SHA-256");
			byte[] hash=password.getBytes("UTF-8");
			
			
			StringBuffer sb = new StringBuffer();
			
			for(int i=0;i<hash.length;i++) {
				String hex=Integer.toHexString(0xff &hash[i]);
				if(hex.length()==1) sb.append("0");
				sb.append(hex);
				System.out.println(hex);
			}
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
