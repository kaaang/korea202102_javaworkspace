package app0528.network.multi.gui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

//다른 접속자가 보낸 메시지를 실시간으로 듣기 위해서는 listen()메서드를 무한루프로 처리해야하므로,
//메인쓰레드가 아닌 개발자 정의 쓰레드로 처리해야, 프로그램의 GUI가 대기상태에 빠지지 않는다.
public class ClientMsgThread extends Thread{

	Socket socket;
	BufferedReader buffr;
	BufferedWriter buffw;
	ChatClient chatClient;
	
	public ClientMsgThread(ChatClient chatClient) {
		this.chatClient=chatClient;
		this.socket=chatClient.socket;
		try {
			buffr=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			buffw=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		} catch (IOException e) {
			e.printStackTrace();
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
	public void listen() {
		String msg=null;
		try {
			msg = buffr.readLine();
			chatClient.area.append(msg+"\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	public void run() {
		while(true) {
			listen();
		}
	}
	
	
	
	
}
