package api;

//sun사에서 제공하는 여러 클래스 중 문자열 처리시 중요한 기능을 담당하는 String클래스에 대해 학습해보자.


class StringTest{
	public static void main(String[] args){
		String s=new String("apple");
		
		System.out.println("문자열의 길이는 "+s.length());

		System.out.println(s.toUpperCase());

		System.out.println("마지막 p의 index는 : "+s.lastIndexOf("p"));

		System.out.println("charAt의 결과 :  "+s.charAt(4));


	}
}
