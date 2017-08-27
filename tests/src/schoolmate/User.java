package schoolmate;

import org.xml.sax.helpers.AttributesImpl;

import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.InputElementFactory;

import net.sourceforge.jwebunit.api.IElement;
import net.sourceforge.jwebunit.htmlunit.HtmlUnitElementImpl;
import net.sourceforge.jwebunit.junit.WebTester;

public class User {
	public WebTester tester;
	
	public User() {
		tester = new WebTester();
		tester.setBaseUrl("http://192.168.56.102/schoolmate/"); //Fixed version
		//tester.setBaseUrl("http://192.168.56.102/origSchoolmate/"); //Vulnerable version
		
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
	
	public void genericTestPage(String page, String page2, String pageName) {
		tester.setTextField("page2", page2);
		tester.setTextField("page", page+" '><a href=\"http://unitn.it\">XSS on page</a><br'");
		
		tester.submit();
		
		tester.assertMatch(pageName);
		tester.assertLinkNotPresentWithText("XSS on page");
	}
	
	public void genericTestPage2(String page2, String pageName) {
		tester.setTextField("page2", page2+" '> <a href=\"www.unitn.it\">XSS on page2</a> <br '");
		tester.submit();
		
		tester.assertMatch(pageName);
		tester.assertLinkNotPresentWithText("XSS on page2");
	}
	
	//injecting the selectclass variable tends to break the page so, for the sake of generality, no assertmatch is used
	public void genericTestSelectclass(String selectclass, String page2, String pageName) {
		tester.setTextField("page2", page2);
		tester.setTextField("selectclass", selectclass+" -- '><a href=\"http://unitn.it\">XSS on selectclass</a><br'");
		
		tester.submit();
		
		tester.assertMatch(pageName);
		tester.assertLinkNotPresentWithText("XSS on selectclass");
	}
	
	//injecting the delete variable breaks the page so, for the sake of generality, no assertmatch is used
	//all tests on delete assume you click on "edit" and that the value of the delete[] variable is 1, so the method takes no params
	public void genericTestDelete() {
		tester.checkCheckbox("delete[]");
		tester.setTextField("delete[]", "1 --) '><a href=\"http://unitn.it\">XSS on delete</a><br'");
		
		tester.clickButtonWithText("Edit");
		
		tester.assertLinkNotPresentWithText("XSS on delete");
	}
}
