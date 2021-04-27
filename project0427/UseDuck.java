class UseDuck{

	public static void main(String[] args){
		int x=7;
		Duck d1=new Duck();

		//d1은 결국, 실제 오리 자체를 담고 있는게 아니라, Heap영역에 생성된 오리 인스턴스의 주소값을 답고있다.
		//즉, 오리를 가리키고(참조하고) 있다하여  [regerence] : 참조 변수라고 한다.
		System.out.println("d1이 담고있는 오리 인스턴스의 주소값은 : "+d1);
	}

}