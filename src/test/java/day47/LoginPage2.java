package day47;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage2 {
	
	WebDriver driver;
	
	//Constructor
//	LoginPage2(WebDriver driver) {
//		this.driver = driver;
//	}
	
	//Constructor
	LoginPage2(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Locators
//	By txt_uNameLoc = By.xpath("//input[@placeholder='Username']");
//	By txt_pwdLoc = By.xpath("//input[@placeholder='Password']");
//	By btn_loginLoc = By.xpath("//button[normalize-space()='Login']");
	
	//Locators
//	@FindBy(xpath = "//input[@placeholder='Username']") 
	@FindBy(how = How.XPATH, using = "//input[@placeholder='Username']")
	WebElement txt_uName;
	
	@FindBy(xpath = "//input[@placeholder='Password']") 
	WebElement txt_pwd;
	
	@FindBy(xpath = "//button[normalize-space()='Login']") 
	WebElement btn_login;
		
	//Action Methods
//	public void setUserName(String uName) {
//		driver.findElement(txt_uNameLoc).sendKeys(uName);
//	}
//	
//	public void setPassword(String pwd) {
//		driver.findElement(txt_pwdLoc).sendKeys(pwd);
//	}
//	
//	public void clickLogin() {
//		driver.findElement(btn_loginLoc).click();
//	}
	
	//Action Methods
	public void setUserName(String uName) {
		txt_uName.sendKeys(uName);
	}
	
	public void setPassword(String pwd) {
		txt_pwd.sendKeys(pwd);
	}
	
	public void clickLogin() {
		btn_login.click();
	}
}
