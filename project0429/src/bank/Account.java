package bank;


//�ڹٴ� Ŭ������ ���� ����� �����ϹǷ�, ���Ȼ� ������ �ʾҴ� ������ �߻��� �� �ֱ� ������ 
//�̸� �����ϱ� ���� ���������ڶ�� ����ó���� �����Ѵ�..

//�ڹ��� ���� ó���� ������ ���� �� 4�ܰ�� �����ʴ�.

/*
	(����)                               ��Ӱ���/������Ű��                       ������Ű��                      ����(���� ���)��밡��
	public                 <                protected             <              default            <            private


*/


public class Account{
	private String bankName="kakaobank";
	private String master="KSH";
	private int balance=5000;
	private String num="3333-03-3612667";

	//�������� ���� ������ ��������, ������ ����ڵ� ������� ���ϰ� �Ǿ����Ƿ�
	//������ ����ڰ� ������ �� �ִ� � ��ġ�� ����������
	public void setBalance(int balance){
		this.balance = balance;
	}
	public int getBalance(){
		return balance;
	}


	public void setMaster(String master){
		this.master = master;
	}
	public String getMaster(){
		return master;
	}

	public void setMaster(String master){
		this.master = master;
	}
	public String getMaster(){
		return master;
	}

	public void setBankName(String bankName){
		this.bankName = bankName;
	}
	public String getBankName(){
		return bankName;
	}

	public void setNum(String num){
		this.num = num;
	}
	public String getNum(){
		return num;
	}

}