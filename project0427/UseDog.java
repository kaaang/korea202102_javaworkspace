class UseDog{
	public static void main(String[] args){
		
		//String name = new Dog().getName();
		//System.out.println(name);


		//������ 1������ �޸𸮿� �ø���, �� �������� ���̸� 3���� �ٲ��� ���̸� ����غ���
		//�ڹٿ� ���� ��ü���� ���� �����ڰ� �ڷ����� ������ �� �ִ�. -> ����� ���� �ڷ���
		//�����ڰ� Dog��� Ŭ������ �����ߴٸ�, �װ��� Dog���� ���Ӱ� ź����Ų���̴�.
		//�� �������ʹ� oop���� �ڷ����� ��4����� �� �� �ִ�.
		Dog d = new Dog();
		d.age=3;    //d��� ���� ������ age �Ӽ����� 3���� ����
		System.out.println("set dog age = "+d.getAge());

		//�������� �̸��� ���� �� ����غ���
		d.name = "ksh";
		System.out.println("set dog name = "+d.getName());
	}
}