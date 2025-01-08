package day43.package1;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BaseClass {
	
	@BeforeSuite
	void bs() {
		System.out.println("bs method");
	}
	
	@AfterSuite
	void as() {
		System.out.println("as method");
	}
	
	@BeforeTest
	void bt() {
		System.out.println("bt Method");
	}
	
	
	@AfterTest
	void at() {
		System.out.println("at Method");
	}


}
