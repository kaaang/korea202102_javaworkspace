package app0510.example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

public class GugudanEvent implements ActionListener{
	JTextField t_input;
	
	//생성자가 준비되어야함
	public GugudanEvent(JTextField t_input) {
		this.t_input=t_input;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		printDan();
	}
	
	public void printDan() {
		String dan = t_input.getText();
		int d = Integer.parseInt(dan);
		for (int i = 1; i <= 9; i++) {
			System.out.println(d+"*"+i+"="+(i*d));
		}
	}
	
	
	
	
	
	
	
	
	
	public void callMe(int x) {
		System.out.println("넘겨받은 x는 " + x);
	}
	public void callMe(int x, String y) {
		System.out.print("넘겨받은 x는 " + x);
		System.out.println("넘겨받은 y는 " + y);		
	}
	public void callMe(JButton bt) {
		System.out.print("bt는 " + bt);
	}
	
	
	
	
	
	
	

}
