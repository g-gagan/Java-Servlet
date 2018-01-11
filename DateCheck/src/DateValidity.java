

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Servlet implementation class DateValidity
 */
@WebServlet("/DateValidity")
public class DateValidity extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		String date = request.getParameter("dd");
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		sdf.setLenient(false);
		
		PrintWriter out = response.getWriter();
		
		boolean valid = true;
		
		try {
			Date testDate = sdf.parse(date);
			//System.out.println(testDate);
		}
		catch(ParseException e)
		{
			valid = false;			
		}
		
		if(valid == true)
		{
			out.println("<h1>" + "Valid Date" + "</h1>");
		}
		else
		{
			out.println("<h1>" + "Invalid Date" + "</h1>");
		}

		out.println("<br> <a href='" + getServletContext().getContextPath() + "/index.html'>Check another date</a>");
	}

}
