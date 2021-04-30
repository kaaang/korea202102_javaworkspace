package animal.birds;

class UseTest{
	public static void main(String[] args){
		Bird b = new Duck(); //가능
		//Duck를 생성하면서 Bird를 extend했기 떄문에 Bird로 자료형을 선언할 수 있고 자료형을 Bird로 선언하여서 Bird로  접근이 가능하게 할 수 있다.(Duck 접근 불가->형변환 해야함)
	}
}