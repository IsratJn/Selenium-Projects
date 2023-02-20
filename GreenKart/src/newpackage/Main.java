package newpackage;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","H:/SEL Materials/ChromeDriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		String searchProds[] = {"Carrot", "Beans", "Capsicum" };
		List<String> prodList= Arrays.asList(searchProds);
		
		List<WebElement> products = driver.findElements(By.xpath("//h4[@class='product-name']"));
		
		int i;
		for(i=0;i<products.size();i++) {
			
			String name = products.get(i).getText();
			String formattedName[] =name.split(" ");
			name = formattedName[0];
			
			if(prodList.contains(name)) {
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
			}
			
		}
	}

}

