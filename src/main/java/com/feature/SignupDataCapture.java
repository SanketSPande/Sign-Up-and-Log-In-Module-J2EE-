package com.feature;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
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
		response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");//Http 1.1
		response.setHeader("Pragma","no-cache");//Http 1.0
		response.setDateHeader ("Expires", 0);//Proxies
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		
				
		//Capture the data entered by the client
		Integer clientid = null;
		String username = request.getParameter("username");
		
		String passFromUsr = request.getParameter("pwd");		
		//Encryption of password
		EncryptDecrypt ed = new EncryptDecrypt();
		String encrPassword = ed.encryptPass(passFromUsr);
		
		String name = request.getParameter("name");
		String contact = request.getParameter("contact");
		String usrFrmDB = null;
		System.out.println("username = "+username);
		System.out.println("passFromUsr = "+passFromUsr);
		System.out.println("encrPassword = "+encrPassword);
		System.out.println("name = "+name);
		System.out.println("contact = "+contact);
	
		
		//Make a database connection
		Connection conn;
		MysqlDataSource sql=new MysqlDataSource();;
		String qry = "insert into clientdata (ClientId,Username,Password,Name,Contact)  values (?,?,?,?,?)";
		String qry1 = "select * from clientdata order by clientid desc limit 1";
		String qry2 = "select username from clientdata where Username=?";
		PreparedStatement prp;
		ResultSet rs;
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
			conn = sql.getConnection();
			
			//inject qry in statement type object
			prp = conn.prepareStatement(qry2);			
			prp.setString(1,username);
			
			//execute the query
			rs= prp.executeQuery();
			
			while (rs.next())
			{
				usrFrmDB = rs.getString("username");
			}
			System.out.println(usrFrmDB);								
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
		
		System.out.println(usrFrmDB);
		//take the decision									
		if(usrFrmDB!=null)
		{	System.out.println("Username already exist");				   
			response.sendRedirect("userAlreadyExists.jsp");
			
		}
		else {	
		
		
		//Fetching the id of lastly stored entry
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
			prp = conn.prepareStatement(qry1);
			
			//execute the query
			rs= prp.executeQuery();;
			while (rs.next())
			{
				clientid = rs.getInt(1);
				System.out.println("client iD = "+clientid);
			}
			//System.out.println("client iD = "+clientid);
			
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
		
		
		//Store data to database
		try {
			
			input = Thread.currentThread().getContextClassLoader().getResourceAsStream("application.properties");
			
			// load a properties file
		    prop.load(input);
		    
		  //enter the database credentials
		    sql.setUser(prop.getProperty("userName"));
			sql.setPassword(prop.getProperty("userPwd"));
			sql.setDatabaseName(prop.getProperty("dbName"));
			sql.setServerName(prop.getProperty("serverName"));
			sql.setPort(3306);
			conn = sql.getConnection();
			
			//inject qry in statement type object
			prp = conn.prepareStatement(qry);
			
			
			if(clientid==null) {
			prp.setInt(1,1);
			}else {
				prp.setInt(1,clientid+1);
			}
			prp.setString(2,username);
			prp.setString(3,encrPassword);
			prp.setString(4,name);			
			prp.setLong(5,Long.parseLong(contact));
			
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
		finally {
		    if (input != null) {
		        try {
		            input.close();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		    }
		}
		
		response.sendRedirect("RegSuc.jsp");
		}
		
	}

}
