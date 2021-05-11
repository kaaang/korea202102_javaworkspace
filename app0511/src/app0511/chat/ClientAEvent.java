package app0511.chat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//CharClientA 에 대한 이벤트 처리 클래스 정의
public class ClientAEvent implements ActionListener, KeyListener{
	private JTextField t_input;
	private JTextArea area;
	private JButton bt, bt_open;
	
	
	
	public void setT_input(JTextField t_input) {
		this.t_input = t_input;
	}
	public void setArea(JTextArea area) {
		this.area = area;
	}
	public void setBt(JButton bt) {
		this.bt = bt;
	}
	public void setBt_open(JButton bt_open) {
		this.bt_open = bt_open;
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton)e.getSource();
		//System.out.println(btn);
		
		if(btn==bt) {
//			System.out.println("전송");
			showText();
		}else if(btn==bt_open) {
			System.out.println("오픈");			
		}
		
		
	}
	
	
	public void showText() {
		String msg=t_input.getText();
		area.append(msg+"\n");
		t_input.setText("");
	}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {
		//System.out.println(e);
		int key=e.getKeyCode();
		if(key==KeyEvent.VK_ENTER) {
			showText();			
		}
	}

	
	

}
