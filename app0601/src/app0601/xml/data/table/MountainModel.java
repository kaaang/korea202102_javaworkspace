package app0601.xml.data.table;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class MountainModel extends AbstractTableModel{

	Vector<Mountain> data = new Vector<Mountain>();
	Vector<String> column = new Vector<String>();
	
	
	public MountainModel(){
		String[] title = {"산소세지","상세설명","산높이","산일련번호","산 이름"};
		for(int i=0;i<title.length;i++) {
			column.add(title[i]);
		}
	}
	public int getRowCount() {
		return data.size();
	}

	public int getColumnCount() {
		return column.size();
	}

	public String getColumnName(int col) {
		return column.get(col);
	}
	public Object getValueAt(int row, int col) {
		Mountain mt = data.get(row);
		String value=null;
		if(col==0) {
			value=mt.getMntiadd();
		}else if(col==1) {
			value=mt.getMntidetails();
		}else if(col==2) {
			value=mt.getMntihigh();
		}else if(col==3) {
			value=Integer.toString(mt.getMntilistno());
		}else if(col==4) {
			value=mt.getMntiname();			
		}
		return value;
	}

}
