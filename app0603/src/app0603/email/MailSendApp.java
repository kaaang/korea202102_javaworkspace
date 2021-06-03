package app0603.email;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//메일을 주고 받으려면, 원래 메일 서버가 있어야 한다.
//하지만, 이번 수업은 이미 무료로 제공되는 구글의 메일 서버를 이용해본다.
public class MailSendApp extends JFrame{
	JTextField t_receiver;
	JTextField t_sender;
	JTextField t_title;
	JTextArea area;
	JButton bt;
	Properties props;//키와 벨류 쌍으로 데이터를 처리하는 Map컬렉션 중 api중 하나
	
	public MailSendApp() {
		t_receiver = new JTextField(25);
		t_sender = new JTextField("kangsh950309@gmail.com",25);
		t_title = new JTextField(25);
		area = new JTextArea();
		bt = new JButton("메일 발송");
		
		setLayout(new FlowLayout());
		area.setPreferredSize(new Dimension(250, 150));
		
		add(t_receiver);
		add(t_sender);
		add(t_title);
		add(area);
		add(bt);
		
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendMail();
			}
		});
		setSize(300, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void sendMail() {
		props = new Properties(); //Map 유형 중 하나.
		props.put("mail.smtp.host", "smtp.gmail.com");//smtp서버 주소 작성
		props.put("mail.smtp.host.port", 465);//smtp서버 주소 작성
		props.put("mail.smtp.auth", "true");//smtp서버 주소 작성
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");//smtp서버 주소 작성
		
		//세션 객체 생성(java mail api 에 Session)
		Session session=Session.getDefaultInstance(props, new Authenticator() {
//			ujfvrqsenoqxwykz
			//구글 개인 설정에서 생성된 앱비밀번호를 메일에서 사용할 수 있다.
			protected PasswordAuthentication getPasswordAuthentication() {

				return new PasswordAuthentication("", "");
			}
		});
		
		//메시지 구성(메일로 보낼 내용 등 구성)
		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(t_sender.getText()));//발신자 주소
			message.addRecipient(Message.RecipientType.TO ,new InternetAddress(t_receiver.getText()) );//받는자 주소
			message.setSubject(t_title.getText());//메일 주소
			message.setContent(area.getText(), "text/html;charset=utf8");
			Transport.send(message);
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new MailSendApp();
	}
}
