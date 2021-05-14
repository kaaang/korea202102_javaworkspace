package io.bytestream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

class CopyImage{
	
	FileInputStream fis;
	FileOutputStream fos;

	//예외처리 목효 : 프로그램을 안정적으로 운영하기 위한 수단
	public CopyImage() {
		try {
			fis = new FileInputStream("D:\\korea202102_javaworkspace\\app0514\\res\\1.jpg");
			fos = new FileOutputStream("D:\\korea202102_javaworkspace\\app0514\\res\\1_copy.jpg");
			
			//입력 스트림으로는 데이터의 1바이트씩 읽어들이고, 출력 스트림으로는 데이터를 1바이트씩 출력해보자 ->복사
			int data = -1;
			while(true) {
				data = fis.read();//1바이트 읽기(입력)
				if(data==-1)break;
				fos.write(data);//1바이트 쓰기(출력)
			}
			System.out.println("복사완료");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("파일을 찾을 수 없습니다.");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("파일을 읽을 수 없습니다.");
		}finally {
			if(fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}							
			}
		}
	}

	public static void main(String[] args){
		new CopyImage();
	}
}
