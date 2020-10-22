package bank;
public class Account 
{
	public String bank="기업은행";
	protected String customer = "홍길동";
	String num = "022-388-/8798";
	private int balance=100000;

	public void setBalance(int balance) {
		this.balance = balance;
	}
	public int getBalance() {
		return balance;
	}
	
	public static void main(String[] args) 
	{
		
	}
}
