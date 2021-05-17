package app0517.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//Mysql DB에 레코드 넣어보기!
//자바 언어로 데이터 베이스를 연동하는 기술을 가리켜 JDBC
//java.sql 패키지에서 대부분의 api를 제공해준다.

public class DBInsert {
	
	
	public static void main(String[] args) {
		//모든 DB작업 수행은 절차가 동일하다.
		//0)해당 DB에 알맞는 드라이버 클래스를 로드해야함
		//jar(Java Archive) : 자바의 클래스를 압축시켜놓은 확장자
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("로드 성공");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
			System.out.println("로드 실패");
		}//드라이버 클래스 로드
		
		
		//1)DB접속
		String url="jdbc:mysql://localhost:3306/javase?characterEncoding=UTF-8";
		String user = "root";
		String pass = "1234";
		Connection con=null;
		PreparedStatement pstmt = null;//쿼리문 수행 객체
		try {
			//아래의 코드에서 DriverManager에 의해 접속이 성공된 경우에만,
			//접속 정보를 가진 Connection 객체가 반환된다.
			//따라서 접속에 실패한 경우는 Connection 객체가 반환되지 않으므로 null로 초기화 된다.
			con = DriverManager.getConnection(url,user,pass);
			if(con == null) {
				System.out.println("접속 실패");
			}else {
				System.out.println("접속 성공");
				String sql = "insert into member(user_id, password, name)";
				sql += " values('batman','1111','배트맨')";
				
				//위의 작성한 쿼리문을 실행해보자
				pstmt = con.prepareStatement(sql);
				int result = pstmt.executeUpdate();//DML(insert, update, delete) 쿼리 실행
				if(result ==0) {
					System.out.println("입력 실패");
				}else {
					System.out.println("입력 성공");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		//2)쿼리 수행
		//3)접속 끊기
	}
}
