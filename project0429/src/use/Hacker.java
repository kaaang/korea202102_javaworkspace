package use;

import bank.Account;
class Hacker{
	public static void main(String[] args){
		Account acc = new Account();
		//System.out.println("���� "+acc.master+"�� ������ �ܰ� : "+acc.balance);

		//�����, ������, ���¹�ȣ

		System.out.println("����� : "+acc.bankName);
		System.out.println("������ : "+acc.master);
		System.out.println("���¹�ȣ : "+acc.num);

	}
}