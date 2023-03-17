package account;

import java.util.Random;

public class accountSavings {
	private String accountNumber="";
	private int custId;
	private int custPin;
	private double balance;
	
	
	//Generating the account number
	private void generateAccountNumber() {
		String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String digits = "1234567890";
		
		
		
		Random random = new Random();
		
		//Randomly picks out letters and digits for the account number
		for(int inc = 0; inc<2; inc++) {
			accountNumber += letters.toCharArray()[random.nextInt(26)];
		}//end of loop
		
		for(int inc=1; inc<=8; inc++) {
			accountNumber += digits.toCharArray()[random.nextInt(10)];
		}//end of loop
		
	}//end of method
	
	
	
	
	
	
	
	//Getters and Setters
	public String getAccountNumber() {
		
		generateAccountNumber();
		return accountNumber;
	}
	
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public int getCustPin() {
		return custPin;
	}
	public void setCustPin(int custPin) {
		this.custPin = custPin;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
	
	
}//end of class
