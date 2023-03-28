package database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/TransactionHistory")
public class TransactionHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	

	//Database login info
	private String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private String USER = "bank";
	private String PASS = "pass";
	
	//Connection and statements
	Connection con=null;
	PreparedStatement stmt = null;
	
	
	
	
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//get values entered in form
		String accntNum = request.getParameter("accountnumber");
		int custpin = Integer.parseInt(request.getParameter("custpin"));
		response.setContentType("text/html");
		
		
		try {
			//Register into database
			Class.forName(DRIVER);
			
			//Establish Connection
			con = DriverManager.getConnection(URL, USER, PASS);
			
			//Establish queries
			
			
			// Validating the information first
			String validate = "select accountnumber, custpin, firstname from customer where accountnumber in ?";
			
			stmt = con.prepareStatement(validate);
			
			stmt.setString(1, accntNum);
			
			ResultSet validateResult = stmt.executeQuery();
			
			if(!validateResult.equals(null)) {
				
				while(validateResult.next()) {
					String firstname = validateResult.getString("firstname");
					
					if(accntNum.equals(validateResult.getString("accountnumber"))) {
						if(custpin == validateResult.getInt("custpin")) {
							//getting the details
							String sql = "select * from transaction where accountnumber in ?";
							stmt = con.prepareStatement(sql);
							
							stmt.setString(1, accntNum);
							
							ResultSet result = stmt.executeQuery();
							
							
							ArrayList<Passbook> list = new ArrayList<>();
							if(!result.equals(null)) {
								
								while(result.next()) {
									
									//Retrieve the data
									String accountnumber = result.getString("accountnumber");
									double deposit = result.getDouble("moneyin");
									double withdrawal = result.getDouble("moneyout");
									String particular = result.getString("particular");
									double balance = result.getDouble("balance");
									String date = result.getString("dateoftransaction");
									
									
									//put data in arraylist
									list.add(new Passbook(accountnumber, date, particular, balance, deposit, withdrawal));

								}//end of while loop
								
								//Requestdispatcher and setattribute to pass data to the display page
								RequestDispatcher rd = request.getRequestDispatcher("displayTransactionDetails.jsp");
								
								request.setAttribute("data", list);
								rd.forward(request, response);
								
								result.close();
								
						} else {
							request.getRequestDispatcher("invalidinput.jsp").forward(request, response);
						}
					} else {
						request.getRequestDispatcher("invalidinput.jsp").forward(request, response);
					}
					
				}//end of loop
			}
			
			
			
				//closing database objects
				validateResult.close();
				stmt.close();
				con.close();
				
			}//end of if
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}//end of doPost method

}//end of class
