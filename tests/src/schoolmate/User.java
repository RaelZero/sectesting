package schoolmate;

import net.sourceforge.jwebunit.api.*;
import net.sourceforge.jwebunit.htmlunit.*;
import net.sourceforge.jwebunit.junit.*;
import com.gargoylesoftware.htmlunit.html.*;

import org.junit.Test;
import org.xml.sax.helpers.AttributesImpl;

public class User {
	public WebTester tester;
	
	public User() {
		tester = new WebTester();
		//tester.setBaseUrl("http://192.168.56.102/schoolmate/"); //Fixed version
		tester.setBaseUrl("http://192.168.56.102/origSchoolmate/"); //Vulnerable version
		
		tester.beginAt("index.php");
	}
	
	public void addSubmitButton(String xpath) {
		IElement element = tester.getElementByXPath(xpath);
		DomElement form = ((HtmlUnitElementImpl)element).getHtmlElement();
		InputElementFactory factory = InputElementFactory.instance;
		
		AttributesImpl attributes = new AttributesImpl();
		attributes.addAttribute("", "", "type", "", "submit");
		HtmlElement submit = factory.createElement(form.getPage(), "input", attributes);
		form.appendChild(submit);
	}
	
	public void genericTestPage(String page, String page2) {
		tester.setTextField("page2", page2);
		tester.setTextField("page", page+" '><a href=\"http://unitn.it\">XSS on page</a><br'");
		
		tester.submit();
		
		tester.assertLinkNotPresentWithText("XSS on page");
	}
	
	public void genericTestPage2(String page2) {
		tester.setTextField("page2", page2+"'> <a href=\"www.unitn.it\">XSS on page2</a> <br '");
		tester.submit();
		
		tester.assertLinkNotPresentWithText("XSS on page2");
	}
	
	public void genericTestSelectclass(String selectclass, String page2) {
		tester.setTextField("page2", page2);
		tester.setTextField("selectclass", selectclass+"'><a href=\"http://unitn.it\">XSS on selectclass</a><br'");
		
		tester.submit();
		
		tester.assertLinkNotPresentWithText("XSS on selectclass");
	}
}
