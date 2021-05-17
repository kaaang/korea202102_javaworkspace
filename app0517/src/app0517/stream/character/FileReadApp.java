package app0517.stream.character;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//문자 기반 스트림을 학습하면서, 동시에 호율적으로 데이터를 처리하는 법에 대해 알아보자

public class FileReadApp {
	FileReader reader;
	BufferedReader buffr;//문자를 대상으로 한줄씩 읽을수있는 스트림
	File file;
	
	String path = "D:\\korea202102_javaworkspace\\app0517\\res\\memo.txt";
	
	public FileReadApp() {
		try {
			reader = new FileReader(file = new File(path));//파일을 대상으로 빨때 넣기
			buffr = new BufferedReader(reader);//기존의 filereader를 버퍼 처리함
			
			
//			int data = -1;
			String data = null;
			while(true) {
				data = buffr.readLine(); //한 줄을 읽어들이기 때문에 
				if(data==null)break;
				System.out.println(data);
//				data = reader.read();//read a byte가 아니라 read single character
//				if(data == -1 )break;
//				System.out.print((char)data);
			}
			
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(buffr != null) {
				try {
					buffr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}				
			}
		}
	}
	
	public static void main(String[] args) {
		new FileReadApp();
	}
}
