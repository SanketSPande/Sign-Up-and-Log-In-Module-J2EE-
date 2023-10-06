package com.feature;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.encryption.EncryptDecrypt;
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
				System.out.println("Password entered by user = "+password);
				
		//If the user do not enter any of the two or both of two
				if(username == null || password == null)
					response.sendRedirect("Signin.jsp");
	    
		//Authentication
				MysqlDataSource sql= new MysqlDataSource();
				String qry = "select * from clientdata where Username=?";
				String qry1 = "select username from clientdata where Username=?";
				PreparedStatement prp;
				ResultSet rs;
				String dcr_pass = null;
				String usrNme = null;
				Properties prop = new Properties();
				InputStream input = null;
				
				//Checking if the user exist ?
				try {
					input = Thread.currentThread().getContextClassLoader().getResourceAsStream("application.properties");
					
					// load a properties file
				    prop.load(input);
				    
				  //enter the database credentials
				    sql.setUser(prop.getProperty("userName"));
					sql.setPassword(prop.getProperty("userPwd"));
					sql.setDatabaseName(prop.getProperty("dbName"));
					sql.setServerName(prop.getProperty("serverName"));
					sql.setPort(Integer.parseInt(prop.getProperty("serverPort")));
					
					//get the connection
					Connection conn;
					conn = sql.getConnection();
					
					//inject qry in statement type object
					prp = conn.prepareStatement(qry1);			
					prp.setString(1,username);
					
					//execute the query
					rs= prp.executeQuery();
					
					while (rs.next())
					{
						usrNme = rs.getString("username");
					}
					System.out.println(usrNme);
					//take the decision									
					if(usrNme=="" || usrNme==null)
					{	System.out.println("User doesn't exist");				   
						response.sendRedirect("userNotExist.jsp");
						
					}					
					conn.close();					
				}catch(Exception e) {
					e.printStackTrace();
				}
				finally {
				    if (input != null) {
				        try {
				            input.close();
				        } catch (IOException e) {
				            e.printStackTrace();
				        }
				    }
				}
				
				//Authenticating the existing User against database
				if(usrNme!=null) {				
				
					try {
						input = Thread.currentThread().getContextClassLoader().getResourceAsStream("application.properties");
					
						// load a properties file
				    	prop.load(input);
				    
				    	//enter the database credentials
				    	sql.setUser(prop.getProperty("userName"));
						sql.setPassword(prop.getProperty("userPwd"));
						sql.setDatabaseName(prop.getProperty("dbName"));
						sql.setServerName(prop.getProperty("serverName"));
						sql.setPort(Integer.parseInt(prop.getProperty("serverPort")));
					
						//get the connection
						Connection conn;
						conn = sql.getConnection();
					
						//inject qry in statement type object
						prp = conn.prepareStatement(qry);			
						prp.setString(1,username);
					
						//execute the query
						rs= prp.executeQuery();
					
						while (rs.next())
						{
							String temp_string = new String();
							EncryptDecrypt ed = new EncryptDecrypt();
							temp_string= rs.getString("Password");
							dcr_pass = ed.decryptPass(temp_string);
							
							System.out.println("Decrypted Password = "+dcr_pass);
							
						}
				
						//take the decision									
						if(dcr_pass.equals(password))
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
					finally {
				    	if (input != null) {
				        	try {
				            	input.close();
				        	}catch (IOException e) {
				            	e.printStackTrace();
				        	}
				    	}
					}
				}
	}

	
}
