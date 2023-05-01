package israt.PageObjectModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import israt.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent{
	
	WebDriver driver;

	public CartPage(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}

	
	
	@FindBy(xpath = "//div[@class='cart']/ul/li")
	List<WebElement> cartProducts;
	
	@FindBy(xpath = "//button[text()='Checkout']")
	WebElement checkoutEle;
	
	public Boolean verifyProductDisplay(String productName) {
		
		Boolean match = cartProducts.stream().anyMatch(i ->i.findElement(By.tagName("h3")).getText().
				equalsIgnoreCase(productName));
		return match;
	}
	
	public CheckoutPage goToCheckout() {
		
		checkoutEle.click();
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		return checkoutPage;
	}
}
