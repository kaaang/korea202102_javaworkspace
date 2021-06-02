package app0602.cal.diary;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class DateBox extends JPanel{
	int width;
	int height;
	Color color;
	String day;
	
	Image img;
	
	public DateBox(String day,Color color ,int width, int height) {
		this.width=width;
		this.height=height;
		this.color=color;
		this.day=day;
		setPreferredSize(new Dimension(width, height));
	}
	public void paint(Graphics g) {
		g.setColor(color);//그래픽 객체의 물감이 회색이다
		g.fillRect(0, 0, width, height);
		
		g.setColor(Color.white);
		g.drawString(day, 10, 20);
		
		//조건에 따라 아이콘을 그리고, 안그리고를 결정하자
		if(img!=null) {
			g.drawImage(img, 0, 25, 30, 20, this);
		}
	}
}
