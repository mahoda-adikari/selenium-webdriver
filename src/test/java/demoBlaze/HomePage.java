package demoBlaze;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	//Locators
	@FindBy(xpath = "//select[@name='fromPort']") 
	WebElement dd_fromPort;
	@FindBy(xpath = "//select[@name='toPort']") 
	WebElement dd_toPort;
	@FindBy(xpath = "//input[@value='Find Flights']") 
	WebElement btn_findFlights;
	
	//Action Methods
	public void setFromPort(String fromPort) {
		selectFromDD(dd_fromPort, fromPort);
	}
	
	public void setToPort(String toPort) {
		 selectFromDD(dd_toPort, toPort);
	}
	
	public void clickFindFlights() {
		clickElement(btn_findFlights);
	}
	
}
