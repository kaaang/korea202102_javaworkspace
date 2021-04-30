package animal.birds;


/*
	상속에서 놓치지 말아야 할 핵심 주제
	1)코드의 재사용
	2)객체간의 형변환(시험 단골 메뉴)
*/



class UseBird{
	public static void main(String[] args){
		//[기본 자료형의 형변화의 예]
		int x=7; //4바이트
		byte b=3; //1바이트

		//x=b; //가능한코드 -> 작은거를 큰거에 넣음


		b=(byte)x;//손실이 발생하므로 불가능하다. 하지만 개발자가 손실을 감안해서라도 강제로 형변환을 명시하면 인정해준다. (캐스트)



		//객체 자료형의 형변환의 예
		Bird bird = new Bird("red");
		Duck d= new Duck("white");

		bird=d;
		//기본 자료형에 비추어, 용량의 문제로 접근하면 안됨
		//객체간 형변환은 누가 더 폭넓은 객체를 가리킬 수 있느냐?가 상위 자료형이다.(큰 자료형이다.)

		bird.fly();
		//bird.canSwim(); //bird 변수의 자료형은 Bird이기 때문에 당연히 Bird클래스에는 canSwim()메서드가 없다 따라서 에러 발생

		Duck duck=(Duck)bird; //객체간의 형변환도 가능하다. 이때 자식 자료형으로의 형변환을 가르켜 downCasting이라 한다.
		duck.canSwim();

	}
}
