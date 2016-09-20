package helpers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.jstl.core.Config;

public class LocaleHelper {
	public static void setSessionLocale(HttpServletRequest request){
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie : cookies){
			if(cookie.getName().equals("locale")){
				HttpSession session = request.getSession();
				Config.set(session, Config.FMT_LOCALE, new java.util.Locale(cookie.getValue()));
			}
		}
	}
}
