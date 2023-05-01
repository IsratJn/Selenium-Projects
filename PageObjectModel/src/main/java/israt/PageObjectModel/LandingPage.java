package israt.PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import israt.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent{
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}	
	
	@FindBy(id = "userEmail")
	WebElement userEmail;
	 
	@FindBy(id = "userPassword")
	WebElement userPassword;
	
	@FindBy(id = "login")
	WebElement login;


	public ProductCatalogue loginApplication(String email, String pass) {
		// TODO Auto-generated method stub
		userEmail.sendKeys(email);
		userPassword.sendKeys(pass);
		login.click();
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		return productCatalogue;
		
	}
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client/");
	}


}
