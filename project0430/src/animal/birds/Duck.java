package animal.birds;

public class Duck extends Bird{
						//extends -> is a
	String name="난 오리";
	String color;

	public Duck(String color){
		super(color);
	}

	public void canSwim(){
		System.out.println("수영을 잘합니다.");
	}

}