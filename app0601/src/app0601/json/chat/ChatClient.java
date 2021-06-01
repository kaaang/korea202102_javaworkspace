package app0601.json.chat;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClient extends JFrame{
	JPanel p_north;
	JTextField t_ip;
	JTextField t_port;
	JButton bt_connect;
	JTextArea area;
	JScrollPane scroll;
	JPanel p_south;
	JTextField t_input;
	JButton bt_send;
	
	Socket socket;
	ClientMsgThread msgThread;
	Member member;
	
	public ChatClient(Member member) {
		this.member=member;
		p_north = new JPanel();
		t_ip = new JTextField("221.146.168.130",10);
		t_port = new JTextField(5);
		bt_connect = new JButton("접속");
		area = new JTextArea();
		scroll = new JScrollPane(area);
		p_south = new JPanel();
		t_input = new JTextField(20);
		bt_send = new JButton("send");
		
		//조립 
		p_north.add(t_ip);
		p_north.add(t_port);
		p_north.add(bt_connect);
		add(p_north, BorderLayout.NORTH);
		add(scroll);
		p_south.add(t_input);
//		p_south.add(bt_send);
		add(p_south, BorderLayout.SOUTH);
		
		//이벤트 
		bt_connect.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				//접속시도
				connect();
			}
		});
		
		//윈도창 닫을때 쓰레드 종료
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				msgThread.flag=false;
				System.exit(0);
			}
		});
		
		//메시지 입력 엔터 처리
		t_input.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					sendMsg();
				}
			}
		});
		//전송버튼 눌러도 전송
		bt_send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendMsg();
			}
		});
		
		//보이기 
		setVisible(true);
		setBounds(2200, 100, 300, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		connect();
		//직후에는 로그인 정보를 넘겨 주자
		sendAllData();
	}
	
	public void sendMsg() {
		String msg = t_input.getText();
		//클라이언트가 서버에 보낼 데이터가 언제나 대화 메시지만 있는것은 아니다
		//대화 이외에 서버에 데이터를 전송할때는 어떻게 해야하나?
		//서버에 보내려고 하는 데이터에 각종 의미를 부여하되, 정현적, 구조화된, 많이 알려진 형태의 데이터를
		//구성하는게 
		msgThread.send(member.getUser_Id() + ":" +msg);
		t_input.setText("");
	}
	
	//1)채팅 서버에 회원의 모든 정보를 실어서 보내는 방법
	public void sendAllData() {
		StringBuilder sb = new StringBuilder();
		
		//서버에 메시지 전송
		msgThread.send(sb.toString());
		
	}
	
	
	//2)채팅 서버에 회원의 ID만 보내서, 이 회원의 정보는 서버측에서 참조할 수 있게 하는 방법
	public void sendId() {
		
	}
	
	
	public void connect() {
//		String ip = t_ip.getText();
//		int port = Integer.parseInt(t_port.getText());
		String ip="221.146.168.130";
		int port=7777;
		try {
			socket = new Socket(ip,port);
			//클라이언트
			msgThread = new ClientMsgThread(socket, this);
			msgThread.start();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

