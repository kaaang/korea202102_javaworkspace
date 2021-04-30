package race;

//이 클래스 에서는 흑인이 가징 튼징만을 보유한다.
public class Black extends Human{
	
	/*
	자동으로 생성 
	public Black(){
		super();
	}
	*/

	//부모의 생성자에 매개변주가 존재하므로, 더이상 현재 클래스의 디폴트 생성자에 읜존하다가는 에러가 발생함
	//따라서 개발자가 적극적으로 나서서, 부모의 인수있는 생성자를 직접 호출해주자

	public Black(){
		//슈퍼 생성자가 맨 위로 올라와 있어야함 -> 부모가 생성되어야지 자식 생성이 가능하니까
		//부모의 초기화보다 시급한 초기화는 있을 수 없다.
		super(135);
		System.out.println("흑인 초기화중");
	}



	String color="black";
	int IQ=110;
	
	public void run(){
		System.out.println("육상을 잘한다.");
	}
}