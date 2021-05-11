package app0510.example;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Gugudan extends JFrame{
	JTextField t_input;
	JButton bt;
	
	public Gugudan() {
		t_input = new JTextField(20);
		bt = new JButton("출력");
		
		setLayout(new FlowLayout());
		
		add(t_input);
		add(bt);
		
		GugudanEvent ge=null;
		bt.addActionListener(ge = new GugudanEvent(t_input));
		ge.callMe(5);
		ge.callMe(3,"안녕");
		ge.callMe(bt);
		
		
		setSize(250, 200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		new Gugudan();
	}
}
