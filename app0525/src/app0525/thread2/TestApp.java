package app0525.thread2;

public class TestApp {
	public static void main(String[] args) {
		
		StarThread st1 = new StarThread();
		CounterThread ct = new CounterThread();
		
		//개발자는 런을 호출하면 안된다 그러면 메인 실행부가 스레드를 실행하러 가버린다.
		//스레드를 사용하면 스레드한테 그냥 일을 시키고 메인 실행부는 지나가야한다.
		
		
		//이 시점 부터는 메인 실행부가  쓰레드에 run을 직접 수행하지 않고, jvm의 runnable영역으로 밀어 넣기 때문에
		//st1이 언제 수행할지는 오직 jvm만이 알고있다.
		//또한 jvm에 의해 실행이 선택되는 순간 해당 쓰레드의 run 메서가 실행되어진다.
		//이때를 가르켜 running이라고 한다.
		st1.start();
		ct.start();
		
	}
}
