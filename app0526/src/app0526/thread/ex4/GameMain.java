package app0526.thread.ex4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class GameMain extends JFrame implements ActionListener{
	GamePanel gamePanel;
	JMenuBar bar;//게임 제어 패널
	JMenu m_control;
	JMenuItem item_start;
	JMenuItem item_pause;
	JMenuItem item_exit;
	
	public GameMain() {
		gamePanel = new GamePanel();
		bar = new JMenuBar();
		m_control = new JMenu("게임제어");
		item_start = new JMenuItem("start");
		item_pause = new JMenuItem("pause");
		item_exit = new JMenuItem("exit");
		
		//조립
		m_control.add(item_start);
		m_control.add(item_pause);
		m_control.add(item_exit);
		bar.add(m_control);
		setJMenuBar(bar);
		
		
		add(gamePanel);
		
		//리스너 연결
		item_start.addActionListener(this);
		item_pause.addActionListener(this);
		item_exit.addActionListener(this);
		
		pack();//내부 컨텐츠 크기까지 줄어듬
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==item_start) {
			
		}else if(e.getSource()==item_pause) {
			
		}else if(e.getSource()==item_exit) {
			gamePanel.gameFlag=false;
			System.exit(0);
		}
	}
	
	
	
	
	public static void main(String[] args) {
		new GameMain();
	}


}
