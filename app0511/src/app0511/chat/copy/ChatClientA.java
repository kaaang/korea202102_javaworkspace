package app0511.chat.copy;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClientA extends JFrame implements ActionListener, KeyListener{
	JButton bt_open;
	JTextArea area;
	JScrollPane scroll;
	JTextField t_input;
	JButton bt;
	ChatClientB cb,cb1;
	
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
		
		bt.addActionListener(this);
		bt_open.addActionListener(this);
		t_input.addKeyListener(this);
		
		
		
		//보여주기
		setBounds(2000, 100, 330, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
		
	
	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void keyPressed(KeyEvent e) {}
	@Override
	public void keyReleased(KeyEvent e) {
		int k=e.getKeyCode();
		if(k==KeyEvent.VK_ENTER) {
			showText();
		}
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		//열기버튼
		if(e.getSource()==bt_open) {
			cb = new ChatClientB(50,100,20,2400);
			cb1 = new ChatClientB(80,80,80,2700);
			
			
			cb.setArea2(area,cb1.area);
			cb1.setArea2(area,cb.area);
		}
		//전송버튼
		else if(e.getSource()==bt) {
			showText();
		}
	}
	
	//전송처리
	public void showText() {
		String msg = this.t_input.getText();
		this.area.append(msg+"\n");
		t_input.setText("");
		
		//친구인 상대방 채팅창의 area.append하면 된다.
		cb.area.append(msg+"\n");
		cb1.area.append(msg+"\n");
	}
	
	
	
	public static void main(String[] args) {
		new ChatClientA();
	}
	
	
	
}
