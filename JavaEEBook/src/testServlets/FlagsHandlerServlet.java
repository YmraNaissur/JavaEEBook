package testServlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FlagsHandlerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
		String[] options = req.getParameterValues("options");
		
		List<String> selectedOptionLabels = null;
		
		if (options != null) {
			selectedOptionLabels = new ArrayList<String>(options.length);
			for (String option: options) {
				switch (option) {
					case "option1":
						selectedOptionLabels.add("Опция 1");
						break;
					case "option2":
						selectedOptionLabels.add("Опция 2");
						break;
					case "option3":
						selectedOptionLabels.add("Опция 3");
						break;
				}
			}
		}
		
		// Add checked labels list to the request attributes
		req.setAttribute("checkedLabels", selectedOptionLabels);
		System.out.println("Request is being forwarded...");
		
		try {
			// Forward request to another servlet (testServlets.ConfirmationServlet)
			req.getRequestDispatcher("/confirmationservlet").forward(req, resp);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
}
