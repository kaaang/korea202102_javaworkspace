package jtable.vector;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

//notice 게시판 전용 TableModel
public class NoticeModel extends AbstractTableModel{

	Vector<Notice> data=new Vector<Notice>();//기존의 데이터를 처리했던 이차원 배열을 대신한 컬렉션 객체
	Vector<String> column=new Vector<String>();//기존의 컬럼명을 처리했던 일차원 배열을 대신할 컬렉션 객체
	
	public int getRowCount() {
		return data.size();//VO가 담겨진 벡터의 크기
	}

	public int getColumnCount() {
		return column.size();
	}
	
	public String getColumnName(int col) {
		return column.get(col);
	}

	public Object getValueAt(int row, int col) {
		//row로 벡터의 index를 접근한다.
		String value=null;
		Notice notice = data.get(row);
		if(col==0) {
			value=Integer.toString(notice.getNotice_id());
		}
		else if(col==1) {
			value=notice.getTitle();
		}
		else if(col==2) {
			value=notice.getWriter();
		}
		else if(col==3) {
			value=notice.getContent();
		}
		else if(col==4) {
			value=notice.getRegdate();
		}
		else if(col==5) {
			value=Integer.toString(notice.getHit());
		}
		return value;
	}

}
