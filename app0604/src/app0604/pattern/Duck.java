package app0604.pattern;

//지금 정의한 Duck클래스의 인스턴스를 오직 1개만 생성하도록 조치해보자
//싱글턴 패턴
public class Duck {
	private static Duck instance; //null
	
	private Duck() {
		
	}
	
	
	public static Duck getInstance() {
		if(instance != null) {//딱하나만 생성하게
			instance = new Duck();//null이였던 인스턴스를 생성해버림			
		}
		return instance;
	}
	
}
