package app0528.network.multi.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatServer extends JFrame{
	JPanel p_north;
	JTextField t_port;
	JButton bt;
	JTextArea area;
	JScrollPane scroll;
	
	ServerSocket server; //클라이언트의 접속을 감지하는 소켓(대화용 아님)
	Thread serverthread;//메인 메서드 대신 서버의 접속자 감지를 위한 무한대기를 처리할 쓰레드
	/*
	 * 쓰레드 구현의 3가지 방법
	 * 1.별도의 .java파일로 생성(재사용성 높을때, 관리 목적상 코드를 분리 시키고 싶을때
	 * 2.내부익명
	 * 3.Runnable 인터페이스를 구현
	 * */
	Vector<ServerMsgThread> clientList;
	
	public ChatServer() {
		p_north = new JPanel();
		t_port = new JTextField(10);
		bt = new JButton("서버가동");
		area = new JTextArea();
		scroll = new JScrollPane(area);
		clientList = new Vector<ServerMsgThread>();
		
		
		p_north.add(t_port);
		p_north.add(bt);
		add(p_north, BorderLayout.NORTH);
		add(scroll);
		
		
		
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				serverthread = new Thread() {
					public void run() {
						startServer();
					}
				};
				serverthread.start();
			}
		});
		
		
		
		
		
		setVisible(true);
		setBounds(2400, 100, 300, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	public void startServer() {
		int port = Integer.parseInt(t_port.getText());
		try {
			server = new ServerSocket(port);
			area.append("서버 가동 및 접속자 감지중...\n");
			while(true) {
				Socket socket=server.accept();
				String ip = socket.getInetAddress().getHostAddress();
				area.append(ip+" 접속\n");	
				
				ServerMsgThread msgThread = new ServerMsgThread(socket,this);
				msgThread.start();
				clientList.add(msgThread);//접속자 명단에 추가하기
				area.append("현재 접속자 : "+clientList.size()+"\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		new ChatServer();
	}
}
