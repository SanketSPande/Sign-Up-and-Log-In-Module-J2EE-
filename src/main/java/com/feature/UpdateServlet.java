package com.feature;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

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
		response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");//Http 1.1
		response.setHeader("Pragma","no-cache");//Http 1.0
		response.setDateHeader ("Expires", 0);//Proxies
		HttpSession session = request.getSession();

		if(session.getAttribute("uname")==null)
			response.sendRedirect("Signin.jsp");
		else if(session.getAttribute("pass")==null)
			response.sendRedirect("home.jsp");
		
		
		//Update the data from database
		MysqlDataSource sql = new MysqlDataSource();
		Connection conn = null;
		PreparedStatement prp = null;
		String username = (String) session.getAttribute("uname");
		Properties prop = new Properties();
		InputStream input = null;
		//System.out.println("uname == "+username);	
		
		
						
		//prepare the queries
		String qry1 ="update clientdata set Password=? where Username =?";	
		String qry2 ="update clientdata set Name=? where Username =?";
		String qry3 ="update clientdata set Contact=? where Username =?";
		
		
		
		//get the connection
		String password = request.getParameter("password");
		if(password!="") {
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
				
		
	
		String name = request.getParameter("name");
		if(name!="") {
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
		
		
		Long contact = null;
		String temp_contact = request.getParameter("contact");	
		//System.out.println(temp_contact);
		if(temp_contact!="")
		contact = Long.parseLong(temp_contact);
		if(contact!=null) {
				
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
		session.setAttribute("pass",null);
		response.sendRedirect("home.jsp");	
    }
}



