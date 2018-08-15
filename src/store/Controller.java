package store;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.StoreItems;
import helpers.ShoppingCart;

/**
 * Servlet implementation class Controller
 */

public class Controller extends HttpServlet {
// Atributes:
	private static final long serialVersionUID = 1L;
	private String _supportMail;
	private int _hitCounter;
	private StoreItems _store;

	public Controller() {
		super();
	}

	public void init(ServletConfig config) {
		_store = new StoreItems();
		_supportMail = config.getInitParameter("email");
		System.out.println("from init");
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String command = req.getParameter("command");
		if (command.equals("startShopping")) {
			HttpSession session = req.getSession();
			if (session.isNew()) {
				ShoppingCart cart = new ShoppingCart();
				session.setAttribute("cart", cart);
			}
		}
	}

}// Controller
