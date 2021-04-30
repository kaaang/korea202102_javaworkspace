package animal.birds;




class UseDuck{
	public static void main(String[] args){
		Duck d = new Duck("white");
		d.canSwim();
		
		Bird b = new Bird("white");
		b=d; //°¡´É
	}

}