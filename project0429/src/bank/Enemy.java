package bank;

class Enemy{
	public static void main(String[] args){
		Account acc = new Account();
		System.out.println("원래 잔고는 : "+acc.balance);
		acc.balance=acc.balance-5000;
		System.out.println("변경 후 잔고는 : "+acc.balance);
	}
}