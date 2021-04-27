class Dog{

	//하나의 클래스가 보유한 변수들은 현실의 객체르 반영한 상태, 속성을 표현했다고 하여 property(속성)라 한다.

	int age =5;
	String color="white";
	String name="rai";


	//public 접근제한자, void 이 메서드가 반환값이 없다
	public void run(){
		System.out.println(name+" is run");
	}

	public String getName(){
		return name;
	}
	public int getAge(){
		return age;
	}

}