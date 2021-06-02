package app0602.stream;

import java.io.IOException;
import java.io.InputStream;
import java.net.MulticastSocket;

public class StreamStudy {

	public static void main(String[] args) {
		
		//키보드를 통해 데이터를 입력받아보자
		//FileInputStream fis = new ~~ 파일 스트림은 새성 시점을 개발자가 정할 수 있는 스트림이다.
		//하지만 키보드, 모니터, 바코드스캐너, 프린터기 등등 하드웨어를 시스템인 OS가 관리하므로,
		//컴퓨터를 켜는 순간부터 이미 스트림은 존재하게 된다 따라서 new가 아닌 시스템인 os로부터 얻을 수 있는
		//자바에서 이 os인 시스템을 접글할때 사용되는 객체가 바로 System.이다
		//System.currentTimemils : 내 컴퓨터 시간
		InputStream is = System.in;
		
		//현재 is는 바이트 기반 스트림으로, 1byte씩 처리 할 수 있다.
		
		int data = -1;
		
		try {
			data=is.read();
			System.out.println((char)data);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
