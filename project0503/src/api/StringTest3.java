package api;




class StringTest3{
	public static void main(String[] args){

		String s1="korea";
		String s2="korea"; //값이 달라지면 새로운 주소가 생긴다.
		System.out.println(s1==s2);
		//s1과s2는 래퍼런스 변수이기에, 비교연산자는 서로의 주소값을 비교하게 된다.

		//그렇다면 내용을 비교하려면?
		System.out.println(s1.equals(s2));
		
	}
}
