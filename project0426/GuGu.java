class GuGu {
	public static void main(String[] args) {
		//main의 매개변수는 java.exe 호출 시 그 값을 넘길 수 있다.
		//java 사과 딸기 바나나     로 값을 넘기면 크기가 3인 String 배열이 전달되게 됩니다.
		System.out.println("당신이 main 호출시 즉 자바 실행시 넘긴 매개 변수는"+args.length);

		//for(int i=0;i<args.length;i++){
		//	System.out.println(args[i]);
		//}

		int x = Integer.parseInt(args[0]);
		for(int i=1;i<=x;i++){
			for(int j=1;j<=9;j++){
				System.out.println(i+"*"+j+"="+i*j);
			}
		}
	}
}
