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

import com.mysql.cj.jdbc.MysqlDataSource;

/**
 * Servlet implementation class PasswordValidation
 */
@WebServlet("/PasswordValidation")
public class PasswordValidation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PasswordValidation() {
        super();
        // TODO Auto-generated constructor stub
    }
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String password = request.getParameter("password");
		String username = (String) session.getAttribute("uname");
		//Authentication
		Connection conn;
		MysqlDataSource sql= new MysqlDataSource();
		String qry = "select * from clientdata where Username=?";
		PreparedStatement prp;
		ResultSet rs;
		String pass = null;
		Properties prop = new Properties();
		InputStream input = null;
		
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
				response.sendRedirect("update.jsp");
				
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
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		    }
		}
	}

}
