package db.table.model;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

/*
 * JTable이 사용할 데이터를, TableModel을 이용해서 유지보수 개선
 * TableModel : JTable과 같은 디자인 영역에서 실제 데이터에 직접 접근하지 말고, 중간 계층을 통해 작업을 진행.
 * -> 추후 JTable이 변경될 때 데이터를 처리하는 로직은 영향을 받지 않으므로 어플리케이션의 유지보수성 상승.
 * TableModel은 JTable이 사용하려는 데이터를 간접적으로 사용할 수 있게 도와주는 컨트롤러*/
public class UseModelApp extends JFrame{
   JTable table;
   JScrollPane scroll;
   String[] columnName= {"member_id","user_id","password","name","regdate"};
//   String[][] rows = new String[3][columnName.length];
   String[][] rows= {};
   JTextArea area;
   
   JPanel p_west;
   JTextField t_user_id;
   JPasswordField t_password;
   JTextField t_name;
   JButton bt_regist, bt_del;
   String value;//현재는 null이다. 따라서 한번도 레코드를 선택하지 않았다면 여전히 null일것이다.

   
   
   
   String url="jdbc:mysql://localhost:3306/javase?characterEncording=UTF-8";
   String user = "root";
   String password = "1234";
   Connection con;
   
   UseModelApp uma = this;
   
   int row; //현재 사용자가 jtable 마우스로 선택한 레코드

   public UseModelApp() {
      table = new JTable(new AbstractTableModel() {
         //총 레코드 수를 반환하는 메서드. JTable 이 호출.
         public int getRowCount() {
            return rows.length;
         }
         //총 컬럼 수 반환하는 메서드. JTable이 호출
         public int getColumnCount() {
            return columnName.length;
         }
         public String getColumnName(int col) {
            return columnName[col];
         }
         //row, col의 좌표에 어떤 데이터가 있는지 반환하는 메서드. JTable이 호출.
         public Object getValueAt(int row, int col) {
//            System.out.println("getvalueAt("+row+","+col+")");
            return rows[row][col];
         }
      });//테이블모델 객체 이용가능
      
      scroll = new JScrollPane(table);
      area = new JTextArea();
      
      p_west = new JPanel();
      t_user_id = new JTextField(15);
      t_password = new JPasswordField(15);
      t_name = new JTextField(15);
      bt_regist = new JButton("등록");
      bt_del = new JButton("삭제");
      
      
      scroll.setPreferredSize(new Dimension(600,400));
      area.setPreferredSize(new Dimension(600, 150));
      p_west.setPreferredSize(new Dimension(200,400));
      
      add(scroll);
      add(area,BorderLayout.SOUTH);
      p_west.add(t_user_id);
      p_west.add(t_password);
      p_west.add(t_name);
      p_west.add(bt_regist);
      p_west.add(bt_del);
      add(p_west,BorderLayout.WEST);
      
      
      //동록 버튼과 리스너 연결
      bt_regist.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			regist();
		}
      });
      bt_del.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(value!=null) {
				int res = JOptionPane.showConfirmDialog(uma, "삭제하시겠습니까?");	
				if(res == JOptionPane.OK_OPTION) {
					del();
				}
			}else {
				JOptionPane.showMessageDialog(uma, "삭제 대상을 선택하세요");								
			}
		}
	});
      
      //석제 버튼과 리스너 연결
      
      
      table.addMouseListener(new MouseAdapter() {
    	  @Override
    	public void mouseReleased(MouseEvent e) {
    		  area.append("test\n");
    		  row = table.getSelectedRow();
    		  int col = table.getSelectedColumn();
    		  value = (String)table.getValueAt(row, col);
    		  area.setText("");
    		  area.append("member_id : "+table.getValueAt(row, 0)+"\n");
    		  area.append("아이디 : "+table.getValueAt(row, 1)+"\n");
    		  area.append("비밀번호 : "+table.getValueAt(row, 2)+"\n");
    		  area.append("이름 : "+table.getValueAt(row, 3)+"\n");
    		  area.append("가입일 : "+table.getValueAt(row, 4)+"\n");
    	  }
      });
      
      //윈도우와 리스너 연결
      this.addWindowListener(new WindowAdapter() {
    	  @Override
    	public void windowClosing(WindowEvent e) {
    		  if(con!=null) {
    			  try {
					con.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
    		  }
    		  System.exit(0);
    	  }
      });
      setBounds(500,100,800,400);
      setVisible(true);
      connect();
   }
   public void connect() {
      try {
         Class.forName("com.mysql.jdbc.Driver");
         con = DriverManager.getConnection(url, user, password);
         if(con==null) {
//        	 JOptionPane.showMessageDialog(this, "MySQL 접속 실패");
        	 JOptionPane.showMessageDialog(UseModelApp.this, "MySQL 접속 실패");
         }else {
        	 getList();
         }
      } catch (ClassNotFoundException e) {
         e.printStackTrace();
      
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }
   
   public void getList() {
	   PreparedStatement pstmt = null;
	   ResultSet rs = null;
	   String sql = "select * from member";
	   
	   try {
		pstmt = con.prepareStatement(sql
				,ResultSet.TYPE_SCROLL_INSENSITIVE
				,ResultSet.CONCUR_READ_ONLY);
		rs=pstmt.executeQuery();
		rs.last();//커서를 마지막 레코드로 보내기
		int total = rs.getRow();
		
		String[][] data = new String[total][columnName.length];//empty 이차원 배열 생성
		rs.beforeFirst();
		
		int index = 0;
		while(rs.next()) {
			data[index][0]=Integer.toString(rs.getInt("member_id"));
			data[index][1]=rs.getString("user_id");
			data[index][2]=rs.getString("password");
			data[index][3]=rs.getString("name");
			data[index][4]=rs.getString("regdate");
			index++;
		}
		
		//데이터 갱신
		rows=data;
		table.updateUI();//디자인 갱신
		
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(pstmt!=null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
   }
   
   public void regist() {
	   PreparedStatement pstmt = null;
	   String sql = "insert into member(user_id, password, name) valuse(?,?,?)";
	   try {
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, t_user_id.getText());
		pstmt.setString(2, new String(t_password.getPassword()));
		pstmt.setString(3, t_name.getText());
		
		int result = pstmt.executeUpdate();
		if(result == 1) {
			JOptionPane.showMessageDialog(this, "등록 성공");
			getList();
		}else {
			JOptionPane.showMessageDialog(this, "등록 실패");
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
	}
	   
   }
   public void del() {
//	   System.out.println("deldeldeldeldeldeldeldeldeldeldeldel");
	   PreparedStatement pstmt = null;
	   //언박싱
	   int member_id = Integer.parseInt((String)table.getValueAt(row, 0));
	   String sql = "delete from member where member_id="+member_id;
	   try {
		   pstmt=con.prepareStatement(sql);
		   int result = pstmt.executeUpdate();
		   if(result > 0) {
			   JOptionPane.showMessageDialog(this, "삭제성공");
			   getList();
		   }else {
			   JOptionPane.showMessageDialog(this, "삭제실패");			   
		   }
	   } catch (SQLException e) {
		   e.printStackTrace();
	   }finally {
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	   
   }
   
   public static void main(String[] args) {
      new UseModelApp();
   }


   
}