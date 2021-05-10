package app0510.layout;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;

public class LoginForm {
	public static void main(String[] args) {
		Frame frame = new Frame("Login Form Type 1");
		
		
		//Frame 의 Default 인 BorderLayout의 한 방위는 컴포넌트들이 공존할 수 없고,
		//크기또한 컨테이너까지 늘어나 버린다  -> 여러 컴포넌트를 올려놓고 공존시킬 수 있는 컨테이너를 이용하자 ->Panel
		
		Panel p_center = new Panel(); //default ->FlowLayout
		
		//패털에 적용된 배치방법을 바꿔보자 ->GridLayout으로
		GridLayout grid = new GridLayout(2,2);
		p_center.setLayout(grid);
		
		
		//라벨도 센터에 넣어보자(공존 여부 체크)
		Label la_id = new Label("ID");
		TextField t_id = new TextField();
		Label la_pass = new Label("PASS");
		TextField t_pass = new TextField();
		
		Panel p_south = new Panel();
		Button bt_login = new Button("Login");
		Button bt_join = new Button("Join");
		
		
		//라벨에 경계를 알기 위해 배경색을 적용해보자
		la_id.setBackground(Color.yellow);
		
		
		
		
		p_center.add(la_id);
		p_center.add(t_id);//방위를 명시하지 않으면 default가 센터임
		p_center.add(la_pass);
		p_center.add(t_pass);
		
		p_south.add(bt_login);
		p_south.add(bt_join);
		
		
		
		
		frame.add(p_center);
		frame.add(p_south,BorderLayout.SOUTH);
		
		
		frame.setVisible(true);
		frame.setSize(300, 125);
	}
}
