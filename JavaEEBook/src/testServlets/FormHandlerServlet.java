package testServlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormHandlerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
		String enteredValue;
		enteredValue = req.getParameter("enteredValue");
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		
		try (PrintWriter out = resp.getWriter()) {
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset='utf-8'");
			out.println("</head>");
			out.println("<body>");
			out.println("<p>");
			out.print("Вы ввели: ");
			out.print(enteredValue);
			out.print("</p>");
			out.println("</body>");
			out.println("</html>");
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
	}
}
