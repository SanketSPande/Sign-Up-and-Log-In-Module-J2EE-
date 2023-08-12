package com.feature;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.jdbc.MysqlDataSource;

/**
 * Servlet implementation class SignupDataCapture
 */
@WebServlet("/Signup")
public class SignupDataCapture extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public SignupDataCapture() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		out.print("<script> function message(){ alert('Registration Successful');} </script>");
		
		out.print("<body> onload ='message()' </body>");
		out.print("</html>");
				
		//Capture the data entered by the client
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String contact = request.getParameter("contact");
		
		//Store data to database
		Connection conn;
		MysqlDataSource sql=new MysqlDataSource();;
		String qry = "insert into clientdata (Username,Password,Name,Contact)  values (?,?,?,?)";
		PreparedStatement prp;
		
		try {
			//get the connection
			sql.setUser("root");
			sql.setPassword("abcd");
			sql.setDatabaseName("java_crs_db");
			sql.setServerName("localhost");
			sql.setPort(3306);
			conn = sql.getConnection();
			
			//inject qry in statement type object
			prp = conn.prepareStatement(qry);			
			prp.setString(1,username);
			prp.setString(2,password);
			prp.setString(3,name);			
			prp.setInt(4, Integer.parseInt(contact));
			
			//execute the query
			int row = prp.executeUpdate();
			if(row >0)
				System.out.println("Data Injected into Table");
			else
				System.out.println("Data Failed to Inject");
			
			conn.close();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		response.sendRedirect("RegSuc.jsp");
		
	}

}
