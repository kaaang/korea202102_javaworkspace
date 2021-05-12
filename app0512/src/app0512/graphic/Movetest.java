package app0512.graphic;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//캔버스에 채워진 원을 하나 그리고 나서, 버튼에 의해 이 원이 x축 방향으로 이동하는 효과를 부여해보자
public class Movetest extends JFrame implements ActionListener{
	JPanel p_north;
	MyButton bt;
	Mycanvas can;
	
	int x=0;
	
	public Movetest() {
		//생성
		p_north = new JPanel();
		bt = new MyButton();
		can = new Mycanvas(this);
		
		//스타일
		can.setBackground(Color.RED);
		
		//조립
		p_north.add(bt);
		add(p_north,BorderLayout.NORTH);
		add(can);
		
		//리스너 연결
		bt.addActionListener(this);
		
		
		//보여주기
		setBounds(2000,100,700,600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void tick() {
		x+=10;
	}
	
	public void render() {
		//다시 그려달라고 요청하자 -> MyCanvas를
		can.repaint();
	}
	
	public static void main(String[] args) {
		new Movetest();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		tick();
		render();
	}
	
}
