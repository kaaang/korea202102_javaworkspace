package app0511.chat;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClientA extends JFrame{
	JButton bt_open;
	JTextArea area;
	JScrollPane scroll;
	JTextField t_input;
	JButton bt;
	
	public ChatClientA() {
		//생성
		area = new JTextArea();
		scroll = new JScrollPane(area);
		t_input = new JTextField(20);
		bt = new JButton("전송");
		bt_open = new JButton("열기");
		
		//레이아웃
		this.setLayout(new FlowLayout());
		scroll.setPreferredSize(new Dimension(280,280));
		area.setBackground(new Color(250,255,0));
		
		//조립
		add(bt_open);
		add(scroll);
		add(t_input);
		add(bt);
		
		ClientAEvent ce = new ClientAEvent();
		bt.addActionListener(ce);
		bt_open.addActionListener(ce);
		
		t_input.addKeyListener(ce);
		ce.setT_input(t_input);
		ce.setArea(area);
		ce.setBt(bt);
		ce.setBt_open(bt_open);
		
		//보여주기
		setBounds(2200, 100, 330, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	public static void main(String[] args) {
		new ChatClientA();
	}
	
}
