package testServlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This servlet displays data, processed and forwarded
 * from the testServlets.FlagsHandlerServlet
 * @author Naissur
 */
public class ConfirmationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
		@SuppressWarnings("unchecked")
		List<String> selectedLabels = (List<String>) req.getAttribute("checkedLabels");
		resp.setCharacterEncoding("UTF-8");
		
		try (PrintWriter out = resp.getWriter()) {
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset='utf-8'");
			out.println("</head>");
			out.println("<body>");
			
			if (selectedLabels != null) {
				out.println("<p>Вы выбрали:</p>");
				for (String label: selectedLabels) {
					out.println("<p>" + label + "</p>");
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
