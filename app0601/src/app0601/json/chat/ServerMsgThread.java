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
public class ServerMsgThread extends Thread{
	ChatServer chatServer;
	Socket socket;
	BufferedReader buffr;
	BufferedWriter buffw;
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
	
	
	public void listen() {
		String msg = null;
		try {
			msg = buffr.readLine();
			//예전과는 틀리게, 클라이언트가 좀더 복잡한 형태의 데이터 구조를 전송했기 때문에
			//서버는 모든 메시지가 대화를 의도한게 아니라는것을 알고, 데이터를 분석해야한다.
			//이때 클라이언트가 보낸 데이터가 JSON이면, SJON파싱을 해야 하고, 클라이언트가 보낸 데이터 구조가
			//xml이면 xml파싱을 통해 해석하면 된다.
			if(true) {//로그인 정보가 전송되어 오면
				
			}else if(false) {//대화의 메서지가 전송되어 오면
				//대화일때 broadcasting
				for(int i=0;i<chatServer.clientList.size();i++) {
					ServerMsgThread msgThread = chatServer.clientList.get(i);
					msgThread.send(msg);				
				}				
			}else if(false) {//이모티콘을 전송한거라면
				
			}else if(false) {//친구 추가 요청이라면
				
			}else if(false) {//선물보내기라면
				
			}
			
			
			chatServer.area.append(msg+"\n");
		} catch (IOException e) {
			e.printStackTrace();
			flag=false;
			chatServer.clientList.remove(this);
			chatServer.area.append("현재까지 참여자 수 : "+chatServer.clientList.size()+"\n");
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
	}
	
}
