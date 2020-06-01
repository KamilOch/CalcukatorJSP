package atj;

import java.io.IOException;

//import javax.script.ScriptException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/CalcServlet")
public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CalcServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String base = "/";
		String url = base + "calc.jsp";
		HttpSession session = request.getSession();
//		Calc obiekt = (Calc) session.getAttribute("obiekt");
		CalcK obiekt = (CalcK) session.getAttribute("obiekt");
		if (obiekt == null) {
//			obiekt = new Calc();
			obiekt = new CalcK();
			session.setAttribute("obiekt", obiekt);
		}

		if (request.getParameterMap().containsKey("btn")) {
			String s = request.getParameter("btn");			
		
//			try {
				obiekt.caclulate(s);
//			} catch (ScriptException e) {
//				e.printStackTrace();
//			}
		
			
		}

//		String action = request.getParameter("action");
//		if (action != null) {
//			switch (action) {
//			case "properties":
//				url = base + "properties.jsp";
//				break;
//			default:
//				break;
//			}
//		}

		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(url);
		requestDispatcher.forward(request, response);
	}
}
