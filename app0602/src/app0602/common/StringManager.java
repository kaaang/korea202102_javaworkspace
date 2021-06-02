package app0602.common;

public class StringManager {
	
	//넘겨받은 인수가 1자리수 인 경우 앞에 0을 붙이고
	//2자리수라면 그냥 쓴다
	public static String getZeroString(int n) {
		return (n<10)? "0"+n:Integer.toString(n);
	}
	
}
