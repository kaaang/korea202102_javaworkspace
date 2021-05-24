package com.minssam.shoppingapp.util;


//앞으로, 파일과 관련된 여러 작업을 전담하게 될 파일 제어 클래스 정의
public class FileManager {
	//넘겨받은 경로를 통해 확장자만 추출해보기
	public static String getExtend(String path, String token) {
		int lastIndex = path.lastIndexOf(token);
		String filename = path.substring(lastIndex+1,path.length());//sub는 0부터 시작해서 5전까지 알려준다.
		String ext = filename.substring(filename.lastIndexOf(".")+1, filename.length());
		
		return ext;
	}
}
