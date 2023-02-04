package israt.FinalProject;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client/");

		//		driver.findElement(By.cssSelector("p.login-wrapper-footer-text")).click();
		//		
		//		driver.findElement(By.id("firstName")).sendKeys("Israt");
		//		driver.findElement(By.id("lastName")).sendKeys("Jahan");
		//		driver.findElement(By.id("userEmail")).sendKeys("toha992@gmail.com");
		//		driver.findElement(By.id("userMobile")).sendKeys("1971298080");
		//	    WebElement dropDown =	driver.findElement(By.className("custom-select"));
		//		Select selObj = new Select(dropDown);
		//		selObj.selectByValue("2: Student");
		//		driver.findElement(By.cssSelector("input[value='Female']")).click();
		//		driver.findElement(By.id("userPassword")).sendKeys("Konka84I");
		//		driver.findElement(By.id("confirmPassword")).sendKeys("Konka84I");
		//		driver.findElement(By.cssSelector("div.col-md-1")).click();
		//		driver.findElement(By.id("login")).click();
		//		
		//		driver.findElement(By.cssSelector(".btn.btn-primary")).click();

		driver.findElement(By.id("userEmail")).sendKeys("toha993@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Konka84I");
		driver.findElement(By.id("login")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("card-body")));

		String prodName = "ADIDAS ORIGINAL";

		List<WebElement> body = driver.findElements(By.className("card-body"));
		WebElement product = body.stream().filter(i ->i.findElement(By.tagName("h5")).getText().
				equals(prodName)).findFirst().orElse(null);

		product.findElement(By.cssSelector("button.btn.w-10.rounded")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));	

		//wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[routerlink*='cart']")));
		
		WebElement element =driver.findElement(By.cssSelector("[routerlink*='cart']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);

		
		List<WebElement> cart = driver.findElements(By.xpath("//div[@class='cart']/ul/li"));

		cart.stream().map(i ->i.findElement(By.tagName("h3"))).filter(i ->i.getText().equalsIgnoreCase(prodName)).
		forEach(i ->System.out.println(i.getText()));

		Boolean match = cart.stream().anyMatch(i ->i.findElement(By.tagName("h3")).getText().
				equalsIgnoreCase(prodName));
		
		Assert.assertTrue(match);
		
		driver.findElement(By.xpath("//button[text()='Checkout']")).click();
		
		driver.findElement(By.cssSelector("input[placeholder='Select Country']")).sendKeys("ban");
		   
	    //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
	    
	    List<WebElement> country = driver.findElements(By.cssSelector("section[class*='ta-results'] button span"));
	    
	    try {
	    	 country.stream().filter(i ->i.getText().equalsIgnoreCase("bangladesh")).forEach(i ->i.click());
	    }catch(Exception e) {
	    	e.getMessage();
	    	
	    }
	    
	    driver.findElement(By.cssSelector(".action__submit")).click();
	    
	    String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
	    System.out.println(confirmMessage);
	    Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	    
	    driver.close();
	    
	    

	}

}
