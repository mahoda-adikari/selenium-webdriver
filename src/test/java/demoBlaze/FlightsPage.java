package demoBlaze;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FlightsPage extends BasePage {
	
	public FlightsPage(WebDriver driver) {
		super(driver);
	}
	
	//Locators
	@FindBy(xpath = "//tbody/tr[*]")
	List<WebElement> flightsTableRows;
	
	//Action Methods
	public boolean isFlightDataDisplayed() {
		return (flightsTableRows.size() > 0);
	}
	
	public WebElement getCheapestFlightButton() {
		WebElement cheapestFlightButton = null;
		double minPrice = Double.MAX_VALUE;
		
		for (WebElement row : flightsTableRows) {
			List<WebElement> cells = row.findElements(By.xpath("./td"));
			if (cells.size() > 0) {
				String priceText = cells.getLast().getText().replace("$", "").trim();
				double price = Double.parseDouble(priceText);
				if (price < minPrice) {
					minPrice = price;
					cheapestFlightButton = row.findElement(By.xpath("./td[1]/input[1]"));
				}
			}
		}
		System.out.println("Min Price : "+ minPrice);
		return cheapestFlightButton;
	}
	
	public void clickCheapestFlight() {
		clickElement(getCheapestFlightButton());
	}
}
