package app0511.member;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class JoinForm extends JFrame implements ActionListener{
	JPanel p_title;
	JLabel la_title;
	JLabel la_id;
	JTextField t_id;
	JLabel la_pass;
	JPasswordField t_pass;
	JLabel la_hobby;
	JPanel p_hobby;
	JCheckBox[] ch_hobby;
	JPanel p_mail;
	JTextField t_mailId;
	JLabel la_at;
	Choice ch_server;
	JPanel p_receive;
	JLabel la_receive;
	CheckboxGroup g;
	JButton bt_regist;
	
	public JoinForm() {
		p_title = new JPanel();
		la_title = new JLabel("회원가입");
		la_id = new JLabel("ID");
		t_id = new JTextField();
		la_pass = new JLabel("PASS");
		t_pass = new JPasswordField();
		la_hobby = new JLabel("취미선택");
		p_hobby = new JPanel();
		ch_hobby = new JCheckBox[5];//빈 공간만 생성함
		ch_hobby[0] = new JCheckBox("자바");
		ch_hobby[1] = new JCheckBox("파이썬");
		ch_hobby[2] = new JCheckBox("C#");
		ch_hobby[3] = new JCheckBox("C++");
		ch_hobby[4] = new JCheckBox("코틀린");
		p_mail = new JPanel();
		t_mailId = new JTextField();
		la_at = new JLabel("@");
		ch_server = new Choice();
		ch_server.add("gmail.com");
		ch_server.add("naver.com");
		ch_server.add("daum.net");
		ch_server.add("direct insert");
		p_receive = new JPanel();
		la_receive = new JLabel("메일 수신");
		g=new CheckboxGroup();//체크박스를 그룹으로 묶기
		bt_regist = new JButton("회원가입");
		
		

		
		//스타일
		setLayout(new FlowLayout());
		la_title.setFont(new Font("돋음",Font.BOLD,24));
		p_title.setPreferredSize(new Dimension(450, 50));
		Dimension d = new Dimension(100,30);
		la_id.setPreferredSize(d);
		t_id.setPreferredSize(new Dimension(350, 30));
		la_pass.setPreferredSize(d);
		t_pass.setPreferredSize(new Dimension(350, 30));
		p_hobby.setPreferredSize(new Dimension(450, 50));
		t_mailId.setPreferredSize(new Dimension(120, 30));
		la_at.setPreferredSize(new Dimension(30, 30));
		ch_server.setPreferredSize(new Dimension(200, 30));
		la_receive.setPreferredSize(d);
		p_receive.setPreferredSize(new Dimension(450, 50));
		
		//조립
		p_title.add(la_title);
		add(p_title);
		add(la_id);
		add(t_id);
		add(la_pass);
		add(t_pass);
		add(la_hobby);
		for (int i = 0; i < ch_hobby.length; i++) {
			p_hobby.add(ch_hobby[i]);			
		}
		add(p_hobby);
		p_mail.add(t_mailId);
		p_mail.add(la_at);
		p_mail.add(ch_server);
		add(p_mail);
		p_receive.add(la_receive);
		p_receive.add(new Checkbox("Yes", g , true));
		p_receive.add(new Checkbox("No", g , false));
		add(p_receive);
		add(bt_regist);
		
		bt_regist.addActionListener(this);
		
		//보여주기
		setSize(500,500);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void checkValue() {
//		JOptionPane.showMessageDialog(this, "유효성 체크 시작");
		
		//유효성 체크
//		System.out.println(t_id.getText());
		
		
		
//		char[] pass = t_pass.getPassword(); //char배열로 데이터 받은 후, 우리가 원하는 형태인 String로 다시 변환
//		String data=new String(pass);
		String data=new String(t_pass.getPassword());
//		System.out.println(data);
		
		//5개의 체크박스를 대상으로 조사를 실시한다.
		
//		System.out.println(ch_hobby[0].isSelected());
		int count=0;
		for(int i=0; i<ch_hobby.length;i++) {
			if(ch_hobby[i].isSelected()) {
				count++;
			}			
		}
		
		
		if(t_id.getText().length()==0) {
			JOptionPane.showMessageDialog(this, "아이디를 입력하세요");
			//커서 올려두기
			t_id.requestFocus();
		}else if(data.length()<8) {
			JOptionPane.showMessageDialog(this, "비밀번호를 8자 이상 입력하세요");			
			t_pass.requestFocus();
		}else if(count<1){
			JOptionPane.showMessageDialog(this, "하나 이상의 취미를 선택해 주세요.");						
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		checkValue();
	}
	
	
	public static void main(String[] args) {
		new JoinForm();
	}
}
