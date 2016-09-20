package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import helpers.LocaleHelper;

/**
 * Servlet implementation class LocaleServlet
 */
@WebServlet("/newLocale")
public class LocaleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LocaleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String locale = request.getParameter("locale");
		if(locale != null){
			
			Cookie cok = LocaleHelper.getCookie(request, "locale");
			Cookie cookie = new Cookie("locale", locale);
			cookie.setMaxAge(60*60*24*365);
			response.addCookie(cookie);
		}
		String referer = request.getHeader("referer");
		response.sendRedirect(referer);
	}

}
