class Phone{
	int price=5000;
	String name="G21";
	static String company="Samsung";
	//static�� �������� �̶� ���� �����ڶ� �Ҹ���.
	//static���� ����� ����, �޼���� new�Ҷ� �ش� �ν��Ͻ��� �Ҽӵ��� �ʴ´�.
	//���� ���� Ŭ������ �����ϰ� �ȴ�. ���� static���� ����� ��������� [Ŭ���� ����]�� �Ѵ�.

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



		//String c = Phone.comapny  //Ŭ������ ������ Ŭ���� ������ �̷��� �����ϸ� �ȴ�.
	}
}