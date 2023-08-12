package com.feature;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.jdbc.MysqlDataSource;


@WebServlet("/Update")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub	
		
		//Update the data from database
		MysqlDataSource sql = new MysqlDataSource();
		Connection conn = null;
		PreparedStatement prp = null;
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("uname");	
		//System.out.println("uname == "+username);	
		
		
						
		//prepare the queries
		String qry1 ="update clientdata set Password=? where Username =?";	
		String qry2 ="update clientdata set Name=? where Username =?";
		String qry3 ="update clientdata set Contact=? where Username =?";
		
		//enter the database credentials
		sql.setUser("root");
		sql.setPassword("abcd");
		sql.setDatabaseName("java_crs_db");
		sql.setServerName("localhost");
		sql.setPort(3306);
		
		//get the connection
		String password = request.getParameter("password");
		if(password!="") {
				try {
						conn = sql.getConnection();
			
						//inject the query into statement type object	
			
						prp = conn.prepareStatement(qry1);
						prp.setString(1,password );
						prp.setString(2,username );
						prp.executeUpdate();	
						
						conn.close();
					}
				catch (Exception e) {
						// TODO Auto-generated catch block			
						e.printStackTrace();
					}
			
		}
				
		
	
		String name = request.getParameter("name");
		if(name!="") {
				try {
						conn = sql.getConnection();
						prp = conn.prepareStatement(qry2);
						prp.setString(1,name );
						prp.setString(2,username );
						prp.executeUpdate();
						
						conn.close();
					}
		
				catch (Exception e) {
						// TODO Auto-generated catch block			
						e.printStackTrace();
					}
						
		}
		
		
		Long contact = null;
		String temp_contact = request.getParameter("contact");	
		//System.out.println(temp_contact);
		if(temp_contact!="")
		contact = Long.parseLong(temp_contact);
		if(contact!=null) {
				
				try {
						conn = sql.getConnection();
						prp = conn.prepareStatement(qry3);
						prp.setLong(1,contact);
						prp.setString(2,username);
						prp.executeUpdate();
						
						conn.close();
					}
		
				catch (Exception e) {
						// TODO Auto-generated catch block			
						e.printStackTrace();
					}
		
		}
		
		response.sendRedirect("home.jsp");	
    }
}



