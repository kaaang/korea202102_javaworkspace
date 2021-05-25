package app0525.thread;


//개발자는 자신만에 쓰레드를 커스터마이징 하기 위해서는, Thread 클래스를 상속받아서 해당 메서들 오버라이드 해야한다.


public class MyThread extends Thread{
	//개발자는 하나의 프로세스 내에서 독립적으로 실행될 코드를 (분신의 역할) run메서드를 재정의 함으로써 구현한다.
	//run메서드에 독립실행할 코드를 작성해야 한다.
	String star;
	public MyThread(String star) {
		this.star = star;
	}
	
	@Override
	public void run() {

		while(true) {
			System.out.println(star);
			try {
				Thread.sleep(1000);//      1000/1000초 뒤에 실행
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	
}
