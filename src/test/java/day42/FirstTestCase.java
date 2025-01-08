package day42;

import org.testng.annotations.Test;

public class FirstTestCase {
	
	@Test(priority = 1)
	void openApp() {
		System.out.println("\nOpening Application.....");
	}
	
	@Test(priority = 2)
	void login() {
		System.out.println("Logging in.....");
	}
	
	@Test(priority = 3)
	void logout() {
		System.out.println("Logging Out.....\n");
	}

}
