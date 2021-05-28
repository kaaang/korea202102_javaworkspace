package app0528.network.multi.gui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ServerMsgThread extends Thread{
	Socket socket;
	BufferedReader buffr;
	BufferedWriter buffw;
	ChatServer chatServer;
	boolean flag=true;
	
	
	public ServerMsgThread(Socket socket,ChatServer chatServer) {
		this.socket=socket;
		this.chatServer=chatServer;
		try {
			buffr = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			buffw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		} catch (IOException e) {
			e.printStackTrace();
			
		}
	}
	
	
	//듣고
	public void listen() {
		String msg=null;
		try {
			msg = buffr.readLine();//클라이언트가 보낸 메시지 듣기
			
			for(int i=0;i<chatServer.clientList.size();i++) {
				ServerMsgThread msgThread=chatServer.clientList.get(i);//벡터의 각 요소에 들어있는 스레드 꺼내기
				msgThread.send(msg);				
			}
			
			chatServer.area.append(msg+"\n");
		} catch (IOException e) {
			e.printStackTrace();
			//대화 목록 수에서 제거
			chatServer.clientList.remove(this);
			chatServer.area.append("클라이언트 접속 해제, 현재 접속자 : "+chatServer.clientList.size()+"\n");
			flag=false;
		}
	}
	
	
	//말하기
	public void send(String msg) {
		//버퍼 처리된 스트림에서의 문자열의 끝을 표시할때는 역슬래시 n 을 이용해야한다.
		try {
			buffw.write(msg+"\n");
			buffw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void run() {
		while(flag) {
			listen();
		}
	}
	
	
}
