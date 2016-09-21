package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import helpers.DAO;
import helpers.LocaleHelper;
import model.Cart;
import model.Product;

/**
 * Servlet implementation class ProductsServlet
 */
@WebServlet("/products")
public class ProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductsServlet() {
		super();
		dao = new DAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LocaleHelper.setSessionLocale(request, response);
		request.setAttribute("products", dao.getProducts());
		request.getRequestDispatcher("WEB-INF/products.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String productNumber = request.getParameter("productNumber");

		 if(productNumber == null){
		 response.sendRedirect("products");
		 }

		Product product = dao.getProduct(Integer.parseInt(productNumber));

		 if(product == null){
		 response.sendRedirect("products");
		 }

		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");

		if (cart == null) {
			Cart newCart = new Cart();
			newCart.addProduct(product);
			session.setAttribute("cart", newCart);
		} else {
			cart.addProduct(product);
		}
		
		
		response.sendRedirect("products");
	}

}
