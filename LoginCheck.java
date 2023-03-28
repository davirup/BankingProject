package database;

import java.io.IOException;
import java.io.PrintWriter;
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

/**
 * Servlet implementation class LoginCheck
 */
@WebServlet("/LoginCheck")
public class LoginCheck extends HttpServlet {
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
		
		
		//Close database connection
		public void closeConnection() {
			try {
				con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}//end of try...catch
		}//end of method
		
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		String accntNum = request.getParameter("accountnumber");
		int custpin = Integer.parseInt(request.getParameter("custpin"));
		
		
		
		//establish connection
		establishConnection();
		
		
		//Validate input from database
		
		
		String sql = "select accountnumber, custpin from customer where accountnumber = (?)";
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, accntNum);
			
			ResultSet result = stmt.executeQuery();
			
			
			
			
			while(result.next()) {
				
				//retreiving data
				String checkAccntNum = result.getString("accountnumber");
				int checkPin = result.getInt("custpin");
				
				
				//Validating
				if(accntNum.equals(checkAccntNum)) {
					if(custpin == checkPin) {
						request.getRequestDispatcher("/home.jsp").forward(request, response);
					}
					else {
						
				          
				          request.getRequestDispatcher("/loginerror.jsp").forward(request, response);
					}
				} else {
					
					request.getRequestDispatcher("/loginerror.jsp").forward(request, response);
				}
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
	
	}

}
