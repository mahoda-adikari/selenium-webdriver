package demoBlaze;

import org.testng.annotations.Test;

public class FlightSearchTest extends BaseTest{

	@Test
	public void testFindFlight() {
		
		HomePage homePage = new HomePage(getDriver());
		homePage.setFromPort("Paris");
		homePage.setToPort("Rome");
		homePage.clickFindFlights();
		
		FlightsPage flightsPage = new FlightsPage(getDriver());
		if (flightsPage.isFlightDataDisplayed()) {
			flightsPage.clickCheapestFlight();
		}
	}
}
