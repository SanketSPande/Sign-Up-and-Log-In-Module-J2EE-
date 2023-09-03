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
		
		out.print("<html>");
		out.print("<script> function message(){ alert('Registration Successful');} </script>");
		
		out.print("<body> onload ='message()' </body>");
		out.print("</html>");
				
		//Capture the data entered by the client
		Integer clientid = null;
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String contact = request.getParameter("contact");
		
		//set the session attribute
		session.setAttribute("permission","deny");
		
		//Make a database connection
		Connection conn;
		MysqlDataSource sql=new MysqlDataSource();;
		String qry = "insert into clientdata (ClientId,Username,Password,Name,Contact)  values (?,?,?,?,?)";
		String qry1 = "select * from clientdata order by clientid desc limit 1";
		PreparedStatement prp;
		ResultSet rs;
		Properties prop = new Properties();
		InputStream input = null;
		
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
			}
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
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
			
			if(clientid==1) {
			prp.setInt(1,1);
			}else {
				prp.setInt(1,clientid+1);
			}
			prp.setString(2,username);
			prp.setString(3,password);
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
		
		
		

		
		
		response.sendRedirect("RegSuc.jsp");
		
	}

}
