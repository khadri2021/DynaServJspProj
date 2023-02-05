import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DynaServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		System.out.println("HI I'M JEELAN !!!!");
		try {
			ResultSet results = getResults();

			out.println("<html>");
			out.println("<body>");
			out.println("<table border=4>");
			out.println("<tr>");
			out.println("<th>");
			out.println("OPERATER NAME");
			out.println("</th>");
			out.println("<th>");
			out.println("IMEA NUMBER");
			out.println("</th>");
			out.println("</tr>");
			while (results.next()) {
				out.println("<tr>");
				out.println("<td>" + results.getString(1) + "</td>");
				out.println("<td>" + results.getString(2) + "</td>");
				out.println("</tr>");
			}
			out.println("</table>");
			out.println("</body>");
			out.println("</html>");
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			out.close();
		}

	}

	private ResultSet getResults() {
		ResultSet resultSet = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/2022batch", "root", "root");
			Statement st = conn.createStatement();
			resultSet = st.executeQuery("select * from phone");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultSet;
	}

}
