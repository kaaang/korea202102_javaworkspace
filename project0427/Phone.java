class Phone{
	int price=5000;
	String name="G21";
	static String company="Samsung";
	//static은 고정적인 이란 뜻의 수정자라 불린다.
	//static으로 선언된 변수, 메서드는 new할때 해당 인스턴스에 소속되지 않는다.
	//따라서 원본 클래스에 존재하게 된다. 따라서 static으로 선언된 멤버변수를 [클래스 변수]라 한다.

	public void ring(){
		System.out.println("Rrrrrrrr");
	}




	public static void main(String[] args){
		Phone p1 = new Phone();
		p1.company="LG";

		company="Motor";

		Phone p2=new Phone();
		p2.company="Sambo";

		System.out.println(p1.company);



		//String c = Phone.comapny  //클래스가 보유한 클래스 변수는 이렇게 접근하면 된다.
	}
}