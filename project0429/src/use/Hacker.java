package use;

import bank.Account;
class Hacker{
	public static void main(String[] args){
		Account acc = new Account();
		//System.out.println("현재 "+acc.master+"이 보유한 잔고 : "+acc.balance);

		//은행명, 계좌주, 계좌번호

		System.out.println("은행명 : "+acc.bankName);
		System.out.println("계좌주 : "+acc.master);
		System.out.println("계좌번호 : "+acc.num);

	}
}