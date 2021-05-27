package app0526.thread.ex1;

//메인 실행부 대신 무한 루프로 카운트를 증가시킬 세부 실행 단위인 쓰레드를 정의
public class CountThread extends Thread{
	//스레드를 수행할 코드
	//이 run메서드는 jvm이 원하는 시점에서 호출해준다. 즉 개발자가 호출하면 일반 메서드 호출이되며
	//메인스레드에 의해 호출되어 버린다.
	public void run() {
		while(true) {
//			count;
		}
	}
}
