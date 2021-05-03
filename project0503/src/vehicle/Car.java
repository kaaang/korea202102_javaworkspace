package vehicle;

/*

	is a

	has a
	특정 클래스가, 다른 클래스를 멤버변수로 보유한 경우, 이를 가리켜 has a 관계라 한다.
	참고로, 자바와 같은 oop 언어에서는 객체들간 관계란 크게 2가지가 있다..
	1) is a 관계 : 상속관계
	2) has a 관계 : 부품 관계

	-oop기반으로 개발을 하다 보면, 여러 클래스로 개발을 하게되며 이 클래스들 간에는 관계를 형성할 수 있는데,
	이때 이 관계란 is a, has a관계로 분류된다.

*/

public class Car{
	
	//has a 관계
	//Car has a Engine


	Engine e;
	Wheel w;

	int price;
	String color;

	//부품관계를 선언했다면, 초기화는 더욱 절실하기 때문에 초기화를 담당하는 영역인 생성자에서 초기화를 진행한다.
	public Car(){
		e = new Engine();
		w = new Wheel();
		price = 5000;
		color = "red";
	}

}