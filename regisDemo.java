import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class regisDemo extends HttpServlet {
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                String s1 = request.getParameter("u1");
		String s2 = request.getParameter("u2");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql:///sonali?useSSL=false","root","root");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from login where UNAME='"+s1+"' AND UPASS='"+s2+"'");
			if(rs.next())
			{
                            
                            
                            HttpSession session = request.getSession();
                            session.setAttribute("uname",s1);
                           /*
                            Cookie ck = new Cookie("u1",s1);
                            ck.setMaxAge(30*60);
                            response.addCookie(ck);
                             */
		     	   response.sendRedirect("menuDemo");
			}
			else
		{
		         out.println("<h1><center><p style='color:red;'>invalid username and password....</p></center></h1>");
                         RequestDispatcher dis = request.getRequestDispatcher("login.html");
                         dis.include(request,response);
                 }
			con.close();
		}
		catch(Exception e1)
		{
			out.println(e1);
		}
		out.println("</body>");
		out.println("</html>");
		out.close();
    }

}