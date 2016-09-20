package helpers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.jstl.core.Config;

public class LocaleHelper {
	public static void setSessionLocale(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("locale")) {
					HttpSession session = request.getSession();
					Config.set(session, Config.FMT_LOCALE, cookie.getValue());
				}
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
