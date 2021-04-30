package race;

public class Human{

	int IQ = 90;

	boolean hasName=true;

	public Human(int IQ){
		this.IQ=IQ;
		System.out.println("부모의 초기화");
	}
	public Human(){
		//생성자 오버로딩을 이용하여서 개발자가 생성자 정의를 안했을때 실행할 수 있게한다.
	}

	public void speak(){
			System.out.println("말할 수 있다.");
	}

	public void drive(){
		System.out.println("운전 할 수 있다.");
	}

}