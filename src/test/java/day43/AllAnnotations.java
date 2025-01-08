package day43;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AllAnnotations {
	
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
	
	@BeforeClass
	void bc() {
		System.out.println("beforeClass");
	}
	
	@AfterClass
	void ac() {
		System.out.println("afterClass");
	}
	
	@BeforeMethod
	void bm() {
		System.out.println("beforeMethod");
	}

	@AfterMethod
	void am() {
		System.out.println("afterMethod");
	}
	
	@Test(priority = 1)
	void search() {
		int a = 1;
		int b =2;
		Assert.assertEquals(a, b);
		System.out.println("Normal Search");
	}
	
	@Test(priority = 2)
	void advSearch() {
		System.out.println("Advanced Search");
	}

}
