package testServlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FlagsHandlerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
		String[] options;
		resp.setCharacterEncoding("UTF-8");
		options = req.getParameterValues("options");
		
		try (PrintWriter out = resp.getWriter()) {
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset='utf-8'");
			out.println("</head>");
			out.println("<body>");
			
			if (options != null) {
				out.println("<p>Вы выбрали:</p>");
				
				for (String option: options) {
					out.println("<p>" + option + "</p>");
				}
			} else {
				out.println("<p>Никаких опций выбрано не было.</p>");
			}
			
			out.println("</body>");
			out.println("</html>");
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
	}
}
