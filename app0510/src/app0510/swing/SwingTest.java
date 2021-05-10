package app0510.swing;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

/*
 * AWT는 자바의 GUI API를 대부분 지원하기는 하지만, 플랫폼마다 디자인이 일괄적이지 않다.
 * 이 문제점을 해결하기 위해서 swing api로 확장해서 GUI를 구현할 수 있다.
 * swing에 대한 학습 부담은 갖지 않아도 된다. -> 기존 우리가 알고 있었던 컴포넌트에 접두어로 J만 붙으면 된다.
 * swing은 기존의 AWT와는 다르게 swing만의 룩앤필이 있다.
 */


public class SwingTest extends JFrame{
	//has a 관계 -> 다른 객체를 보유할 경우, 개발자는 생성자를 적극 활용하면 좋다. -> has a란 부품 관계이므로
	JButton bt;
	
	public SwingTest() {
		//생성
		bt = new JButton("Button");
		//스타일
		this.setSize(new Dimension(300,400));
		//조립
		this.setLayout(new FlowLayout());
		this.add(bt);
		//보여주기
		this.setVisible(true); //x누르면 닫히지만 setVisible을 false로 두는거 뿐이며, 프로그램을 살아있다.
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	
	public static void main(String[] args) {
		new SwingTest();
	}
}
