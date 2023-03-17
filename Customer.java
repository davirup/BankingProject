package account;

import java.util.HashMap;
import java.util.Map;


public class Customer {
	
	private int custId;
	private String custName;
	private String address;
	private long phoneNumber;
	private String addharId;
	
	//Store all the accounts and the pins of that particular customer in the set
	private Map<String, Integer> accounts = new HashMap<>();
	
	
	
	//All getters and setters
	
	public String getCustName() {
		return custName;
	}


	public void setCustName(String custName) {
		this.custName = custName;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public long getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getAddharId() {
		return addharId;
	}


	public void setAddharId(String addharId) {
		this.addharId = addharId;
	}

	
	public int getCustId() {
		return custId;
	}


	public void setCustId(int custId) {
		this.custId = custId;
	}


	public Map<String, Integer> getAccounts() {
		return accounts;
	}


	public void setAccounts(Map<String, Integer> accounts) {
		this.accounts = accounts;
	}
	
	
	
	
}//end of class
