package animal.birds;

public class Bird{

	String name="그냥 새";
	boolean hasWing=true;
	String color;

	public Bird(String color){
		this.color=color;
	}


	public void fly(){
		System.out.println(name+"가 날아다닙니다.");
	}

}