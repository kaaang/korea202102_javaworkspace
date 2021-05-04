/*
	GUI 프로그래밍은 무조건 윈도우가 있어야 한다.
	따라서 자바 언어에서 GUI 관련된 패키지는 awt/swing에서 지원한다.
	javaFX(안드로이드와 많이 비슷)

	자바에서 윈도우는 실제적으로 Frame이라는 클래스가 담당
*/
package gui;
import java.awt.Frame;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.Checkbox;
import java.awt.TextArea;
import java.awt.Choice;
public class  MyWin{
	public static void main(String[] args){
		Frame frame;//윈도우 객체 , 객체의 인스턴스는 없다 따라서 frame에는 초기화되어있지 않다.
		/*
		Frame이라는 클래스는 쓰라고 제공해준것인데, 문제응 어떻게 사용해야할지 난감함
		왜? 우리가 정의한 클래스가 아니여서
		[남에게 제공받은 객체 사용하는 TIP]
			1)해당 클래스가 도대체 뭔지? 용도가 뭔지? 사용목적인 뭔데?

			2)쓰기위해서는 메모리에 올려야한다.
			   메모리에 올리려면, 이 객체가 일반인지, 추상인지, 인터페이스인지부터 조사한다.
			   -일반 클래스인 경우 : new 하면 된다.
			   -추상 클래스인 경우 : 자식으로 완성 후, 자식을 new하면 됨
			   -인터페이스인 경우 : 자식으로 완성 후, 자식을 new하면 됨

			 3)메모리에 올리는 방법이 결정되었다면
			   -일반 클래스의 경우엔 new 다은에 와야하는 생성자를 조사(CONSTR)
		*/

		frame = new Frame();//프레임은 기본적으로 눈에 보이지 않도록 속성이 지정되어있다.

		//윈도우 안에 부착할 버튼 생성
		Button bt = new Button("button");//Button is a Component

		FlowLayout flow = new FlowLayout();//컴포넌트를 선형으로 배치하는 레리아웃 객체
		//즉, 수평으로 부착할지, 수직으로 부착할지
		frame.setLayout(flow);

		//입력 텍스트 박스 생성하여 붙여보자
		TextField t = new TextField(20);

		//체크박스 나오게
		Checkbox ch1 = new Checkbox("영화");
		Checkbox ch2 = new Checkbox("프로그래밍");
		Checkbox ch3 = new Checkbox("수영");
		Checkbox ch4 = new Checkbox("여행");

		//TextArea
		TextArea area = new TextArea(5,15);

		//html의 select 박스는 java에서 Choice라고 한다.
		Choice choice = new Choice();
		choice.add("@naver.com");
		choice.add("@nate.com");
		choice.add("@hanmail.net");

		


		//프레임에 버튼 부착
		frame.add(bt);
		frame.add(t);
		frame.add(ch1);
		frame.add(ch2);
		frame.add(ch3);
		frame.add(ch4);
		frame.add(area);
		frame.add(choice);



		//버튼 부착 후, 대왕 버튼이 나오는이유
		//모든 GUI프로그래밍 에서는 화면의 배치 방법을 개발자가 결정해야한다.

		


		//따라서 개발자가 원하는 타임에, 눈에 보일 수 있도록 속성을 변경하는 메서드를 호출해보자.
		frame.setVisible(true);

		//크기도 명시하지 않으면, 원하는 크기로 윈도우가 보이지 않음
		frame.setSize(300,400);
	}
}
