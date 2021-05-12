package app0512.graphic;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class Thumbnail extends JPanel implements MouseListener{
	PhotoAlbum photoAlbum;
	Toolkit kit;
	Image image;
	public Thumbnail(PhotoAlbum photoAlbum) {
		this.photoAlbum = photoAlbum;
		kit=Toolkit.getDefaultToolkit();
		image = kit.getImage("D:\\korea202102_javaworkspace\\app0512\\res\\images\\rai.jpg");
		image = image.getScaledInstance(100, 90, Image.SCALE_SMOOTH);
		this.setPreferredSize(new Dimension(100,100));
		
		this.addMouseListener(this);
	}
	@Override
	public void paint(Graphics g) {
		g.drawImage(image, 0, 0, this);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("click");
		photoAlbum.detailView.setImage(image);
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
