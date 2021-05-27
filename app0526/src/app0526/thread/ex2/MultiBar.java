package app0526.thread.ex2;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class MultiBar extends JFrame{
	JButton bt;
	
	BarThread bar1;
	BarThread bar2;
	BarThread bar3;
	
	Thread t1,t2,t3;
	
	public MultiBar() {
		bar1 = new BarThread(1);
		bar2 = new BarThread(2);
		bar3 = new BarThread(3);
		bt = new JButton("start");
		
		Dimension d = new Dimension(275,35);
		bar1.setPreferredSize(d);
		bar2.setPreferredSize(d);
		bar3.setPreferredSize(d);
		
		setLayout(new FlowLayout());
		
		add(bar1);
		add(bar2);
		add(bar3);
		add(bt);
		
		
		bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				t1=new Thread(bar1);
				t2=new Thread(bar2);
				t3=new Thread(bar3);
				
				//이 시점부터 개발자가 start()메서들 ㄹ호출하면 해당 쓰레드의 run()메서드 호출은
				//Runnable 인터페이를 구현한 객체의 것을 호출한다
				t1.start();
				t2.start();
				t3.start();
			}
		});
		
		
		setVisible(true);
		setBounds(2400, 100, 300, 190);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	
	
	
	public static void main(String[] args) {
		new MultiBar();
	}
}
