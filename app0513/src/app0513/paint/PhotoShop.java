package app0513.paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PhotoShop extends JFrame{
	JPanel p_north;
	JButton bt_eraser;
	Color[] colorArray = {Color.RED,Color.orange,Color.yellow,Color.green,Color.blue,Color.cyan,Color.pink};
	MyCanvas can;
	
	public PhotoShop() {
		p_north = new JPanel();
		bt_eraser = new JButton("지우기");
		can = new MyCanvas();
		
		for (int i = 0; i < 7; i++) {
			ColorBox colorbox = new ColorBox(colorArray[i]);
			p_north.add(colorbox);
		}
		
		p_north.setPreferredSize(new Dimension(700,50));
		can.setBackground(Color.white);
		
		p_north.add(bt_eraser);
		add(p_north,BorderLayout.NORTH);
		add(can);
		
		setBounds(2000, 100, 700, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new PhotoShop();
	}
}
