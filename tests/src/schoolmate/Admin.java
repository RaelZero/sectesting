package schoolmate;

public class Admin extends User {
	public Admin() {
		tester.setTextField("username", "test");
		tester.setTextField("password", "test");
		tester.submit();
		
		//Check for successful login
		tester.assertMatch("Manage Classes");
	}
}
