package helpers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.jstl.core.Config;

public class LocaleHelper {
	public static void setSessionLocale(HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			Cookie cookie = getCookie(request,"locale");
			if(cookie != null){
				HttpSession session = request.getSession();
				Config.set(session, Config.FMT_LOCALE, cookie.getValue());
			} else {
				cookie = new Cookie("locale", "en_US");
				cookie.setMaxAge(60*60*24*365);
				response.addCookie(cookie);
			}
		}
	}

	public static Cookie getCookie(HttpServletRequest request, String name) {
		if (request.getCookies() != null) {
			for (Cookie cookie : request.getCookies()) {
				if (cookie.getName().equals(name)) {
					return cookie;
				}
			}
		}

		return null;
	}
}
