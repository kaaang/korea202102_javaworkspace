package app0517.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBSelect {
	
	String driver="com.mysql.jdbc.Driver";//mysql용 드라이버 경로
	String url="jdbc:mysql://localhost:3306/javase?characterEncoding=UTF-8";
	String id="root";
	String pass="1234";
	Connection con; //다른 프로그래밍 언어에서는 접속을 시도하는 객체지만 jdbc에서는 접속 성공 후 접속 정보를 가진 객체이다.
							//즉 접속 시도는 DriverManager 객체가 담당한다.
							//따라서 이 객체가 null이라면, 아직 접속이 된적이 없다는 것이다.
	PreparedStatement pstmt;
	ResultSet rs; //select문 수행 후 그결과집합은 표 구조이기에, 이 표 구조를 표현한 객체가 바로 ResultSet이다.
						//결국 2차원 구조의 데이터 집합이다.
	
	public DBSelect() {
		/* 1)드라이버 로드(해당 제품DB를 제어하기 위한 jar)
		 * 2)접속
		 * 3)원하는 쿼리 수행
		 * 4)db접속 해제
		 * */
		try {
			Class.forName(driver);
			System.out.println("드라이버 로드 성공");
			
			//접속
			con = DriverManager.getConnection(url, id, pass);
			if(con == null) {
				System.out.println("접속 실패");
			}else {
				System.out.println("접속 성공");
				
				//쿼리문 수행하기(select문)
				String sql = "select * from member order by member_id desc";
				pstmt = con.prepareStatement(sql);//쿼리문 수행 객체 생성(아직 쿼리 수행 안함)
				rs = pstmt.executeQuery();//select문의 경우엔 executeQuery()메서드, DML(insert, update, delete)일때는 executeUpdate() 수행
				System.out.println("반환된 객체는 "+rs);
			}
			
			
			
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("드라이버 로드 실패 : 해당 드라이버 찾을 수 없음");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
		
		
		
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		new DBSelect();
	}
}
