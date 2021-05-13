package app0513.colorbox;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ButtonMain extends JFrame implements ActionListener{

	JPanel p_north;
	JTextField t_ea;
	JButton bt_create;
	JButton bt_create2;
	JButton bt_bg;
	JPanel p_center;
	JButton[] btnArray;
	
	int count=0;
	//JButton[] btnArray2;
	
	//배열과 거의 같지만, 크기가 동적으로 변할 수 있는 컬렉션 프레임 웍 중 List계열을 이용해보자.
	ArrayList<JButton> list = new ArrayList<JButton>();
	
	public ButtonMain() {
		p_north = new JPanel();
		t_ea = new JTextField(10);
		bt_create = new JButton("Create");
		bt_create2 = new JButton("낱개생성");
		bt_bg = new JButton("Color");
		p_center = new JPanel();
		
		p_north.setPreferredSize(new Dimension(500, 50));
		p_center.setBackground(Color.YELLOW);
		
		p_north.add(t_ea);
		p_north.add(bt_create);
		p_north.add(bt_create2);
		p_north.add(bt_bg);
		add(p_north,BorderLayout.NORTH);
		add(p_center);
		bt_create.addActionListener(this);
		bt_create2.addActionListener(this);
		bt_bg.addActionListener(this);
		
		setBounds(2000, 100, 500, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

	public void create() {
		//1.텍스트 필드의 값 구하기
		int ea = Integer.parseInt(t_ea.getText());
		btnArray = new JButton[ea];
		//2.갯수만큼 센터에 붙이기
		for (int i = 0; i < ea; i++) {
			JButton bt = new JButton("BT"+i);
			p_center.add(bt);
			btnArray[i]=bt;
		}
		p_center.updateUI();
	}
	
	public void createOne() {
		JButton bt = new JButton("버튼"+count);
		p_center.add(bt);
		p_center.updateUI();
		//btnArray2[count] = bt;
		list.add(bt);
		count++;
	}
	
	public void setBg() {
		for (int i = 0; i < btnArray.length; i++) {
			btnArray[i].setBackground(Color.RED);
		}
		for(JButton btn : list) {
			btn.setBackground(Color.CYAN);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == bt_create) {
			create();
		}else if(e.getSource()==bt_create2) {
			createOne();
		}else if(e.getSource()==bt_bg) {
			setBg();
		}
	}
	
	
	
	public static void main(String[] args) {
		new ButtonMain();
	}



}
