package app0602.stream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

//키보드로 부터 문자를 입력받아 모니터에 출력하되, 한글이 깨지지 않아야 하고,
//한 줄씩 입력받아 한줄씩 출력하시오
public class BufferTest {

	public static void main(String[] args) {
		InputStream is = System.in;
		
		//문자 기반 스트림으로 변환
		InputStreamReader reader = new InputStreamReader(is);
		BufferedReader buffr = new BufferedReader(reader);
		
		
		//문자기반
//		int data=-1;
//		while(true) {
//			try {
//				data = reader.read();
//				System.out.print((char)data);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
		
		//단어기반
		String data=null;
		while(true) {
			try {
				data = buffr.readLine();
				System.out.print(data);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
