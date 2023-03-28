package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Transaction {
	
	//Database login info
	private String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private String USER = "bank";
	private String PASS = "pass";
	
	//Connection and statements
	Connection con=null;
	PreparedStatement stmt = null;
	
	//Method to convert date into dd-mm-yyyy format
	public static String convertDateString(String dateString) {
        // Parse the input string into a LocalDate object
        LocalDate date = LocalDate.parse(dateString);

        // Define the desired output format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        // Format the LocalDate object into the desired output string format
        String formattedDateString = date.format(formatter);

        return formattedDateString;
    }//end of method
	
	
	
	public void moneyIn(double balance, double amount, String particular, String accountNumber, String date_temp) {
		
		//converting date to dd--mm--yyyy format
		String date = convertDateString(date_temp);
		
		
		try {
			//Register the driver
			Class.forName(DRIVER);
			
			//Establish connection
			con = DriverManager.getConnection(URL, USER, PASS);
			
			//create query
			String sql = "INSERT into TRANSACTION(accountnumber, moneyin, particular, balance, dateoftransaction) values(?,?,?,?,?)";
			stmt = con.prepareStatement(sql);
			
			stmt.setString(1, accountNumber);
			stmt.setDouble(2, amount);
			stmt.setString(4, particular);
			stmt.setDouble(5, balance);
			stmt.setString(6, date);
			
			
			System.out.println("transaction updated...");
			
			
			//cleaning up
			stmt.close();
			con.close();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}//end of method
	
	public void moneyOut(double balance, double amount, String particular, String accountNumber, String date_temp) {
		
		//Converting the date
		String date = convertDateString(date_temp);
		
		
		try {
			//Register the driver
			Class.forName(DRIVER);
			
			//Establish connection
			con = DriverManager.getConnection(URL, USER, PASS);
			
			//create query
			String sql = "INSERT into TRANSACTION(accountnumber, moneyout, particular, balance, dateoftransaction) values(?,?,?,?,?)";
			stmt = con.prepareStatement(sql);
			
			stmt.setString(1, accountNumber);
			stmt.setDouble(3, amount);
			stmt.setString(4, particular);
			stmt.setDouble(5, balance);
			stmt.setString(6, date);
			
			
			System.out.println("transaction updated...");
			
			
			//cleaning up
			stmt.close();
			con.close();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}//end of method
	
	
	
}//end of class
