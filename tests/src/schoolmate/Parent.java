package schoolmate;

public class Parent extends User{
	public Parent() {
		tester.setTextField("username", "parent");
		tester.setTextField("password", "test");
		tester.submit();
		
		//Check for successful login
		tester.assertMatch("Students of Ik ben de vader");
	}
}
