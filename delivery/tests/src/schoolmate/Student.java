package schoolmate;

public class Student extends User{
	public Student() {
		tester.setTextField("username", "student");
		tester.setTextField("password", "test");
		tester.submit();
		
		//Check for successful login
		tester.assertMatch("Soy El Estudiante's Classes");
		
		tester.clickLinkWithText("Fortgeschrittene Mat");
		tester.assertMatch("Class Settings");
	}
}
