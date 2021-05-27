package app0526.thread.ex3;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

import util.FileManager;
import util.ImageManager;

//웹상의 자원을 수집하고, 다운로드 받는 진행 상황을 프로그래스 바로 표시한자.
public class DownLoader extends JFrame{
	JTextField t_url;
	JButton bt;
	JProgressBar bar;
	ImageManager imageManager = new ImageManager();
	ImageIcon icon; //icon 인터페이스를 구현한 클래스
	InputStream fis;
	FileOutputStream fos;
	HttpURLConnection httpCon;
	Thread thread;
	
	public DownLoader() {
		t_url = new JTextField();
		
		//resource폴더로 등록된 자원은 클래스 패스를 통해 접근해야 한다
		//그리고 클래스 패스와 관련된 정보를 얻으려면, Class 클래스를 이용하면 된다.
		
		//자바의 클래스중 class에대한 정보를 가진 클래스가 Class이다. 이 Class를 이용하면 클래스 코드를 static에올릴
		//수 있고 (Class.forName("드라이버명")) , 해당 클래스가 가진 메서드, 속성등을 추출할수도 있다.
//		Class myClass = this.getClass();
//		Method[] methods = myClass.getMethods();
//		System.out.println("이 클래스가 보유한 메서드의 수 : "+methods.length);
		
		
		//개발자가 특정 디렉토리를 resource로 등록하면, getResource()메서드로 클래스 패스를 이용하여 접근이 가능
		
		
		bt = new JButton(imageManager.getScaledIcon("bt.png", 45, 38));
		bar = new JProgressBar();
		
		setLayout(new FlowLayout());
		t_url.setPreferredSize(new Dimension(470,35));
		bar.setPreferredSize(new Dimension(470,35));
		bt.setPreferredSize(new Dimension(45,38));
		bt.setBorder(null);
		
		
		
		add(t_url);
		add(bt);
		add(bar);
		
		
		bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				thread = new Thread() {
					@Override
					public void run() {
						downLoad();	
						JOptionPane.showMessageDialog(DownLoader.this, "다운로드 완료");
					}
				};
				thread.start();
				
				
			}
		});
		
		
		
		setVisible(true);
		setBounds(2400, 100, 500, 170);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	
	public void downLoad() {
		try {
			URL url = new URL(t_url.getText());
			httpCon = (HttpURLConnection)url.openConnection();
			httpCon.setRequestMethod("GET");
			fis = httpCon.getInputStream();//서버의 자원과 연결된 스트림 얻기
			
			//파일의 총 크기를 구하자
			int total = httpCon.getContentLength();
			
			
			long time = System.currentTimeMillis();
			String ext = FileManager.getExtend(t_url.getText(), "/");
			String filename = time+"."+ext;
			fos = new FileOutputStream("D:\\korea202102_javaworkspace\\app0526\\data\\"+filename);
			
			int data = -1;
			int count = 0;
			while(true) {
				data=fis.read();
				float percent = (count/(float)total)*100;
				bar.setValue((int)percent);
				if(data==-1)break;
				count++;
				fos.write(data);
			}
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		new DownLoader();
	}
}
