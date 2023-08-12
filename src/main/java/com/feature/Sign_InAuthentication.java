package com.feature;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.jdbc.MysqlDataSource;

/**
 * Servlet implementation class Sign_InAuthentication
 */
@WebServlet("/Signin")
public class Sign_InAuthentication extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Sign_InAuthentication() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		
		
		//Capture the data entered by the client
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				
		//If the user do not enter any of the two or both of two
				if(username == null || password == null)
					response.sendRedirect("Signin.jsp");
	    
		//Authentication
				Connection conn;
				MysqlDataSource sql= new MysqlDataSource();
				String qry = "select * from clientdata where Username=?";
				PreparedStatement prp;
				ResultSet rs;
				String pass = null;
				
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
					
					//execute the query
					rs= prp.executeQuery();
					
					while (rs.next())
					{
						pass = rs.getString("Password");
					}
				
					//take the decision									
					if(pass.equals(password))
					{	System.out.println("Authenticated");				   
					    session.setAttribute("uname",username);
						response.sendRedirect("home.jsp");
						
					}
					else {
						System.out.println("Access Denied");
						response.sendRedirect("WrongCreden.jsp");
					}
					conn.close();					
				}catch(Exception e) {
					e.printStackTrace();
				}
	}

	
}
