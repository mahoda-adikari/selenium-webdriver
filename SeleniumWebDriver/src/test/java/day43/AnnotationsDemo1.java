package day43;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AnnotationsDemo1 {
	
	@BeforeMethod
	void login() {
		System.out.println("Logging in...");
	}

	@AfterMethod
	void logout() {
		System.out.println("Logging out..");
	}
	
	@Test(priority = 1)
	void search() {
		System.out.println("Normal Search");
	}
	
	@Test(priority = 2)
	void advSearch() {
		System.out.println("Advanced Search");
	}

}
