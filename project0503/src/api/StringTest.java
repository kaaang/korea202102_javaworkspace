package api;

//sun�翡�� �����ϴ� ���� Ŭ���� �� ���ڿ� ó���� �߿��� ����� ����ϴ� StringŬ������ ���� �н��غ���.


class StringTest{
	public static void main(String[] args){
		String s=new String("apple");
		
		System.out.println("���ڿ��� ���̴� "+s.length());

		System.out.println(s.toUpperCase());

		System.out.println("������ p�� index�� : "+s.lastIndexOf("p"));

		System.out.println("charAt�� ��� :  "+s.charAt(4));


	}
}
