package app0517.stream.crawling;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class ImageCollector {
	//이 객체는 안드로이드에서도 동일하게 쓰인다.
	URL url;
	URLConnection  con; //웹 서버에 요청을 시도할 수 있는 객체
	HttpURLConnection http;//URLConnection의 자식객체 즉 http 프로토콜에 최적화된 자식
	
	String path = "https://file.mk.co.kr/meet/neds/2015/04/image_readtop_2015_364488_14291723731877137.jpg";
	
	FileOutputStream fos;
	
	public ImageCollector() {
		InputStream is = null;
		try {
			url = new URL(path);
			
			con = url.openConnection();
			http=(HttpURLConnection)con; //같은 자료형으로 형변환 가능 (다운케스팅);
			http.setRequestMethod("GET");
			
			
			//웹 서버의 요청을 시도해보자
			is = http.getInputStream();//웹서버와의 요청시 생성된 입력 스트림
			fos = new FileOutputStream("D:\\korea202102_javaworkspace\\app0517\\res\\target.jpg");//복사될 파일 즉 생성될 파일의 경로
			
			
			long startTime = System.currentTimeMillis();
			int data = -1;
			byte[] b = new byte[1024];
			
			
			while(true) {
				data = is.read(b);
				if(data == -1)break;
				System.out.println(data);
				fos.write(b);
			}
			System.out.println("복사완료");
			long endTime = System.currentTimeMillis();
			System.out.println("소요 시간은 : "+(endTime-startTime));
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
			System.err.println("주소가 올바르지 않습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		new ImageCollector();
	}
}
