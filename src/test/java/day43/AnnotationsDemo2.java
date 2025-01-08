package day43;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AnnotationsDemo2 {
	
	@BeforeClass
	void login() {
		System.out.println("Logging in...");
	}
	
	@AfterClass
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
