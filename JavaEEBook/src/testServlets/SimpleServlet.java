package testServlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SimpleServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		try (PrintWriter out = resp.getWriter()) {
			resp.setContentType("text/html");
			resp.setCharacterEncoding("UTF-8");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset='utf-8'");
			out.println("</head>");
			out.println("<body>");
			out.println("<h2>");
			out.println("Если вы читаете это, значит сервлет работает зашибись.");
			out.println("</h2>");
			out.println("</body>");
			out.println("</html>");
			out.close();
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
	}
}
