package schoolmate;

public class Teacher extends User{
	public Teacher() {
		tester.setTextField("username", "teacher");
		tester.setTextField("password", "test");
		tester.submit();
		
		//Check for successful login
		tester.assertMatch("Je Suis Le Professeur's Classes");
		
		tester.clickLinkWithText("Fortgeschrittene Mat");
		tester.assertMatch("Class Settings");
	}
}
