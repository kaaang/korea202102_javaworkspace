package api;

//sun�翡�� �����ϴ� ���� Ŭ���� �� ���ڿ� ó���� �߿��� ����� ����ϴ� StringŬ������ ���� �н��غ���.


class StringTest2{
	public static void main(String[] args){

		//String�� ��ü������, �ʹ��� ���� ���̱� ������ ��ġ �⺻ �ڷ���ó�� ��ü�� �����ϴ� ����� �����Ѵ�.
		//�Ͻ��� ������ = implicit ������   -> ���Ǯ�� ���������
		String str1 = "apple"; //������ ��ü�̴�.
		String str2 = "apple";

		System.out.println(str1==str2); // �ּҰ� ��������, ���� �ּҸ� ����Ű�Ƿ� ��ġ �����ó�� �����ش�.

		//String�� Ŭ���� �̹Ƿ�, �̹����� �����ڸ� �̿��غ���
		//����� ������
		String s1=new String("korea");
		String s2=new String("korea");

		System.out.println(s1==s2);
		//����� ���������� String ��ü�� �����ϸ� ȣ���� ���θ� ������ �ʰԵǼ� constant pool�� ��������� �ʴ´�.
		//���� s1,s2�� ����Ű�� �ִ� ��ü �ν��Ͻ��� �ٸ��Ƿ�, ����� false��.
	}
}
