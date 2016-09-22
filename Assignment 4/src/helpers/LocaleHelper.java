package helpers;

import java.util.Enumeration;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.jstl.core.Config;

public class LocaleHelper {

	/**
	 * checks cookies or Accept-Language for preferred locale. Then sets locale
	 * in cookie and session
	 * 
	 * @param request
	 * @param response
	 */
	public static void setSessionLocale(HttpServletRequest request, HttpServletResponse response) {
		Cookie cookie = getCookie(request, "locale");

		HttpSession session = request.getSession();
		
		if (cookie != null) {
			Config.set(session, Config.FMT_LOCALE, cookie.getValue());
		} else {
			String locale = getLocaleFromHeader(request);
			Config.set(session, Config.FMT_LOCALE, locale);

			cookie = new Cookie("locale", locale);
			cookie.setMaxAge(60 * 60 * 24 * 365);
			response.addCookie(cookie);
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

	/**
	 * returns locale string based on Accept-Language and the application's
	 * supported locales
	 * 
	 * @param request
	 * @return
	 */
	public static String getLocaleFromHeader(HttpServletRequest request) {
		List<String> supportedLocales = (List<String>) request.getServletContext().getAttribute("supportedLocales");
		Enumeration prefLocales = request.getLocales();

		String defaultLocale = "en_US";

		// check for exact or partial match
		while (prefLocales.hasMoreElements()) {
			Locale loc = (Locale) prefLocales.nextElement();
			// check all supported locales for exact match
			for (String supportedLocale : supportedLocales) {
				if (loc.toString().equals(supportedLocale)) {
					return supportedLocale;
				}
			}
			// check all supported locales for partial match on language
			for (String supportedLocale : supportedLocales) {
				if (supportedLocale.contains(loc.getLanguage())) {
					return supportedLocale;
				}
			}

			// check all supported locales for partial match on country
			for (String supportedLocale : supportedLocales) {
				if (supportedLocale.contains(loc.getCountry())) {
					return supportedLocale;
				}
			}
		}

		return defaultLocale;
	}
}
