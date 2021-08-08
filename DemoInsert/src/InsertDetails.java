
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsertDetails
 */
@WebServlet("/InsertDetails")
public class InsertDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		try {
			Connection con=DBUtil.getConnection();
			String sql="insert into student values(?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,name);
			ps.setString(2, email);
			int i=ps.executeUpdate();
			if(i>0) {
				RequestDispatcher rd=request.getRequestDispatcher("insert.html");
				rd.forward(request, response);}
			else {
				RequestDispatcher rd=request.getRequestDispatcher("noinsert.html");
				rd.forward(request, response);
			}} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}}
