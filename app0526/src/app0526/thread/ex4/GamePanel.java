package app0526.thread.ex4;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import util.ImageManager;

public class GamePanel extends JPanel{
	Thread gameThread;//게임 루프 즉 심장을 뛰게 할 게임 운영 쓰레드
	boolean gameFlag = true;
	public static final int WIDTH=900;
	public static final int HEIGHT=600;

	ImageManager imageManager = new ImageManager();
	Image bgImg;
	
	Hero hero;
	String[] enemyPath= {"e1.png","e2.png","e3.png","e4.png","e5.png"};
	Enemy[] enemyArray = new Enemy[5];
	
	public GamePanel() {
		setPreferredSize(new Dimension(WIDTH,HEIGHT));
		
		
		
		
		
		
		gameThread = new Thread() {
			public void run() {
				while(gameFlag) {
					gameLoop();		
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		
		
		createBg();
		createHero();
		createEnemy();
		
		gameThread.start();
		
		
		
	}
	
	//배경 생성
	public void createBg() {
		ImageIcon icon = imageManager.getScaledIcon("bg.jpg", WIDTH, HEIGHT);
		bgImg=icon.getImage();
	}
	
	//주인공 생성
	public void createHero() {
		hero = new Hero(this,"plane2.png",100, 200, 80, 45, 3, 0);
	}
	
	//적군생성
	public void createEnemy() {
		for(int i=0;i<enemyPath.length;i++) {
			enemyArray[i] = new Enemy(this,enemyPath[i],800, i*90, 65, 60, -1, 0);
		}
	}
	
	
	protected void paintComponent(Graphics g) {
		g.drawImage(bgImg, 0, 0, WIDTH, HEIGHT, this);
		hero.render(g);
		for(int i=0;i<enemyArray.length;i++) {
			enemyArray[i].render(g);
		}
	}
	
	
	
	public void gameLoop() {
		hero.tick();
		for(int i=0;i<enemyArray.length;i++) {
			enemyArray[i].tick();
		}
		this.repaint();
	}
	
}
