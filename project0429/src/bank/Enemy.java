package bank;

class Enemy{
	public static void main(String[] args){
		Account acc = new Account();
		System.out.println("���� �ܰ�� : "+acc.balance);
		acc.balance=acc.balance-5000;
		System.out.println("���� �� �ܰ�� : "+acc.balance);
	}
}