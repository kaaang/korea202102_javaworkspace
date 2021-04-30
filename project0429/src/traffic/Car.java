package traffic;

class Car{

	//메서드명은 소중하다, 직관성을 부여하기 위해서 힘들게 찾앟서 작명하게 되는데
	//큰 차이가 별로 없는 상황임에도, 메서드 명을 정할때 전혀 다른 단어를 사용해야 하는가?
	//메서드 명은 같지만, 완전히 일치하게 정의하는것이 아니라, 매개변수의 자료형과 객수를 틀리게하면 중복정의로 간주하지 않겠다.
	//-> 오버로딩
	//메서드명을 전혀 다르게 줘야하는 불편함을 해소할 수 있다.
	public void run(){
		System.out.println("자동차가 달린다..");
	}
	public void run(int vel){
		System.out.println("자동차가 조금 달린다..");
	}
	public void run(boolean flag){
		System.out.println("....");
	}

}