package day47;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	WebDriver driver;
	
	//Constructor
	LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Locators
	By txt_uNameLoc = By.xpath("//input[@placeholder='Username']");
	By txt_pwdLoc = By.xpath("//input[@placeholder='Password']");
	By btn_loginLoc = By.xpath("//button[normalize-space()='Login']");
	
	//Action Methods
	public void setUserName(String uName) {
		driver.findElement(txt_uNameLoc).sendKeys(uName);
	}
	
	public void setPassword(String pwd) {
		driver.findElement(txt_pwdLoc).sendKeys(pwd);
	}
	
	public void clickLogin() {
		driver.findElement(btn_loginLoc).click();
	}
}
