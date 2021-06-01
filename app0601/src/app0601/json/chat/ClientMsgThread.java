package app0601.json.chat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import javax.swing.JOptionPane;

//모든 접속 클라이언트 마다 1:1 대응하여, 서버측에 생성되는 대화용 클라이언트 쓰레드
//따라서 클라이언트가 접속을 끊으면, 서버측에 대응되는 이 객체 또한 소멸되어야 한다.
public class ClientMsgThread extends Thread{
	ChatClient chatClient;
	Socket socket;
	BufferedReader buffr;
	BufferedWriter buffw;
	boolean flag=true;
	
	public ClientMsgThread(Socket socket,ChatClient chatClient) {
		this.socket=socket;
		this.chatClient=chatClient;
		try {
			buffr = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			buffw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void listen() {
		String msg = null;
		try {
			msg = buffr.readLine();
			chatClient.area.append(msg+"\n");
		} catch (IOException e) {
			e.printStackTrace();
			flag=false;
		}
	}
	public void send(String msg) {
		try {
			buffw.write(msg+"\n");
			buffw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//듣고 말하는 행위는 서버이기에 끝없이 즉 쓰레드가 절대 죽으면 안됨
	
	public void run() {
		while(flag) {
			listen();
		}
		//쓰레드 종료에 따른, 스트림 닫기
		if(buffw!=null) {
			try {
				buffw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(buffr!=null) {
			try {
				buffr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
