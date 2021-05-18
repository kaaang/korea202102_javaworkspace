package db.member;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MemberApp extends JFrame{

	JPanel p_north, p_west, p_center;
	//북쪽
	JTextField t_url, t_port;
	JButton bt_connect;
	//서쪽
	JTextField t_user_id;
	JPasswordField t_password;
	JTextField t_name;
	JButton bt_regist, bt_list;
	//센터
	JTextArea area;
	JScrollPane scroll;
	
	Connection con;
	
	public MemberApp() {
		//생성
		p_north = new JPanel();
		p_west = new JPanel();
		p_center = new JPanel();
		
		t_url = new JTextField("localhost");
		t_port = new JTextField("3306");
		bt_connect = new JButton("접속");
		
		t_user_id = new JTextField(15);
		t_password = new JPasswordField(15);
		t_name = new JTextField(15);
		bt_regist = new JButton("등록");
		bt_list = new JButton("목록");
		
		area = new JTextArea();
		scroll = new JScrollPane(area);
		
		//스타일
		t_url.setPreferredSize(new Dimension(470,25));
		t_port.setPreferredSize(new Dimension(120,25));
		
		p_west.setPreferredSize(new Dimension(200, 550));
		p_west.setBackground(Color.LIGHT_GRAY);
		
		//조립
		p_north.add(t_url);
		p_north.add(t_port);
		p_north.add(bt_connect);
		
		p_west.add(t_user_id);
		p_west.add(t_password);
		p_west.add(t_name);
		p_west.add(bt_regist);
		p_west.add(bt_list);
		
		
		
		add(p_north, BorderLayout.NORTH);
		add(p_west, BorderLayout.WEST);
		add(scroll, BorderLayout.CENTER);
		
		
		//리스너
		bt_connect.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//입력한 url및 포트번호를 이용하여 mysql 접속
				connect();
			}
		});
		
		//위도우와 리스너 연결
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("윈도우 닫음");
				disConnect();
				//프로세스 죽이기
				System.exit(0);
			}
		
		});
		
		
		//동록 버튼과 리스너 연렬
		bt_regist.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				regist();
				getList();
			}
		});
		
		bt_list.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getList();
			}
		});
		
		
		
		
		//보여주기
		setBounds(2000, 100, 700, 600);
		setVisible(true);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);//이 메서드는 윈두우창 닫을때 반환할게 있으면 호출하면 안된다.
		//이유 : windowListener의 windowClosing()메서드에서 반납할 자원을 처리해야하기 때문에
	}
	
	//DB접속 메서드
	public void connect() {
		//드라이버 로드
		try {
			Class.forName("com.mysql.jdbc.Driver");
			area.append("드라이버 로드 성공\n");
			
			String url = "jdbc:mysql://"+t_url.getText()+":"+t_port.getText()+"/javase?characterEncoding=UTF-8";
			
			con=DriverManager.getConnection(url,"root","1234");
			if(con != null) {
				area.append("접속 성공\n");
			}else {
				area.append("접속 실패\n");
			}
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			area.append("드라이버 로드 실패\n");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void getList() {
		area.setText("");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from member";
		
		try {
			pstmt=con.prepareStatement(sql);
			rs = pstmt.executeQuery();//수행할 쿼리가 select문인 경우 ResultSet 반환됨;
			
			//rs의 커서를 움직여가면서 모든 레코드에 접근하여 area에 출력해보자
			while(rs.next()) {
				int member_id = rs.getInt("member_id");
				String user_id = rs.getString("user_id");
				String password = rs.getString("password");
				String name = rs.getString("name");
				String regdate = rs.getString("regdate");
				area.append("------------------------------------------------------------------------------------------------------------------------\n");
				area.append(member_id+"\t"+user_id+"\t"+password+"\t"+name+"\t"+regdate+"\n");
				area.append("------------------------------------------------------------------------------------------------------------------------\n");
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs!=null)try {rs.close();}catch(SQLException e) {e.printStackTrace();}
			if(pstmt!=null)try {pstmt.close();}catch(SQLException e) {e.printStackTrace();}

		}
	}
	
	//mysql에 insert쿼리문 실행
	public void regist() {
		//아래의 PreparedStatement 는 쿼리문마다 1회성으로 생성해야 한다.
		PreparedStatement pstmt = null;
		String sql = "insert into member(user_id, password, name) values(?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);//sql문을 이용하여, pstmt 객체 생성
			//수행할 쿼리 유형이 DML(insert, update, delete)인 경우 executeUpdate()
			
			//바인드 변수값 설정
			pstmt.setString(1,t_user_id.getText());
			//password는 char배열로 생성 후, 다시 String으로 변환하여 사용하자.
			char[] ch = t_password.getPassword();
			String pass = new String(ch);
			pstmt.setString(2,pass);
			pstmt.setString(3,t_name.getText());
			
			int result = pstmt.executeUpdate();
			if(result == 1) {
				area.append("회원 등록 성공 \n");
			}else {
				area.append("회원 등록 실패 \n");//에러는 아니고, 그냥 안들어간것
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
	
	//DB접속 해제 메서드
	public void disConnect() {
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public static void main(String[] args) {
		new MemberApp();
	}
}
