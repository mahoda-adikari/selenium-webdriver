package demoBlaze;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BasePage {
    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickElement(WebElement element){
        element.click();
    }

    public void selectFromDD(WebElement dropDown, String value){
        Select selectDD = new Select(dropDown);
        selectDD.selectByValue(value);
    }
}
