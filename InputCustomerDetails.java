package database;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/InputCustomerDetails")
public class InputCustomerDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	//Driver name and URL
	final String DRIVER ="oracle.jdbc.driver.OracleDriver";
	final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	
	//User Credentials
	final String USER = "bank";
	final String PASS = "pass";
	
	//Connection and preparedStatement
	Connection con = null;
	PreparedStatement stmt = null;
	
	
	
    //Establish database connection
	public void establishConnection() {
		
		
		try {
			//Register
			Class.forName(DRIVER);
			
			//Connect to Oracle
			con = DriverManager.getConnection(DB_URL, USER, PASS);
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}//end of method establishConnection
	
	public void closeConnection() {
		try {
			con.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}//end of try...catch
	}//end of method
	
	
	//method to reverse the date format into 'dd-mm-yyyy'
	
	 public static String convertDateString(String dateString) {
	        // Parse the input string into a LocalDate object
	        LocalDate date = LocalDate.parse(dateString);

	        // Define the desired output format
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

	        // Format the LocalDate object into the desired output string format
	        String formattedDateString = date.format(formatter);

	        return formattedDateString;
	    }//end of method
	
	//method to generate account number
	 private String generateAccountNumber() {
			
			String digits = "1234567890";
			String accountNumber="";
			Random random = new Random();
			
			//Randomly picks out letters and digits for the account number
			
			
			for(int inc=1; inc<=12; inc++) {
				accountNumber += digits.toCharArray()[random.nextInt(10)];
			}//end of loop
			
			return accountNumber;
		}//end of method
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		establishConnection();  
		
		// account Number Generator
		
		String accountNumber =  generateAccountNumber();
		
		
		// Get data from jsp page
		String first = request.getParameter("first");
		String middle = request.getParameter("middle");
		String last = request.getParameter("last");
		String email = request.getParameter("email");
		String city = request.getParameter("city");
		String gender = request.getParameter("gender");
		String phone = request.getParameter("phone");
		String occupation = request.getParameter("occupation");
		String dob_temp = request.getParameter("dob");
		String addhar = request.getParameter("addhar");
		
		
		//reverse the string dob to enter in database
		String dob = convertDateString(dob_temp);
		
		
	
		
		//setting up query and putting it in database
		
		try {
			String sql = "INSERT into CUSTOMER(accountnumber, custpin, firstname, middlename, lastname, city, mobile, occupation, gender, dob, addhar, email) values(?,?,?,?,?,?,?,?,?,?,?,?)";
			stmt = con.prepareStatement(sql);
			
			stmt.setString(1, accountNumber);
			stmt.setInt(2, 1234);
			stmt.setString(3, first);
			stmt.setString(4, middle);
			stmt.setString(5, last);
			stmt.setString(6, city);
			stmt.setString(7, phone);
			stmt.setString(8, occupation);
			stmt.setString(9, gender);
			stmt.setString(10, dob);
			stmt.setString(11, addhar);
			stmt.setString(12, email);
			stmt.executeUpdate();
			System.out.println("Registration done...");
			request.getRequestDispatcher("home.jsp").forward(request, response);
			
			//closing statement
			stmt.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}//end of try...catch

		//closing database
		closeConnection();
	}//end of doPost method

}//end of class
