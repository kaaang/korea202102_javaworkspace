package com.minssam.shoppingapp.main;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.minssam.shoppingapp.config.ConfigMain;
import com.minssam.shoppingapp.customer.CustomerMain;
import com.minssam.shoppingapp.member.LoginForm;
import com.minssam.shoppingapp.member.MemberMain;
import com.minssam.shoppingapp.order.OrderMain;
import com.minssam.shoppingapp.product.ProductMain;

public class AppMain extends JFrame implements ActionListener{
	JPanel p_north;
	String[] menu_title= {"상품관리","회원센터","주문관리","고객센터","Login","환경설정"};
	CustomButton[] bt_menu = new CustomButton[menu_title.length];
	
	//페이지 교체 패널
	JPanel p_center;
	
	//페이지 선언
	Page[] pages = new Page[6];
	
	/*
	ProductMain productMain;
	MemberMain memberMain;
	OrderMain orderMain;
	CustomerMain customerMain;
	LoginForm loginForm;
	ConfigMain configMain;
	*/
	
	//데이터 베이스 관련
	String driver="com.mysql.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/shoppingapp?characterEncoding=UTF-8";
	String user="root";
	String password="1234";
	private Connection con;
	//디폴트면 같은 패키지 내에서만 접근이 가능
	
	

	public Connection getCon() {
		return con;
	}


	public void setCon(Connection con) {
		this.con = con;
	}


	public AppMain() {
		connect();
		//생성
		p_north = new JPanel();
		for(int i=0;i<menu_title.length ;i++) {
			bt_menu[i] = new CustomButton(menu_title[i]);
			bt_menu[i].setId(i);
		}
		
		//페이지 생성
		p_center = new JPanel();
		pages[0] = new ProductMain(this);
		pages[1] = new MemberMain(this);
		pages[2] = new OrderMain(this);
		pages[3] = new CustomerMain(this);
		pages[4] = new LoginForm(this);
		pages[5] = new ConfigMain(this);
		
		
		//스타일
		
		//조립
		for (JButton bt: bt_menu) {
			p_north.add(bt);
		}
		add(p_north,BorderLayout.NORTH);
		
		for (Page p : pages) {
			p_center.add(p);			
		}
		/*
		p_center.add(productMain);
		p_center.add(memberMain);
		p_center.add(orderMain);
		p_center.add(customerMain);
		p_center.add(loginForm);
		p_center.add(configMain);
		*/
		add(p_center);
		
		
		//리스너
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				disConnect();
				System.exit(0);
			}
		});
		
		for(int i=0;i<bt_menu.length;i++) {
			bt_menu[i].addActionListener(this);			
		}
		
		//보여주기
		setBounds(1600, 100, 1200, 700);
		setVisible(true);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		//obj는 오브젝트 자료형이기 때문에, 버튼을 가리킬수는 있지만, 버튼 보다는 보편적인 기능만을 가지고
		//있기 때문에, 즉 가진게 별로 없어서 버튼의 특징을 이용하기 위해선 형변환을 이용해서 사용하자.
		CustomButton bt = (CustomButton)obj;
//		System.out.println(bt.getText());
		
		
		for (int i = 0; i < pages.length; i++) {
			if(bt.getId()==i) {
				pages[i].setVisible(true);
			}else {
				pages[i].setVisible(false);				
			}
		}
	}

	public void connect() {
		try {
			Class.forName(driver);//드라이버 로드
			con = DriverManager.getConnection(url,user,password);
			if(con!=null) {
				this.setTitle("접속 성공");
			}else {
				this.setTitle("접속 성공");				
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void disConnect() {
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	//쿼리문이 DML인 경우
	public void releases(PreparedStatement pstmt) {
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	//select문도 있는경우
	public void releases(PreparedStatement pstmt, ResultSet rs) {
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		new AppMain();
	}

}
