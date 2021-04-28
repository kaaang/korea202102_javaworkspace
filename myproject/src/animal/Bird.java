package animal; //컴파일시, 이 Bird의 .class를 animal이란 패키지를 자동으로 생성하여, 넣어준다. ->javac -d 옵션으로 의해


//패키지에 넣어둔 클래스는 아무도 접근을 못하므로 public으로 공개해야 한다
public class Bird{
	String name="제비";

	public void fly(){
		System.out.println(name+"가 날아간다~");
	}
}