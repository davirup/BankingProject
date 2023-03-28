package database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdatePin")
public class UpdatePin extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	//Driver name and URL
			final String DRIVER ="oracle.jdbc.driver.OracleDriver";
			final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
			
			//User Credentials
			final String USER = "bank";
			final String PASS = "pass";
			
			//Connection and preparedStatement
			Connection con = null;
			PreparedStatement stmt = null;
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Getting the data from the webpage
		String accntNum = request.getParameter("accountnumber").trim();
		int oldpin = Integer.parseInt(request.getParameter("oldpin").trim());
		int newpin = Integer.parseInt(request.getParameter("newpin").trim());
		
		
		
		try {
			//Register into database
			Class.forName(DRIVER);
			
			//Establish Connection
			con = DriverManager.getConnection(URL, USER, PASS);
			
			//Establish queries
			
			
			// Validating the information first
			String validate = "select accountnumber, custpin from customer where accountnumber in ?";
			
			stmt = con.prepareStatement(validate);
			
			stmt.setString(1, accntNum);
			
			ResultSet validateResult = stmt.executeQuery();
			System.out.println("Query successful...");
			
			
			if(!validateResult.equals(null)) {
				
				while(validateResult.next()) {
					//Retreiving data
					String checknumber = validateResult.getString("accountnumber").trim();
					int checkpin = validateResult.getInt("custpin");
					
				//Validating
				if(accntNum.equals(checknumber)) {
					if(oldpin == checkpin) {
						String sql = "update customer set custpin = (?) where accountnumber = (?)";
						stmt = con.prepareStatement(sql);
						
						stmt.setInt(1, newpin);
						stmt.setString(2, accntNum);
						
						stmt.executeUpdate();
						System.out.println("Update successful...");
						//go to acknowledgement page
						request.getRequestDispatcher("ackwlodgement.jsp").forward(request, response);
					} else {
						request.getRequestDispatcher("incorrectentry.jsp").forward(request, response);
					}
				} else {
					request.getRequestDispatcher("incorrectentry.jsp").forward(request, response);
				}
				}//end of while loop
			} else {
				System.out.println("Incorrect entry");
				request.getRequestDispatcher("incorrectentry.jsp").forward(request, response);
			} //end of outer if else
				
				//closing database objects
				stmt.close();
				con.close();
				
		} catch(Exception e) {
			e.printStackTrace();
		}
	
		
		
	}//end of doPost

}//end of class
