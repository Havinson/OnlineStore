package store;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	public LoginServlet() {

	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie cookie = new Cookie("lastVisit", "this is the first visit");
		// get cookies from request
		Cookie[] cookies = req.getCookies();
		if (cookies != null && cookies.length > 0) {
			for (Cookie curr : cookies) {
				if (curr.getName().equals(cookie.getName())) {
					cookie = curr;
				}
			}
		}
		// Add an updated visit cookie with current date to the resp
		resp.setContentType("text/html");// Good practice to write it!
		PrintWriter out = resp.getWriter();
		String userName = req.getParameter("userName");

		if (req.getParameter("userName") != null && req.getParameter("userName").length() > 0) {
			req.setAttribute("userName", req.getParameter("userName"));
		} else {
			req.setAttribute("userName", "Guest");
		}
		out.println("<html><body>");
		out.println("<p><h1>Welcome to Online Store</h1></p>");
		out.println("<hr />");
		out.println("<h2>" + "Hello: " + req.getAttribute("userName") + " !</h>");
		out.println("<h4>Last Visit: " + cookie.getValue() + "</h4>");
		out.println("</body></html>");
		String val = new Date().toString();
		val = val.replace(" ", "_");
		cookie.setValue(val);
		cookie.setMaxAge(60 * 60 * 24 * 7);
		resp.addCookie(cookie);
	}

}// LoginServlet
