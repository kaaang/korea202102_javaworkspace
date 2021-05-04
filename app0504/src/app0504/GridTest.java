package app0504;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;

public class GridTest {

	public static void main(String[] args) {
		
		Frame frame = new Frame("GridLayout");
		GridLayout layout = new GridLayout(2,3);
		
		frame.setLayout(layout);
		
		for (int i = 1; i <= 6; i++) {
			Button bt = new Button("bt"+i);
			frame.add(bt);
		}
		
		
		frame.setSize(300,150);
		frame.setVisible(true);
		
		
		
	}

}
