package app0526.thread.ex4;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

//주인공을 정의한다.
public class Hero extends GameObject{
	
	
	public Hero(GamePanel gamePanel, String path, int x, int y, int width, int height, int velX, int velY) {
		super(gamePanel, path, x, y, width, height, velX, velY);
	}
	public void tick() {
		this.x+=this.velX;
		this.y+=this.velY;
	}
	public void render(Graphics g) {
		//g는 패널로 부터 넘겨받은 주소값이므로 이 g는 그림을 그리게 될 경우, 당연히 그림은 패널에 그려지게 된다.
		g.drawImage(img, x, y, width, height, this.gamePanel);
	}
}
