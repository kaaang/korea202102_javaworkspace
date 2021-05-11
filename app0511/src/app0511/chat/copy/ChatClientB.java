package app0511.chat.copy;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClientB extends JFrame implements KeyListener{
	JTextArea area;
	JScrollPane scroll;
	JTextField t_input;
	
	private JTextArea area2; //a가 보유한 jtextarea의 주소값
	private JTextArea area3; //a가 보유한 jtextarea의 주소값
	
	public ChatClientB(int r, int g, int b, int left) {
		area = new JTextArea();
		scroll = new JScrollPane(area);
		t_input = new JTextField(24);
		
		//스타일
		setLayout(new FlowLayout());
		scroll.setPreferredSize(new Dimension(280,280));
		area.setBackground(new Color(r, g, b));
		
		//조립
		add(scroll);
		add(t_input);
		t_input.addKeyListener(this);
		
		//이벤트
		
		//보여주기
		setBounds(left, 100, 330, 400);
		setVisible(true);
	}

	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void keyPressed(KeyEvent e) {}
	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_ENTER) {
			showText();
		}
	}
	
	public void showText() {
		String msg = t_input.getText();
		area.append(msg+"\n");
		area2.append(msg+"\n");
		area3.append(msg+"\n");
		t_input.setText("");
	}

	

	public void setArea2(JTextArea area2,JTextArea area3) {
		this.area2 = area2;
		this.area3 = area3;
	}
}
