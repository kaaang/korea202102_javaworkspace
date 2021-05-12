package app0512.graphic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class GalleryDetail extends JPanel{

	private Image image;
	
	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
		this.image = this.image.getScaledInstance(500, 340, Image.SCALE_SMOOTH);
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(image, 0, 0, this);
	}
	
}
