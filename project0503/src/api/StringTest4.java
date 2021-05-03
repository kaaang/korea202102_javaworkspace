package api;




class StringTest4{
	public static void main(String[] args){

		/*
			String 클래스를 가리켜서 immutable(불변)의 속성이 있다고 한다.
		*/

		String s1="korea";
		s1=s1+" vs usa";


		System.out.println(s1);
		
		//반복문을 돌리면 계속 메모리에 문자열 상수가 계속 추가되버린다.
		


		//StringBuffer -> 메모리에서 수정이 가능한 스트링을 만들 수 있다.
		StringBuffer sb = new StringBuffer(); //String클래스가 아니고 StringBuffer 클래스이다.
		sb.append("무");
		sb.append("야호");
		System.out.println(sb.toString());
	}
}
