package animal.dog;

public class UseDog{

	public static void main(String[] args){
		Siba s = new Siba();
		Sigorjavjong j = new Sigorjavjong();

		s.run();
		j.run();
		System.out.println("");
		s.shout();
		j.shout();
	}

}