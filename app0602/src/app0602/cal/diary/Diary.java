package app0602.cal.diary;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import app0602.common.StringManager;

public class Diary extends JFrame{
	JPanel p_north;
	JButton bt_prev;
	JLabel la_title;
	JButton bt_next;
	
	JPanel p_center;
	
	String[] dayArray= {"Sun","Mon","Tue","Wed","Thur","Fri","Sat"};
	
	//원하는 시점에 날짜 박스를 제어하기 위해서 각 날짜 박스 객체들을 배열에 담아놓자
	DateBox[] boxArray = new DateBox[dayArray.length*6];
	Calendar currentDate;//현재 날짜 정보를 가진 객체
	
	//기념일에 대한 데이터를 구성
	
	public Diary() {
		p_north = new JPanel();
		bt_prev = new JButton("이전");
		la_title = new JLabel("년도 월 일",SwingConstants.CENTER);
		bt_next = new JButton("다음");
		p_center = new JPanel();
		
		//스타일
		la_title.setFont(new Font("Arial-Black",Font.BOLD,30));
		la_title.setPreferredSize(new Dimension(500, 50));

		
		
		
		//조립
		p_north.add(bt_prev);
		p_north.add(la_title);
		p_north.add(bt_next);
		add(p_north,BorderLayout.NORTH);
		add(p_center);
		getCurrentDate();
		setDateTitle();
		createDay();
		createDate();
		printDate();
//		System.out.println(getFirstDayOfMonth(2021,5));
//		System.out.println(getLastDate(2021, 6));
		
		//이벤트
		bt_next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nextMonth();
			}
		});
		bt_prev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				prevMonth();
			}
		});
		
		
		//보여주기
		setVisible(true);
		setSize(780, 780);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	//현재 날짜 구하기(프로그램과 동시에 사용될 디폴트 날짜)
	public Calendar getCurrentDate() {
		currentDate = Calendar.getInstance();
		return currentDate;
	}
	
	//달력 타이틀
	public void setDateTitle() {
		int yy=currentDate.get(Calendar.YEAR);
		int mm=currentDate.get(Calendar.MONTH);
		
		//제목에 출력
		la_title.setText(yy+"-"+StringManager.getZeroString(mm+1));
		
	}
	
	
	//요일생성
	public void createDay() {
		for(int i=0;i<7;i++) {
			DateBox dayBox = new DateBox(dayArray[i], Color.GRAY,100,70);
			p_center.add(dayBox);
		}
	}
	
	//날짜생성
	public void createDate() {
		for(int i=0;i<dayArray.length*6;i++) {
			DateBox dateBox = new DateBox("", Color.LIGHT_GRAY,100,70);
			p_center.add(dateBox);
			boxArray[i]=dateBox;
		}
	}
	
	
	//해당 월의 시작요일 구하기
	//호출 방법 : 2월을 구할 경우 -> 1
	public int getFirstDayOfMonth(int yy, int mm) {
		Calendar cal = Calendar.getInstance();
		cal.set(yy, mm,1);
		return cal.get(Calendar.DAY_OF_WEEK)-1;
	}
	
	//해당 월이 몇일까지 있는지 구하기
	//호출방법 : 2월을 구할 경우 -> 2
	public int getLastDate(int yy, int mm) {
		Calendar cal = Calendar.getInstance();
		cal.set(yy, mm,0);//0일이란 존재하지 않는 날짜이므로, 이전 월의 마지막 날을 의미한다.
		return cal.get(Calendar.DATE);
	}
	
	public void printDate() {
		int n=1;
		int yy=currentDate.get(Calendar.YEAR);
		int mm=currentDate.get(Calendar.MONTH);
		for(int i=0;i<boxArray.length;i++) {
			if(i>=getFirstDayOfMonth(yy,mm)) {
				if(n<=getLastDate(yy, mm+1))
				boxArray[i].day=Integer.toString(n);
				boxArray[i].repaint();
				
				//아이콘 올려두기
				if(n==11) {
					Image image = getIcon("cake.png");
					boxArray[i].img=image;
				}
				
				n++;
			}
		}
	}
	
	//기존의 Box에 그려진 스트링 모두 지우기
	public void removeString() {
		for(int i=0;i<boxArray.length;i++) {
			boxArray[i].day="";
			boxArray[i].repaint();
		}
	}
	
	//다음 월 구하기
	public void nextMonth() {
		int yy = currentDate.get(Calendar.YEAR);
		int mm = currentDate.get(Calendar.MONTH);
		currentDate.set(yy, mm+1,1);
		removeString();
		setDateTitle();
		printDate();
	}
	
	//이전 월 구하기
	public void prevMonth() {
		int yy = currentDate.get(Calendar.YEAR);
		int mm = currentDate.get(Calendar.MONTH);
		currentDate.set(yy, mm-1,1);
		removeString();
		setDateTitle();
		printDate();
	}
	
	
	//이 메서드를 호출하면, 적절한 이미지를 반환해주게 처리
	public Image getIcon(String filename) {
		URL url = this.getClass().getClassLoader().getResource(filename);
		ImageIcon icon = new ImageIcon(url);
		
		
		return icon.getImage();
	}
	
	public static void main(String[] args) {
		new Diary();
	}
}
