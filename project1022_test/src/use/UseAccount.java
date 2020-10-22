package use;
import bank.Account;
class UseAccount 
{
/*
	public String bank="";
	protected String customer;
	String num = "022-388-/8798";
	private int balance=100000;
*/
	public static void main(String[] args) 
	{
		Account acc = new Account();
		System.out.println("public String : "+ acc.bank);
		//System.out.println("protected String : "+ acc.customer);
		//System.out.println("Default String : "+ acc.num);
		//System.out.println("private String : "+ acc.balance);

		acc.setBalance(10);
		System.out.println(acc.getBalance());
	}
}
