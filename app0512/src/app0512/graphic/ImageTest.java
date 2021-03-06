package app0512.graphic;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class ImageTest extends JFrame{
	
	Image img = null;//이미지는 추상클래스이기 때문에 개발자가 직접 new 할 수 없다.
							//일반적으로 추상 클래스는 개발자가 상속받아 완성한 후 자식 객체를 생성할때 사용할 수 있지만 언제나 그런건 아니다.
							//즉, sun에서 추상 클래스 객체의 인스터스를 얻는 또 다른 방법을 제공해주는 경우도 많다.
	Toolkit kit; //툴킷을 이요하면, os 경로로 접근한 이미지의 인스턴스를 얻을 수 있다.
	
	public ImageTest() {
		//이미지를 얻기 위한 객체인 툴킷 객체의 인스턴스를 먼저 얻어와야한다.
		kit = Toolkit.getDefaultToolkit();//인스턴스를 얻는 메서드 사용
		img = kit.getImage("D:\\korea202102_javaworkspace\\app0512\\res\\images\\rai.jpg");//하드 디스크 상의 이미지 경로 or 인터넷 상의 url
		
		
		
		setBounds(2000,100,700,650);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	//paint 메서드 재정의
	@Override
	public void paint(Graphics g) {
		g.drawImage(img,0 ,0 , this);
	}
	
	public static void main(String[] args) {
		new ImageTest();
	}
}
