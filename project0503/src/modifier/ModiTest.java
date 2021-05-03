package modifier;

/*
	자바의 수식자(modifier)에는 static말고도 여러가지가 있다..
	개발자가 알아야할 수식자는 아래의 3가지 이다.

	1.static : 정적 변수, 메서드, 클래스 선언시 사용
	2.final : 변수, 메서드, 클래스의 값을 고정할때 사용
				변수 : 상수처럼 고정시켜버림
				메서드 : 오버라이딩을 허용하지 않는다. 즉, 부모의 메서드를 업그레이드 할 수 없게됨
				클래스 : 더이상 자식을 두지 않겠다. 따라서 외부의 클래스가 해당 클래스를 상속할 수 없음
	3.abstract : 추상 클래스, 메서드 선언시 사용
*/

public class ModiTest{
	public static void main(String[] args){
		final int x=3; //더이상 변수 x의 값은 이 시점 이후부터 변경 불가
		x=9;
	}
}