package helpers;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;  
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener{
	@Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
		ServletContext application = servletContextEvent.getServletContext();
		List<String> supportedLocales = new ArrayList<String>();
		supportedLocales.add("no_NO");
		supportedLocales.add("de_DE");
		supportedLocales.add("en_US");
		application.setAttribute("supportedLocales", supportedLocales);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
      
    }
}
