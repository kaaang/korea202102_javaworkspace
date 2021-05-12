package app0512.graphic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PhotoAlbum extends JFrame{
	JPanel p_north;
	JPanel canvas;
	Thumbnail[] list = new Thumbnail[8];
	DetailView detailView;
	
	public void createThumb() {
		
		for (int i = 0; i<list.length; i++) {
			list[i] = new Thumbnail(this);
			p_north.add(list[i]);
		}
		
	}
	
	public PhotoAlbum() {
		
		p_north = new JPanel();
		detailView = new DetailView(this);
		
		
		p_north.setPreferredSize(new Dimension(900,100));
		p_north.setBackground(Color.GRAY);
		
		
		add(p_north, BorderLayout.NORTH);
		createThumb();
		add(detailView);
		
		
		
		setBounds(2000, 50, 900, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new PhotoAlbum();
	}
	
}
