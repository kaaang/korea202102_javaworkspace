package app0512.graphic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Gallery extends JFrame implements ActionListener{
	GalleryDetail galleryDetail;
	JPanel p_south;
	JButton bt_prev;
	JButton bt_next;
	
	//갤러리에 사용잘 배열을 준비
	String dir="D:\\korea202102_javaworkspace\\app0512\\res\\images";
	String[] arr = {"0.jpg","1.jpg","2.jpg","3.jpg","4.jpg","5.jpg","6.jpg","7.jpg","8.jpg","9.jpg"};
	Image[] image=new Image[arr.length];
	Toolkit kit;
	
	int index=0;
	
	
	public Gallery() {
		galleryDetail = new GalleryDetail();
		p_south = new JPanel();
		bt_prev = new JButton("prev");
		bt_next = new JButton("next");
		
		kit = Toolkit.getDefaultToolkit();
		for (int i = 0; i < arr.length; i++) {
			image[i] = kit.getImage(dir+"\\"+arr[i]);
		}
		
		galleryDetail.setImage(image[index]);
		
		//레이아웃
		
		//조립
		add(galleryDetail);
		p_south.add(bt_prev);
		p_south.add(bt_next);
		add(p_south,BorderLayout.SOUTH);
		bt_prev.addActionListener(this);
		bt_next.addActionListener(this);
		
		//보여주기
		setBounds(2000, 100, 500, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new Gallery();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==bt_prev) {
			if(index>0) {
				index--;				
			}else {
				JOptionPane.showMessageDialog(this, "이전 이미지가 없습니다.");
			}
		}else if(e.getSource()==bt_next){
			if(index<arr.length-1) {
				index++;				
			}else {
				JOptionPane.showMessageDialog(this, "다음 이미지가 없습니다.");				
			}
		}
		System.out.println(index);
		galleryDetail.setImage(image[index]);
		galleryDetail.repaint();
	}
	
	
	
}
