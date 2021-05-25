package app0525.thread2;

public class CounterThread extends Thread{

	int count=0;
	
	@Override
	public void run() {
		while(true) {
			count++;
			System.out.println(count);
			
			
			//non-Runnable영역으로 피신시키기
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
