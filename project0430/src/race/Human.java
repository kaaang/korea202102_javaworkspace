package race;

public class Human{

	int IQ = 90;

	boolean hasName=true;

	public Human(int IQ){
		this.IQ=IQ;
		System.out.println("�θ��� �ʱ�ȭ");
	}
	public Human(){
		//������ �����ε��� �̿��Ͽ��� �����ڰ� ������ ���Ǹ� �������� ������ �� �ְ��Ѵ�.
	}

	public void speak(){
			System.out.println("���� �� �ִ�.");
	}

	public void drive(){
		System.out.println("���� �� �� �ִ�.");
	}

}