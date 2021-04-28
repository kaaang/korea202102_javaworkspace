/*현재 패키지와는 다른 패키지에 있는 클래스 사용해보기*/
package use;
//이 클래스에서 사용하고픈 외부에 존재하는 클래스는 import 명령어로 명시한다.
//이때 주의해야할 점은, 사용하고자 하는 클래스 형태는 원본이 아니라, 사용가능한 .class 기계어를 가져와야한다.
//따라서 bin 디렉토리 밑에 있는 클래스의 위치를 지정해줘야한다.


//import D:\korea202102_javaworkspace\project0428\bin\monster\PocketMon.class;
//위의 경로는 자바의 슬로건인 어떤 os에서든 사용가능할 수 있는 형태가 아니다
//이 경론은 사람마다 다르고, os마다 경로 표기법이 다르기 때문에 jvm이 해석할 수 있는 경로를 입력해야한다.

//자바는 디렉토리란 말을 쓰지 않을 뿐 아니라, 즉 패키지라고 하며 패키지는 . 으로 구분한다.
import monster.PocketMon;

 class  UseMon{
	public static void main(String[] args){
		//포켓몬 인스턴스 1개 생성하여, 메서드 호출하기
		PocketMon mon=new PocketMon();
	}
 }