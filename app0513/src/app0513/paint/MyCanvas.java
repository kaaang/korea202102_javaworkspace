package app0513.paint;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MyCanvas extends Canvas implements MouseListener, MouseMotionListener{

	boolean flag = false;
	
	public MyCanvas() {
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	
	
	@Override
	public void paint(Graphics g) {
		if(flag) {
			g.fillOval(100, 100, 2, 2);			
		}
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		repaint();
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		flag=true;
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		flag=false;
	}
	
	
	
	
	
	
	
	
	
	
	@Override
	public void mousePressed(MouseEvent e) {
		//System.out.println("mousePressed");
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		//System.out.println("mouseEntered");
	}
	@Override
	public void mouseExited(MouseEvent e) {
		//System.out.println("mouseExited");
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("mouseClicked");		
	}


	

}
