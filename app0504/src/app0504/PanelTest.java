package app0504;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;

public class PanelTest {
	public static void main(String[] args) {
		//그래픽 api중 Panel을 학습한다.
		
		Frame frame = new Frame("Panel Test");
		
		frame.setLayout(new BorderLayout());
		Button bt = new Button("I'm button");
		//frame.add(bt);
		
		Panel p=new Panel();//컴포넌트 중 말뜻 그래도 무언가를 올려놓을 수 있는 패널을 의미
		//패널은 Container의 자식이므로, 다른 컴포넌트들을 포함할 수 있는 능력이 있고, 또한 Container이기에
		//배치 관리자도 사용이 가능하다.
		//왕버튼에 대한 해결책 Frame에 Panel을 부착하고, 이 Panel에 FlowLayout을 적용한 다음 최종적으로 Button을 Panel에 부착하자
		p.setBackground(Color.RED);
		frame.add(p);//윈도우에 판자 붙이기
		
		//버튼을 패널에 부착해보자! 참고로 개발자가 Panel의 배치 관리자를 지정하지 않으면, Default는 바로
		//FlowLayout : 플로우는 컴포넌트 본연의 크기가 유지됨
		p.add(bt);
		
		frame.setSize(300, 250);
		frame.setVisible(true);
		
	}
}
