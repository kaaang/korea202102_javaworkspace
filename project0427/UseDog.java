class UseDog{
	public static void main(String[] args){
		
		//String name = new Dog().getName();
		//System.out.println(name);


		//강아지 1마리를 메모리에 올리고, 그 강아지의 나이를 3세로 바꾼후 나이를 출력해보자
		//자바와 같은 객체지향 언어에서 개발자가 자료형을 정의할 수 있다. -> 사용자 정의 자료형
		//개발자가 Dog라는 클래스를 정의했다면, 그것은 Dog형을 새롭게 탄생시킨것이다.
		//이 시점부터는 oop언어에서 자료형이 총4개라고 할 수 있다.
		Dog d = new Dog();
		d.age=3;    //d라는 개가 보유한 age 속성값을 3으로 변경
		System.out.println("set dog age = "+d.getAge());

		//강아지의 이름을 변경 후 출력해보자
		d.name = "ksh";
		System.out.println("set dog name = "+d.getName());
	}
}