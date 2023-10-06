package com.feature;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.encryption.EncryptDecrypt;
import com.mysql.cj.jdbc.MysqlDataSource;

/**
 * Servlet implementation class UserData
 */
@WebServlet("/UserData")
public class UserData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("In the User Data Servelet");
		MysqlDataSource sql= new MysqlDataSource();
		String qry = "select * from clientdata where Username=?";
		PreparedStatement prp;
		ResultSet rs;
		Properties prop = new Properties();
		InputStream input = null;
		HttpSession session = request.getSession();
		String usrNme = (String) session.getAttribute("uname");
		String Password= null;
		String Name= null;
		String Contact= null;
		//Retrieving the user from database
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
			prp.setString(1,usrNme);
			
			//execute the query
			rs= prp.executeQuery();
			
			while (rs.next())
			{
				Password=rs.getString("Password");
				Name=rs.getString("Name");
				Contact=rs.getString("Contact");
			}
			System.out.println("Password= "+Password);
			System.out.println("Name= "+Name);
			System.out.println("Contact= "+Contact);
			
			EncryptDecrypt ed = new EncryptDecrypt();			
			request.setAttribute("Password",ed.decryptPass(Password));		
			request.setAttribute("Name",Name);	
			request.setAttribute("Contact", Contact);	
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
		
		RequestDispatcher rd = 
	             request.getRequestDispatcher("update.jsp");
		rd.forward(request, response);
	}

	

}
