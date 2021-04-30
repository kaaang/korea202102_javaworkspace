package bank;

class Friend{
	public static void main(String[] args){
		Account acc = new Account();
		//System.out.println("원래 잔고는 : "+acc.balance);
		//acc.balance=acc.balance+8000;
		acc.setBalance(150000);
		System.out.println("변경 후 잔고는 : "+acc.getBalance());


		//현재 Friend 클래스는 Account와 같은 패키지에 있으므로, Account가 보유한 
		//default 접근 제한이 걸려 있는 모든 변수에 맘대로 접근이 가능하다.

		System.out.println("은행명 : "+acc.bankName);
		System.out.println("계좌주 : "+acc.master);
		System.out.println("계좌번호 : "+acc.num);

	}
}