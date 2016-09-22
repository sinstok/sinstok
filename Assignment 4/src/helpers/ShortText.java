package helpers;

import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.*; 

public class ShortText extends SimpleTagSupport {
	
	private int maxChars;
	
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		
		StringWriter stringWriter = new StringWriter();
        JspFragment body = getJspBody();
        body.invoke(stringWriter);
        String bodyText = stringWriter.getBuffer().toString();
        
        String shortText = bodyText.substring(0,maxChars) + "...";
        
        out.print(shortText);
	}
	
	public void setMaxchars(int maxChars){
		this.maxChars = maxChars;
	}
}
