package app0510.event;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

//마우스 이벤트를 청취하는 MouseControl를 정의해본다.
public class MouseControl implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("마우스 눌렀음");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

}
