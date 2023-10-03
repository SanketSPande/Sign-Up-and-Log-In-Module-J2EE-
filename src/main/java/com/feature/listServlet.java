package com.feature;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
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

import com.mysql.cj.jdbc.MysqlDataSource;


@WebServlet("/lServlet")
public class listServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
   
    public listServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		// TODO Auto-generated method stub
		
		//Cache control
		response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");//Http 1.1
		response.setHeader("Pragma","no-cache");//Http 1.0
		response.setDateHeader ("Expires", 0);//Proxies
		HttpSession session = request.getSession();
		if(session.getAttribute("uname")==null)
			response.sendRedirect("Signin.jsp");
		
		
		response.getWriter();		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		//open the database connection
		Connection conn;
		MysqlDataSource sql = new MysqlDataSource();
		PreparedStatement prp;
		String qry = "select * from clientdata where username =?";
		ResultSet rs;
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
			
			//inject query into statement type object
			prp = conn.prepareStatement(qry);
			prp.setString(1, (String)session.getAttribute("uname"));
			
			//execute the query
			rs= prp.executeQuery();;
			String Username = null;
			String Password= null;
			String Name= null;
			String Contact= null;
			while (rs.next())
			{
				Username=rs.getString("Username");
				Password=rs.getString("Password");
				Name=rs.getString("Name");
				Contact=rs.getString("Contact");
			}
			
			request.setAttribute("Username", Username);
			request.setAttribute("Password", Password);
			request.setAttribute("Name", Name);
			request.setAttribute("Contact", Contact);
			
			/*	out.print("<html>");
				out.print("<body>"
						+ "<div align ='center' margin =10px style='margin-top:200px;'>"
						+ "<table align ='center' border =1px  style='font-size:40px;'> "
						+ "<tr>"
						+ "<td>Username</td>"
						+ "<td>Password</td>"
						+ "<td>Name</td>"
						+ "<td>Contact</td>"
						+ "</tr>");
				out.print("<tr>"
						+ "<td>");
				out.print(Username);
				out.print("</td>");
				out.print("<td>");
				out.print(Password);
				out.print("</td>");
				out.print("<td>");
				out.print(Name);
				out.print("</td>");
				out.print("<td>");
				out.print(Contact);
				out.print("</td>"
						+ "</table>"
						+ "</div>"
						+ "<br>"
						+ "<a href='http://localhost:8080/Signup-Signin_Feature/home.jsp'> <button style=' width: 200px;height: 70px;color: rgb(239, 94, 94);font-size: larger;position: absolute;left: 650px;'>Home</button></a>"
						+ "</body>"
						+ "</html>");
				
				out.print("</html>");
				
			*/
				
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
	             request.getRequestDispatcher("yourProfile.jsp");
		rd.forward(request, response);
	}

}
