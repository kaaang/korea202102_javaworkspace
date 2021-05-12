package app0512.graphic;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

/*
 * paint 메서드
 * 개발자가 paint 메서드를 호출해서는 안된다
 * 자바의 모든 컴포넌트는 스스로를 그린다 즉 paint메서드는 시스템이 그래픽의 렌더링시 필요에 의해 호출
 * 언제? 처음의 그림과 비교해서 바뀐 부분이 있다면, 시스템이 알아서 다시 호출
 * 
 * 원리 : 1.기존의 그림을 지운다 (update 메서드)
 * 			2.그림을 그린다.(paint 메서드)
 * 
 * 문제점 : 사용자가 윈도우창의 크기를 변화시킨다거나, 하는 그래픽상의 별화를 통해 페인트 메서드를 호출하는게 아니라
 * 		개발자가 원하는 시점에 프로그래밍적으로 페인트를 호출하는 방법은 없을까
 * 
 * sun에서는 그래픽이 화면에 반영되는 처리는 시스템이 하기 때문에 paint()메서드 호출을원칙적으로 막아놓았다.
 * 따라서 개발자는 시스템에게 paint()가 호출 될 수 있도록 간접적으로 요청할 수 있다.
 * 
 * 이때 호출해야 할 메서드가 repaint()이다.
 * 
 * repaint()는 그래픽의 갱신을 요청하게되고 이때 이 요청이 들어오면 update()가 호출되어 화면을 지우며
 * 화면을 지우고 나서 깨끗해지면 paint()를 호출해서 다시 그린다.
 * */

public class Mycanvas extends Canvas{
	Movetest moveTest;

	public Mycanvas(Movetest moveTest) {
		this.moveTest = moveTest;
	}
	
	
	//켄버스에 그려질 그림을 개발자가 주도하여 원하는 그림을 그려보자
	@Override
	public void paint(Graphics g) {
		g.setColor(Color.YELLOW);
		//이 시점부터 노란색으로 그려진다.
		g.fillOval(moveTest.x, 100, 100, 100);
		
	}
	
}
