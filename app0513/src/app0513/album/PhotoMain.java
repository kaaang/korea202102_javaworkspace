package app0513.album;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PhotoMain extends JFrame{
	
	JPanel p_north;
	XCanvas can;
	String dir="D:\\korea202102_javaworkspace\\app0513\\res\\images\\";
	String[] pathArray= {"0.jpg","1.jpg","2.jpg","3.jpg","4.jpg","5.jpg","6.jpg","7.jpg","8.jpg","9.jpg"};
	ThumbPanel[] thumbPanel=new ThumbPanel[pathArray.length];
	
	public PhotoMain() {
		//생성
		p_north = new JPanel();
		can = new XCanvas();
		
		
		for (int i = 0; i < pathArray.length; i++) {
			thumbPanel[i] = new ThumbPanel(dir+pathArray[i],can);
		}
		
		
		//스타일
		p_north.setBackground(Color.YELLOW);
		p_north.setPreferredSize(new Dimension(600,60));
		can.setBackground(Color.CYAN);
		
		
		
		//조립
		for (int i = 0; i < pathArray.length; i++) {
			p_north.add(thumbPanel[i]);			
		}
		add(p_north,BorderLayout.NORTH);
		add(can);
		
		//리스너
		
		
		//보이기
		can.createImage(dir+pathArray[0]);
		
		setBounds(2000, 100, 600, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	
	public static void main(String[] args) {
		new PhotoMain();
	}
}
