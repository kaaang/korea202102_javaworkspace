package db.oracle;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

class TestOracle{
   public static void main(String[] args){
      String url = "jdbc:oracle:thin:@localhost:1521:XE";//정해진 문자열 형식
      String user = "javase";
      String pass = "javase";

	  Connection con = null;
	  PreparedStatement pstmt = null;
	  ResultSet rs = null; //select문 수행 후 그 결과 표 집합을 담는 객체
      /*
      1.사용하려는 DB에 맞는 드라이버 로드(클래스 로드)
          Class.forName("원하는 클래스명")
      2.DB접속 
      3.쿼리문 수행
      4.DB관련 객체 해제
      */
      try{
         Class.forName("oracle.jdbc.driver.OracleDriver");
         System.out.println("드라이버 로드 성공");

         con = DriverManager.getConnection(url,user, pass);
		 if(con!=null){
			System.out.println("접속성공");

			//쿼리 실행이 아닌, 쿼리를 실행 할 수 있는 객체 생성 즉 준비만 한거다.
			pstmt = con.prepareStatement("select * from member");
			rs = pstmt.executeQuery();//select 문인 경우 반환 객체가 있기 때문에
			//ResultSet이 반환된 직후에는 어떠한 레코드도 가리키지 않고있다.
			while(rs.next()){

				/*
				int member_id = rs.getInt("member_id");
				String user_id = rs.getString("user_id");
				String password = rs.getString("password");
				String name = rs.getString("name");
				String regdate = rs.getString("regdate");
				*/
				
				//컬럼의 index로도 접근해보자
				int member_id=rs.getInt(1);
				String user_id=rs.getString(2);
				String password=rs.getString(3);
				String name=rs.getString(4);
				String regdate=rs.getString(5);


				System.out.println(member_id+"\t"+user_id+"\t"+password+"\t"+name+"\t"+regdate);
			}
			
			
			
		 }else{
			 System.out.println("접속 실패");
		 }
		 
      }catch(ClassNotFoundException e){
         e.printStackTrace(); //개발자가 원인을 분석하기 위한 출력
         System.out.println("드라이버 로드 실패");//유저를 위한 친절한 메시지
      }catch(SQLException e){
		  //DriverManaget.getconnection()으로 접속을 시도하다가 에러가 나도 SQLException, 뭐리수행시 에러나도 이거임
		  //즉 sun에서 세분화 시키지 않았다.
		  System.out.println("접속 실패");
		  e.printStackTrace();
	  }finally{
		  if(rs != null){
			  try{
				rs.close();
			  }catch(SQLException e){
				  e.printStackTrace();
			  }
		  }
		  if(pstmt != null){
			  try{
				pstmt.close();
			  }catch(SQLException e){
				  e.printStackTrace();
			  }
		  }
		  if(con != null){
			  try{
				con.close();
			  }catch(SQLException e){
				  e.printStackTrace();
			  }
		  }
		  
	  }

   }
}