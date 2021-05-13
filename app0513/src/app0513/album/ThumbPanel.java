package app0513.album;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class ThumbPanel extends JPanel implements MouseListener{
	
	Toolkit kit;
	Image image;
	int width = 50;
	int height = 50;
	XCanvas can;
	
	
	public ThumbPanel(String filename, XCanvas can) {
		this.setPreferredSize(new Dimension(width,height));
		kit = Toolkit.getDefaultToolkit();
		image = kit.getImage(filename);
		this.can = can;
		this.addMouseListener(this);
	}
	
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(image, 0, 0, width, height, this);//x,y,w,h
	}


	@Override
	public void mouseClicked(MouseEvent e) {
	}


	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("전송하는 이미지 "+image);
		can.setImage(image);
		can.repaint();
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
