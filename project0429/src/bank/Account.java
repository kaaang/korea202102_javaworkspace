package bank;


//자바는 클래스간 서로 사용이 가능하므로, 보안상 뜻하지 않았던 문제가 발생할 수 있기 때문에 
//이를 보완하기 위해 접근제한자라는 보안처리를 지원한다..

//자바의 보안 처리는 다음과 같이 총 4단계로 구성됨다.

/*
	(공개)                               상속관계/같은패키기                       같은패키지                      나만(나의 멤버)사용가능
	public                 <                protected             <              default            <            private


*/


public class Account{
	private String bankName="kakaobank";
	private String master="KSH";
	private int balance=5000;
	private String num="3333-03-3612667";

	//데이터의 직접 접근은 막았으나, 선의의 사용자도 사용하지 못하게 되었으므로
	//선의의 사용자가 접글할 수 있는 어떤 장치를 마련해주자
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