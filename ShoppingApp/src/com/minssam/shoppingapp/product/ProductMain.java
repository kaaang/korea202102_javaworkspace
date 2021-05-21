package com.minssam.shoppingapp.product;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.minssam.shoppingapp.main.AppMain;
import com.minssam.shoppingapp.main.Page;
import com.minssam.shoppingapp.model.domain.Subcategory;
import com.minssam.shoppingapp.model.domain.Topcategory;


//상품관리 메인페이지
public class ProductMain extends Page{
	//AppMain에 데이터 베이스 관련 정보
	
	JPanel p_west;
	Choice ch_top;
	Choice ch_sub;
	JTextField t_product_name;
	JTextField t_price;
	JTextField t_brand;
	JTextArea t_detail;
	JScrollPane scroll;
	JButton bt_web;
	JButton bt_file;
	Canvas can;
	JButton bt_regist;
	
	//choice 컴포넌트는 html의 option과 달리 텍스트, value값을 동시에 담을 수 없다.
	//따라서 우리가 이 부분을 복합 데이터 형태로 직접 만들어서 해결해보자.
	ArrayList<Topcategory> topList=new ArrayList<Topcategory>();//size0 아무것도 채워진게 없다.
	ArrayList<Subcategory> subList=new ArrayList<Subcategory>();
	
	JPanel p_center;
	JPanel p_search;
	Choice ch_category;
	JTextField t_keyword;
	JButton bt_search;
	JTable table;
	JScrollPane table_scroll;
	
	JPanel p_east;
	Choice ch_top2;
	Choice ch_sub2;
	JTextField t_product_name2;
	JTextField t_price2;
	JTextField t_brand2;
	JTextArea t_detail2;
	JScrollPane scroll2;
	JButton bt_web2;
	JButton bt_file2;
	Canvas can2;
	JButton bt_regist2;
	
	Toolkit kit=Toolkit.getDefaultToolkit();
	Image image;//등록시 이미지 미리보기에 사용할 이미지
	
	
	public ProductMain(AppMain appMain) {
		super(appMain);
		setBackground(Color.YELLOW);
		
		p_west = new JPanel();
		ch_top = new Choice();
		ch_sub = new Choice();
		t_product_name = new JTextField();
		t_price = new JTextField();
		t_brand = new JTextField();
		t_detail = new JTextArea();
		scroll = new JScrollPane(t_detail);
		bt_web = new JButton("웹어서찾기");
		bt_file = new JButton("파일찾기");
		can = new Canvas() {
			//내부 익명 클래스는 외부 클래스의 멤버(변수,메서드)들을 내것처럼 접근 가능
			@Override
			public void paint(Graphics g) {
				g.drawImage(image, 0, 0, 180, 180, can);
			}
		};
		bt_regist = new JButton("상품등록");
		
		p_center = new JPanel();
		p_search = new JPanel();
		ch_category = new Choice();
		t_keyword = new JTextField();
		bt_search = new JButton("search");
		table = new JTable(10,7);
		table_scroll = new JScrollPane(table);
		
		
		p_east = new JPanel();
		ch_top2 = new Choice();
		ch_sub2 = new Choice();
		t_product_name2 = new JTextField();
		t_price2 = new JTextField();
		t_brand2 = new JTextField();
		t_detail2 = new JTextArea();
		scroll2 = new JScrollPane(t_detail);
		bt_web2 = new JButton("웹어서찾기");
		bt_file2 = new JButton("파일찾기");
		can2 = new Canvas();
		bt_regist2 = new JButton("상품등록");
		
		//스타일
		setLayout(new BorderLayout());
		Dimension d = new Dimension(180, 30);
		
		
		p_west.setPreferredSize(new Dimension(200, 700));
		scroll.setPreferredSize(new Dimension(180, 160));
		ch_top.setPreferredSize(d);
		ch_sub.setPreferredSize(d);
		t_product_name.setPreferredSize(d);
		t_price.setPreferredSize(d);
		t_brand.setPreferredSize(d);
		can.setPreferredSize(new Dimension(180,180));
		can.setBackground(Color.CYAN);
		
		
		ch_category.setPreferredSize(d);
		t_keyword.setPreferredSize(new Dimension(450, 30));
		p_search.add(ch_category);
		p_search.add(t_keyword);
		p_search.add(bt_search);
		p_center.setLayout(new BorderLayout());
		p_center.add(p_search, BorderLayout.NORTH);
		p_center.add(table_scroll);
		
		
		p_east.setPreferredSize(new Dimension(200, 700));
		scroll2.setPreferredSize(new Dimension(180, 160));
		ch_top2.setPreferredSize(d);
		ch_sub2.setPreferredSize(d);
		t_product_name2.setPreferredSize(d);
		t_price2.setPreferredSize(d);
		t_brand2.setPreferredSize(d);
		can2.setPreferredSize(new Dimension(180,180));
		can2.setBackground(Color.CYAN);
		
		//조립
		p_west.add(ch_top);
		p_west.add(ch_sub);
		p_west.add(t_product_name);
		p_west.add(t_price);
		p_west.add(t_brand);
		p_west.add(scroll);
		p_west.add(bt_web);
		p_west.add(bt_file);
		p_west.add(can);
		p_west.add(bt_regist);
		
		p_east.add(ch_top2);
		p_east.add(ch_sub2);
		p_east.add(t_product_name2);
		p_east.add(t_price2);
		p_east.add(t_brand2);
		p_east.add(scroll2);
		p_east.add(bt_web2);
		p_east.add(bt_file2);
		p_east.add(can2);
		p_east.add(bt_regist2);
		
		add(p_west, BorderLayout.WEST);
		add(p_east, BorderLayout.EAST);
		add(p_center);
		
		//리스너
		ch_top.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				//지금 선택한 상위 카테고리의 pk값을 알아맞추려면
				Choice ch = (Choice)e.getSource();
//				System.out.println(ch.getSelectedIndex());
				
				//유저가 현재 선택한 Choice에서의 아이템을 이용하여 ArryList의 객체를 꺼내자
				int index =ch.getSelectedIndex()-1; 
				Topcategory topcategory = topList.get(index);//topList에서 VO한개 꺼내기
//				System.out.println(topcategory.getTop_name());
//				System.out.println(topcategory.getTopcategory_id());
				getSubList(topcategory.getTopcategory_id());
			}
		});
		
		//파일찾기 버튼과 리스너 연결
		bt_file.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				image = kit.getImage("D:\\korea202102_jsworkspace\\images\\rai\\1.jpg");
				can.repaint();
			}
		});
		
		
		getTopList();
	}
	
	//왼쪽 영역의 TopCategory가져오기
	public void getTopList() {
		PreparedStatement pstmt = null;
		ResultSet rs = null; //select문이기 때문에
		String sql = "select * from topcategory";
		try {
			pstmt=this.getAppMain().getCon().prepareStatement(sql);
			rs=pstmt.executeQuery();//select문 실행 후 레코드 반환
			ch_top.add("Choose Category");
			while(rs.next()) {
				ch_top.add(rs.getString("top_name"));
				//Empty상태의 인스턴스 한개 생성, 이 안에 카테고리 이름 + pk을 넣어두자
				Topcategory topcategory = new Topcategory();
				topcategory.setTopcategory_id(rs.getInt("topcategory_id"));
				topcategory.setTop_name(rs.getString("top_name"));
				topList.add(topcategory);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			getAppMain().releases(pstmt,rs);
		}
		
	}
	
	//왼쪽 영역의 subcategory나오게
	public void getSubList(int topcategory_id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql="select * from subcategory where topcategory_id="+topcategory_id;
		
		try {
			pstmt=this.getAppMain().getCon().prepareStatement(sql);
			rs=pstmt.executeQuery();
			//기존 아이템 지우기
			ch_sub.removeAll();
			subList.removeAll(subList);
			
			ch_sub.add("choose category");
			while(rs.next()) {
				ch_sub.add(rs.getString("sub_name"));
				Subcategory subcategory = new Subcategory();
				subcategory.setSubcategory_id(rs.getInt("subcategory_id"));
				subcategory.setTopcategory_id(rs.getInt("topcategory_id"));
				subcategory.setSub_name(rs.getString("sub_name"));
				subList.add(subcategory);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			getAppMain().releases(pstmt, rs);
		}
	}
	
	
}
