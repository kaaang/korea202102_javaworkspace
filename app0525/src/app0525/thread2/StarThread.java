package app0525.thread2;

public class StarThread extends Thread{

	
	@Override
	public void run() {
		while(true) {
			System.out.println("☆");			
		}
	}
}
