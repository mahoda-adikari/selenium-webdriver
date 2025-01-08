package day43;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HardVsSoftAssertions {
	
	@Test
	void testHardAssertion() {
		System.out.println("testing 1...");
		System.out.println("testing 2...");
		
		Assert.assertEquals(1, 2);
		
		System.out.println("testing 3...");
		System.out.println("testing 4...\n");
	}
	
	@Test
	void testSoftAssertion() {
		System.out.println("testing 1...");
		System.out.println("testing 2...");
		
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(1, 2);
		
		System.out.println("testing 3...");
		System.out.println("testing 4...");

		sa.assertAll();
	}

}
