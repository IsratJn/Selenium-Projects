package israt.PageObjectModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import israt.AbstractComponents.AbstractComponent;

public class CheckoutPage extends AbstractComponent {
	
	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css= "input[placeholder='Select Country']")
	WebElement country;
	
	@FindBy(css = "section[class*='ta-results'] button span")
	List<WebElement> countryOptions;
	
	@FindBy(css = ".action__submit")
	WebElement submit;
	
	By results = By.cssSelector(".ta-results");
	
	public void selectCountry(String countryName) {
		
		country.sendKeys(countryName);
		waitForElementToAppear(results);
		
		try {
	    	 countryOptions.stream().filter(i ->i.getText().equalsIgnoreCase("bangladesh")).forEach(i ->i.click());
	    }catch(Exception e) {
	    	e.getMessage();
	    	
	    }
		
		
	}
	
	public ConfirmationPage submitOrder() {
		submit.click();
		ConfirmationPage confirmationPage =  new ConfirmationPage(driver);
		return confirmationPage;
	}
	
	
	
	

}
