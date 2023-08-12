package com.feature;

import java.io.IOException;
import java.io.PrintWriter;
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
		
		
		response.getWriter();		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		//open the database connection
		HttpSession session = request.getSession();
		Connection conn;
		MysqlDataSource sql = new MysqlDataSource();
		PreparedStatement prp;
		String qry = "select * from clientdata where Username =?";
		ResultSet rs;
		
		try {
			//enter the database credentials
			sql.setUser("root");
			sql.setPassword("abcd");
			sql.setDatabaseName("java_crs_db");
			sql.setServerName("localhost");
			sql.setPort(3306);
			
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
				
				out.print("<html>");
				out.print("<body>"
						+ "<div align ='center' margin =10px vertical = 400px>"
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
						+ "</body>"
						+ "</html>");
				
				out.print("</html>");
				
			
				
			conn.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
