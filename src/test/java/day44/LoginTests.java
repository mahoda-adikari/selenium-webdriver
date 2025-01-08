package day44;

import org.testng.annotations.Test;

public class LoginTests {
	
	@Test(priority = 1, groups = {"sanity"})
	void loginByEmail() {
		System.out.println("Login by Email...");
	}
	
	@Test(priority = 2, groups = {"sanity"})
	void loginByFacebook() {
		System.out.println("Login by Facebook...");
	}
	
	@Test(priority = 3, groups = {"sanity"})
	void loginByTwitter() {
		System.out.println("Login by Twitter...");
	}

}
