package api;




class StringTest4{
	public static void main(String[] args){

		/*
			String Ŭ������ �����Ѽ� immutable(�Һ�)�� �Ӽ��� �ִٰ� �Ѵ�.
		*/

		String s1="korea";
		s1=s1+" vs usa";


		System.out.println(s1);
		
		//�ݺ����� ������ ��� �޸𸮿� ���ڿ� ����� ��� �߰��ǹ�����.
		


		//StringBuffer -> �޸𸮿��� ������ ������ ��Ʈ���� ���� �� �ִ�.
		StringBuffer sb = new StringBuffer(); //StringŬ������ �ƴϰ� StringBuffer Ŭ�����̴�.
		sb.append("��");
		sb.append("��ȣ");
		System.out.println(sb.toString());
	}
}
