class Car{
	String name="Benz";
	int price=9000;
	String color="silver";

	public void setPrice(int price){
		this.price=price;
	}

	public static void main(String[] args){
		Car c1=new Car();
		Car c2=new Car();
		Car c3=c2;

		c1.setPrice(8000);
		System.out.println(c2.price);

		c3.setPrice(7000);
		System.out.println(c2.price);
	}
}