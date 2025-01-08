package day44;

import org.testng.annotations.Test;

public class PaymentTests {
	
	@Test(priority = 1, groups = {"sanity", "regression", "functional"})
	void paymentInRupees() {
		System.out.println("Payment in Rupees...");
	}
	
	@Test(priority = 1, groups = {"sanity", "regression", "functional"})
	void paymentInDollars() {
		System.out.println("Payment in Dollars...");
	}

}
