import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class loginDemo extends HttpServlet {
   @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String s1 = request.getParameter("un");
	String s2 = request.getParameter("up");
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql:///sonali?useSSL=false","root","root");
			Statement st = con.createStatement();
			st.executeUpdate("insert into login(UNAME,UPASS) values('"+s1+"','"+s2+"')");
			response.sendRedirect("login.html");
			con.close();
		}
		catch(Exception e1)
		{
			System.out.println(e1);
		}
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>coming soon.....</h1>");
		out.println("</body>");
		out.println("</html>");
		out.close();
    }

}