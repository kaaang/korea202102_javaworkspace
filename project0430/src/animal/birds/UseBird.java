package animal.birds;


/*
	��ӿ��� ��ġ�� ���ƾ� �� �ٽ� ����
	1)�ڵ��� ����
	2)��ü���� ����ȯ(���� �ܰ� �޴�)
*/



class UseBird{
	public static void main(String[] args){
		//[�⺻ �ڷ����� ����ȭ�� ��]
		int x=7; //4����Ʈ
		byte b=3; //1����Ʈ

		//x=b; //�������ڵ� -> �����Ÿ� ū�ſ� ����


		b=(byte)x;//�ս��� �߻��ϹǷ� �Ұ����ϴ�. ������ �����ڰ� �ս��� �����ؼ��� ������ ����ȯ�� �����ϸ� �������ش�. (ĳ��Ʈ)



		//��ü �ڷ����� ����ȯ�� ��
		Bird bird = new Bird("red");
		Duck d= new Duck("white");

		bird=d;
		//�⺻ �ڷ����� ���߾�, �뷮�� ������ �����ϸ� �ȵ�
		//��ü�� ����ȯ�� ���� �� ������ ��ü�� ����ų �� �ִ���?�� ���� �ڷ����̴�.(ū �ڷ����̴�.)

		bird.fly();
		//bird.canSwim(); //bird ������ �ڷ����� Bird�̱� ������ �翬�� BirdŬ�������� canSwim()�޼��尡 ���� ���� ���� �߻�

		Duck duck=(Duck)bird; //��ü���� ����ȯ�� �����ϴ�. �̶� �ڽ� �ڷ��������� ����ȯ�� ������ downCasting�̶� �Ѵ�.
		duck.canSwim();

	}
}