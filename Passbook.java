package database;

public class Passbook {
	private String accountnumber;
	private String date;
	private String particular;
	private double balance;
	private double deposit;
	private double withdrawal;
	
	Passbook(String accountnumber, String date, String particular, double balance, double deposit, double withdrawal){
		this.accountnumber = accountnumber;
		this.date = date;
		this.particular = particular;
		this.balance = balance;
		this.deposit = deposit;
		this.withdrawal = withdrawal;
	}
	
	
	// getter methods to display the data
	public String getAccountnumber() {
		return accountnumber;
	}

	public String getDate() {
		return date;
	}

	public String getParticular() {
		return particular;
	}

	public double getBalance() {
		return balance;
	}

	public double getDeposit() {
		return deposit;
	}

	public double getWithdrawal() {
		return withdrawal;
	}
	
	
}//end of class
