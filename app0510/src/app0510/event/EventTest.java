package app0510.event;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class EventTest extends JFrame{
	JTextField t_input;
	JButton bt;
	
	
	
	public EventTest() {
		t_input = new JTextField(20);
		bt = new JButton("button");
		
		setLayout(new FlowLayout());
		
		
		add(t_input);
		add(bt);
		//컴포넌트와 리스너와의 연결
		//이벤트 구현 방법 : 미완성 객체를 구현 한 후, 해당 프로그램과 연결
		bt.addActionListener(new ActionControl());
		t_input.addKeyListener(new KeyControl());
		addMouseListener(new MouseControl());
		addWindowListener(new WindowControl());
		
		
		
		
		
		setSize(250,150);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new EventTest();
	}
	
}
