package app0513.album;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class XCanvas extends Canvas{
	
	Toolkit kit=Toolkit.getDefaultToolkit();
	Image image;
	
	public void createImage(String path) {
		image = kit.getImage(path);
	}
	
	public void setImage(Image image) {
		this.image = image;
		System.out.println("전달받은 이미지 "+image);
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(image, 0, 0, 600, 440, this);
	}
	
	
	
}
