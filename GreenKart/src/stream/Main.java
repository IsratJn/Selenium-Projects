package stream;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Main {
		
	public static void main(String[] args) throws InterruptedException {
		
		
		
		System.setProperty("webdriver.chrome.driver","H:/SEL Materials/ChromeDriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");		
		driver.findElement(By.xpath("//a[text() = 'Top Deals']")).click();
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parent = it.next();
		String child = it.next();
		
		driver.switchTo().window(child);
		
	   driver.findElement(By.xpath("//tr/th[1]")).click();
	   
	   List<WebElement> veggiesList = driver.findElements(By.xpath("//tbody/tr/td[1]"));
	   
	   List<String> originalList = veggiesList.stream().map(s -> s.getText()).sorted().collect(Collectors.toList());
	   
	   originalList.stream().forEach(s -> System.out.println(s));
	   
//	   List<String> price = veggiesList.stream().filter(s -> s.getText().contains("Apple")).map(s ->s.getPrice()).
//	   collect(Collectors.toList());

//	   List<String> originalList = veggiesList.stream().map(s -> s.getText()).collect(Collectors.toList());
//	   
//	   List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
//	   
//	   Assert.assertFalse(originalList.equals(sortedList));
//	   

 
 
List<String> price;
do {
	 List<WebElement> rows = driver.findElements(By.xpath("//tbody/tr/td[1]"));
	 price = rows.stream().filter(i ->i.getText().
			   contains("Wheat")).map(i ->getPrice(i)).collect(Collectors.toList());
	 price.stream().forEach(s -> System.out.println(s));
	 driver.findElement(By.cssSelector("[aria-label='Next']")).click();

 }while(price.size()<1);
 
//	   

	   
//	   for(int i =0; i<veggiesList.size();i++) {
//		   
//		   System.out.println(veggiesList.get(i).getText());
////		   String name = veggiesList.get(i).getText();
////		   if( name.equalsIgnoreCase("Wheat") ) {
////			   System.out.println(name + " price:");
////			   System.out.println(veggiesList.get(i).findElement(By.xpath("following-sibling::td[1]")).getText());
////		   }
//		
//	   }
	 
	   
	 
	   
	   
	   
	   
	   
	   
	}
	private static String getPrice(WebElement i) {
	 System.out.println("Price");	
	 String price =	i.findElement(By.xpath("following-sibling::td[1]")).getText();
	 return price;
		// TODO Auto-generated method stub
		
	}
	
	

}
