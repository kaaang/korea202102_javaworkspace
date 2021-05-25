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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.minssam.shoppingapp.main.AppMain;
import com.minssam.shoppingapp.main.Page;
import com.minssam.shoppingapp.model.domain.Subcategory;
import com.minssam.shoppingapp.model.domain.Topcategory;
import com.minssam.shoppingapp.util.FileManager;


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
	JButton bt_excel;//엑셀을 이용한 일괄 등록
	JTable table;
	JScrollPane table_scroll;
	
	JPanel p_east;
	JTextField t_top;
	JTextField t_sub;
	JTextField t_product_name2;
	JTextField t_price2;
	JTextField t_brand2;
	JTextArea t_detail2;
	JScrollPane scroll2;
	JButton bt_web2;
	JButton bt_file2;
	Canvas can2;
	JButton bt_del;
	
	JFileChooser chooser;
	Toolkit kit=Toolkit.getDefaultToolkit();
	Image image;//등록시 이미지 미리보기에 사용할 이미지
	Image image2;
	String filename;
	
	
	//컬럽배열
	String[] columns= {"product_id","subcategory_id","product_name","price","brane","detail","filename"};
	//레코드배열
	String[][] records= {};
	
	int product_id;
	String del_file;
	
	
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
		bt_web = new JButton("웹에서찾기");
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
		//검색 카테로기 등록
		ch_category.add("choose category");
		ch_category.add("product_name");
		ch_category.add("price");
		ch_category.add("brand");
		t_keyword = new JTextField();
		bt_search = new JButton("search");
		table = new JTable(new AbstractTableModel() {
			@Override
			public int getRowCount() {
				return records.length;
			}
			@Override
			public int getColumnCount() {
				return columns.length;
			}
			//컬럼의 제목을 배열로부터 구한다.
			@Override
			public String getColumnName(int col) {
				return columns[col];
			}
			//각 셀에 들어갈 데이터를 이차원 배열로 부터 구한다.
			@Override
			public Object getValueAt(int row, int col) {
				return records[row][col];
			}
			@Override
			//jtable의 각 셀의 값을 지정
			//셀을 편집한 후, 엔터치는 순간 아래의 메서드 호출됨
			public void setValueAt(Object value	, int row, int col) {
				System.out.println(row+","+col+" 번째의 셀의 데이터는"+value+"로 바꿀게요");
				records[row][col]=(String)value;
				updateProduct();
			}
			
			@Override
			public boolean isCellEditable(int row, int col) {
				if(col==0) {
					return false;
				}else {
					return true;					
				}
			}
		});
		bt_excel = new JButton("엑셀등록");
		table_scroll = new JScrollPane(table);
		
		
		p_east = new JPanel();
		t_top = new JTextField();
		t_sub = new JTextField();
		t_product_name2 = new JTextField();
		t_price2 = new JTextField();
		t_brand2 = new JTextField();
		t_detail2 = new JTextArea();
		scroll2 = new JScrollPane(t_detail2);
		bt_web2 = new JButton("웹에서찾기");
		bt_file2 = new JButton("파일찾기");
		can2 = new Canvas() {
			@Override
			public void paint(Graphics g) {
				g.drawImage(image2, 0, 0,180,180, can2);
			}
		};
		bt_del = new JButton("상품삭제");
		
		chooser = new JFileChooser("D:\\korea202102_jsworkspace\\images\\rai");
		
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
		t_keyword.setPreferredSize(new Dimension(300, 30));
		p_search.add(ch_category);
		p_search.add(t_keyword);
		p_search.add(bt_search);
		p_search.add(bt_excel);
		p_center.setLayout(new BorderLayout());
		p_center.add(p_search, BorderLayout.NORTH);
		p_center.add(table_scroll);
		
		
		p_east.setPreferredSize(new Dimension(200, 700));
		scroll2.setPreferredSize(new Dimension(180, 160));
		t_top.setPreferredSize(d);
		t_sub.setPreferredSize(d);
		t_product_name2.setPreferredSize(d);
		t_price2.setPreferredSize(d);
		t_brand2.setPreferredSize(d);
		can2.setPreferredSize(new Dimension(180,180));
		can2.setBackground(Color.YELLOW);
		
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
		
		p_east.add(t_top);
		p_east.add(t_sub);
		p_east.add(t_product_name2);
		p_east.add(t_price2);
		p_east.add(t_brand2);
		p_east.add(scroll2);
		p_east.add(bt_web2);
		p_east.add(bt_file2);
		p_east.add(can2);
		p_east.add(bt_del);
		
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
				findLocal();
			}
		});
		
		//웹에서 파일 찾기 버튼과 리스너 연결
		bt_web.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				findWeb();
			}
		});
		
		bt_regist.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//유효선 체크 통과되면 아래의 두 메서드 호출
				//숫자값을 문자로 입력할 경우 문제가 심각함
				try {
					Integer.parseInt(t_price.getText());
					regist();
					getProductList();
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(ProductMain.this.getAppMain(), "가격은 숫자를 입력하세요");
					t_price.setText("");
					t_price.requestFocus();
				}

				
				
			}
		});
		
		//엑셀 버튼과 리스너 연결
		bt_excel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				registByExcel();
			}
		});
		
		bt_search.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//검색을 안할경우 모든 데이터가 나오게
				if(ch_category.getSelectedIndex()==0 && t_keyword.getText().length()==0) {
					getProductList();
				}else {
					//검색을 하면 검색 결과만 나오게
					getListBySearch();					
				}
			}
		});
		
		
		//테이블과 리스너 연결
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				getDetail();
			}
		});
		
		bt_del.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(ProductMain.this.getAppMain(), "삭제?")==JOptionPane.OK_OPTION) {
					deleteProduct();
				}
			}
		});
		
		
		getTopList();
		getProductList();
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
			getAppMain().release(pstmt,rs);
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
			getAppMain().release(pstmt, rs);
		}
	}
	
	
	//로컬 시스템에서 파일 찾아서 이미지 미리 보기 구현
	public void findLocal() {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		
		if(chooser.showOpenDialog(this.getAppMain())==JFileChooser.APPROVE_OPTION) {
			File file = chooser.getSelectedFile();
			image = kit.getImage(file.getAbsolutePath());
			can.repaint();			
			
			//유저가 선택한파일을 복사하자
			try {
				fis = new FileInputStream(file);
				long time = System.currentTimeMillis();
				filename = time+"."+FileManager.getExtend(file.getAbsolutePath(),"\\");
				fos =  new FileOutputStream("D:\\korea202102_javaworkspace\\ShoppingApp\\data\\"+filename);//복사될 경로
				
				//입력과 출력 스트림이 준비되었으므로, 복사를 시작하자.
				int data = -1;
				byte[] buff = new byte[1024]; //1kbyte의 버퍼 확보
				while(true) {
					data = fis.read(buff);//버퍼로 읽어들임
					if(data == -1) break;
					fos.write(buff);//버퍼로 내려씀
				}
				JOptionPane.showMessageDialog(this.getAppMain(), "복사완료");
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				if(fos!=null) {
					try {
						fos.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if(fis!=null) {
					try {
						fis.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			
			
		}
	}
	
	//웹에서 파일 찾아서 이미지 미리보기 구현
	public void findWeb() {
		String path = JOptionPane.showInputDialog(this.getAppMain(),"경로입력");
		//위의 경로를 이용하여, 웹 서버에 요청을 시도해본다.
		//HttpURLConnection
		URL url = null;
		HttpURLConnection httpCon = null;
		InputStream is = null;// 입력 스트림 계열의 최상위 객체
		FileOutputStream fos = null;
		
		try {
			url = new URL(path);
			httpCon = (HttpURLConnection)url.openConnection();
			httpCon.setRequestMethod("GET");
			
			is = httpCon.getInputStream();//웹서버의 요청과 관련된 스트림 얻기 쪽쪽쪽 빨아먹기
			long time = System.currentTimeMillis();
			filename = time+"."+FileManager.getExtend(path,"/");
			fos = new FileOutputStream("D:\\korea202102_javaworkspace\\ShoppingApp\\data\\"+filename);
			
			int data = -1;
			//버퍼를 사용하면 url을 사용해서 깨지는듯함
			while(true) {
				data = is.read();
				if(data==-1)break;
				fos.write(data);
			}
			JOptionPane.showMessageDialog(this.getAppMain(), "복사완료");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(is!=null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(fos!=null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		
	}
	
	
	public void regist() {
		//유효셩 체크하기
		
		
		PreparedStatement pstmt = null;
		String sql = "insert into product(subcategory_id, product_name, price, brand, detail, filename)";
		sql+=" values(?,?,?,?,?,?)";
		int index = ch_sub.getSelectedIndex()-1;
		
		//얻어진 초이스 컴포넌트의 index를 이용해서 vo가 들어있는 ArrayList에 접근해보자
		Subcategory subcategory =  subList.get(index);
		System.out.println("당신이 등록한 상품의 subcategory_id는 : " +subcategory.getSubcategory_id());
		
		try {
			pstmt = this.getAppMain().getCon().prepareStatement(sql);
			//바인드 변수값 처리
			pstmt.setInt(1, subcategory.getSubcategory_id());
			pstmt.setString(2, t_product_name.getText());
			pstmt.setInt(3, Integer.parseInt(t_price.getText()));
			pstmt.setString(4, t_brand.getText());
			pstmt.setString(5, t_detail.getText());
			pstmt.setString(6, filename);
			
			//쿼리실행DML
			int result = pstmt.executeUpdate();
			if(result==1) {
				JOptionPane.showMessageDialog(this.getAppMain(), "상품등록 성공");
			}else {
				JOptionPane.showMessageDialog(this.getAppMain(), "상품등록 실패");				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.getAppMain().release(pstmt);
		}
	}
	
	
	//상품목록 가져오기
	public void getProductList() {
		PreparedStatement pstmt = null;
		ResultSet rs = null; //select문 담기
		
		String sql="select product_id, sub_name, product_name, price, brand, detail, filename";
		sql +=" from subcategory s, product p";
		sql +=" where s.subcategory_id=p.subcategory_id";
		try {
			pstmt=this.getAppMain().getCon().prepareStatement(sql
					,ResultSet.TYPE_SCROLL_INSENSITIVE
					,ResultSet.CONCUR_READ_ONLY);
			rs=pstmt.executeQuery();
			rs.last();//커서를 마지막 레코드로 보냄
			int total = rs.getRow();
			
			//jtable이 참조하고 있는 records라는 이차원 배열의 값을, rs를 이용하여서 갱신해보자
			records=new String[total][columns.length];
			
			rs.beforeFirst();//커서 위치 제자리
			int index=0;
			while(rs.next()) {
				records[index][0]=Integer.toString(rs.getInt("product_id"));
				records[index][1]=rs.getString("sub_name");
				records[index][2]=rs.getString("product_name");
				records[index][3]=Integer.toString(rs.getInt("price"));
				records[index][4]=rs.getString("brand");
				records[index][5]=rs.getString("detail");
				records[index][6]=rs.getString("filename");
				index++;
			}
			//jtable갱신
			table.updateUI();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.getAppMain().release(pstmt,rs);
		}
	}
	
	
	//자바가 기본적으로 엑셀을 제어할 수 있는 api가 지원되지 않는다. 따라서 외부의 api를 이용해야한다.
	//apache 에서 개발한 라이브러리를 이용해보자
	//apache.org : 무료 소프트웨어 진영을 이끌고 있는 단체 -> POI jar
	public void registByExcel() {
		/*
		 * 1)엑셀파일에 접근한다.(빨대를 꽂아야한다.) -> 파일 인풋 스트림
		 * */
		String path = null;
		
		//유저가 선택한 엑셀 파일의 경로를 구한다.
		if(chooser.showOpenDialog(this.getAppMain()) == JFileChooser.APPROVE_OPTION) {
			File file = chooser.getSelectedFile();//파일 얻기
			path = file.getAbsolutePath();
		}else {
			JOptionPane.showMessageDialog(this.getAppMain(), "엑셀 파일을 선택해주세요");
			return;
		}
			
		FileInputStream fis=null;
		XSSFWorkbook workbook=null;
		PreparedStatement pstmt = null;
		Connection con = this.getAppMain().getCon();
		
		
		try {
			con.setAutoCommit(false);//자동 커밋을 막는다, 즉 커밋은 직접 주도하겠다.
			fis = new FileInputStream(path);
			//이 스트림을 통해 내부 데이터를 엑셀로 이해할 수 있도록 해석을 해야한다.
			//엑셀 파일을 처리하기 위한 객체 XSSFWorkbook
			workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet("product");//우리가 부여한 sheet명을 이용해서 접근
			
			//시트 객체를 ㅣ용해서 원하는 레코드에 접근해보자
			for(int i=1;i<sheet.getLastRowNum();i++) {
				XSSFRow row = sheet.getRow(i);
				
				int subcategory_id=0;
				String product_name=null;
				int price = 0;
				String brand=null;
				String detail=null;
				String filename=null;
				
				
				//컬럼 수 만큼 반복
				for(int j=0;j<row.getLastCellNum();j++) {
					XSSFCell cell = row.getCell(j);
					//숫자일경우, 문자일경우 메서드가 틀려서 결국 조건문으로 메서드 호출해야한다.
					if(j==0) {
						System.out.print(cell.getNumericCellValue());
						subcategory_id=(int)cell.getNumericCellValue();
					}else if(j==1) {
						System.out.print(cell.getStringCellValue());
						product_name=cell.getStringCellValue();
					}else if(j==2) {
						System.out.print(cell.getNumericCellValue());
						price=(int)cell.getNumericCellValue();
					}else if(j==3) {
						System.out.print(cell.getStringCellValue());
						brand=cell.getStringCellValue();
					}else if(j==4) {
						System.out.print(cell.getStringCellValue());
						detail=cell.getStringCellValue();
					}else if(j==5) {
						System.out.print(cell.getStringCellValue());
						filename=cell.getStringCellValue();
					}
				}
				System.out.println("");
				String sql = "insert into product(subcategory_id, product_name, price, brand, detail, filename)";
				sql += " values(?,?,?,?,?,?)";
				
				
				pstmt = this.getAppMain().getCon().prepareStatement(sql);
				pstmt.setInt(1, subcategory_id);
				pstmt.setString(2, product_name);
				pstmt.setInt(3, price);
				pstmt.setString(4, brand);
				pstmt.setString(5, detail);
				pstmt.setString(6, filename);
				
				//퀴리실행
				int result = pstmt.executeUpdate();
				
			}
			con.commit();			JOptionPane.showMessageDialog(this.getAppMain(), "엑셀 등록 성공");
			getProductList();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			//이 영역이 만일 DML 실패에 의한 에러를 만난경우 실행된다면 roolback
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally {
			if(fis!=null) {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(pstmt!=null) {
				this.getAppMain().release(pstmt);
			}
			try {
				con.setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void getListBySearch() {
		String category=ch_category.getSelectedItem();
		String keyword = t_keyword.getText();
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		
		String sql="select product_id, sub_name, product_name, price, brand, detail, filename";
		sql +=" from subcategory s, product p";
		sql +=" where s.subcategory_id=p.subcategory_id and "+category+" like '%"+keyword+"%' ";
		
		
		try {
			pstmt=this.getAppMain().getCon().prepareStatement(sql
					,ResultSet.TYPE_SCROLL_INSENSITIVE
					,ResultSet.CONCUR_READ_ONLY);
			rs=pstmt.executeQuery();
			rs.last();//커서를 마지막 레코드로 보냄
			int total = rs.getRow();
			
			//jtable이 참조하고 있는 records라는 이차원 배열의 값을, rs를 이용하여서 갱신해보자
			records=new String[total][columns.length];
			
			rs.beforeFirst();//커서 위치 제자리
			int index=0;
			while(rs.next()) {
				records[index][0]=Integer.toString(rs.getInt("product_id"));
				records[index][1]=rs.getString("sub_name");
				records[index][2]=rs.getString("product_name");
				records[index][3]=Integer.toString(rs.getInt("price"));
				records[index][4]=rs.getString("brand");
				records[index][5]=rs.getString("detail");
				records[index][6]=rs.getString("filename");
				index++;
			}
			//jtable갱신
			table.updateUI();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.getAppMain().release(pstmt,rs);
		}
		
//		System.out.println(sql);
	}
	
	public void getDetail() {
		//선택한 레콛의 product_id
		product_id = Integer.parseInt((String)table.getValueAt(table.getSelectedRow(), 0));
		
//		table.getSelectedRow();//선택한 로우
		
		
		
		//문자열은 immuable 특징이 있기 때문에, 즉 문자열 상수이기 때문에 아래와 같이 sql문을 처리하면
		//문자열 상수 5개가 생성된다, 즉 sql이 수정되는게 아니다
		//따라서 좀더 메모리 효율을 생각한다면, 수정 가능한 문자열을 처리해야한다.
		StringBuffer sb = new StringBuffer();
		sb.append("select product_id,top_name, sub_name, product_name, price, brand, detail,filename");
		sb.append(" from topcategory t, subcategory s, product p");
		sb.append(" where t.topcategory_id=s.topcategory_id and");
		sb.append(" s.subcategory_id = p.subcategory_id and");
		sb.append(" product_id="+product_id);
		
		
		System.out.println(sb.toString());
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt=this.getAppMain().getCon().prepareStatement(sb.toString());
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				//우측 영역에 채워넣기
				t_top.setText(rs.getString("top_name"));
				t_sub.setText(rs.getString("sub_name"));
				t_product_name2.setText(rs.getString("product_name"));
				t_price2.setText(Integer.toString(rs.getInt("price")));
				t_brand2.setText(rs.getString("brand"));
				t_detail2.setText(rs.getString("detail"));
				
				del_file=rs.getString("filename");
				
				//우측 켄버스에 이미지 나오게
				image2=kit.getImage("D:\\korea202102_javaworkspace\\ShoppingApp\\data\\"+rs.getString("filename"));
				can2.repaint();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.getAppMain().release(pstmt,rs);
		}
		
	}
	
	public void deleteProduct() {
		String sql="delete from product where product_id="+product_id;
		
		PreparedStatement pstmt = null;
		try {
			pstmt=this.getAppMain().getCon().prepareStatement(sql);
			int result = pstmt.executeUpdate();
			if(result > 0) {
				//파일삭제 진행
				File file=new File("D:\\korea202102_javaworkspace\\ShoppingApp\\data\\"+del_file);
				file.delete();
				getProductList();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.getAppMain().release(pstmt);
		}
	}
	
	//상품 한건 수정
	public void updateProduct() {
		String sql="update product set product_name=?,price=?,brand=?,deatil=?,filename=?";
		sql+=" where product_id=?";
		
		PreparedStatement pstmt=null;
		try {
			pstmt=this.getAppMain().getCon().prepareStatement(sql);
			
			String product_name=(String)table.getValueAt(table.getSelectedRow(), 2);
			int price=Integer.parseInt((String)table.getValueAt(table.getSelectedRow(), 3));
			String brand=(String)table.getValueAt(table.getSelectedRow(), 4);
			String detail=(String)table.getValueAt(table.getSelectedRow(), 5);
			String filename=(String)table.getValueAt(table.getSelectedRow(), 6);
			
			pstmt.setString(1, product_name);
			pstmt.setInt(2,price);
			pstmt.setString(3, brand);
			pstmt.setString(4, detail);
			pstmt.setString(5, filename);
			pstmt.setInt(6, product_id);
			
			int result=pstmt.executeUpdate();
			if(result >0) {
				JOptionPane.showMessageDialog(this.getAppMain(), "수정성공");
			}else {
				JOptionPane.showMessageDialog(this.getAppMain(), "수정실패");				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.getAppMain().release(pstmt);
		}
	}
	
	
}
