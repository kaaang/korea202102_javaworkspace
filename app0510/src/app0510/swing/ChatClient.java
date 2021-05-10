package app0510.swing;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClient extends JFrame{
	JTextArea area;
	JPanel p_south;
	JTextField t_input;
	JButton bt_send;
	
	public ChatClient() {
		//생성
		area = new JTextArea();
		p_south = new JPanel();
		t_input = new JTextField(15);
		bt_send = new JButton("send");
		
		//스타일 적용
		area.setBackground(Color.YELLOW);
		area.setEditable(false);
		
		//조립
		add(area);
		p_south.add(t_input);
		p_south.add(bt_send);
		add(p_south,BorderLayout.SOUTH);
		
		//보여주기
		setSize(300, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	}
	
	
	public static void main(String[] args) {
		new ChatClient();
	}
}
