package app0510.example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		for (int i = 1; i <= 9; i++) {
			System.out.println("*"+i+"="+i);
		}
	}

}
