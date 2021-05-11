package app0511.wrapper;
/*
 * Java의 기본 자료형마다 1:1 대응되는 객체가 지원되는데, 이러한 클래스를 가리켜 Wrapper클래스라 한다.
 * 
 * */
public class WrapperTest {
	public static void main(String[] args) {
		Integer it=9;//가능함
		//내부적으로 9라는 정수를 객체화 시켜준 것이다. 이현상을 wrapping이라 하고 이러한 형변화를 가르켜서
		//sun에서는 Boxing라 한다. (즉, 기본 자료형이 객체자료형으로 형변환된 현상)
		int k=it; //객체자료형이 기본 자료형ㅇ로 자동으로 형변환 되는것이므로 unBoxing이라 한다.
	}
}
