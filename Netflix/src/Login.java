import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {

	//Global Variables
    WebDriver driver;
    String baseUrl;

    //UI Variables
    String LOGIN_BTN = "//a[@href='/login']"; //Login Button Xpath
    String NETFLIX_LOGO = "Fill-14";
    String SIGN_IN_TEXT = "//h1[text()='Sign In']";
    String EMAIL_FIELD = "id_userLoginId"; //ID of Email Field
    String PASSWORD_FIELD = "id_password"; //ID of Password Field
    String SIGN_IN_BUTTON = "//button[text()='Sign In']"; //Xpath of sign in button
    String LOGIN_FAILED_TEXT = "//div[@class='ui-message-contents']"; //Xpath of unsuccessful text
    String LOGIN_SUCCESSFUL_TEXT = "//span[@class='our-story-welcome-back']"; //Xpath of successful text
    String INPUT_FIELD_ERROR = "div.inputError"; //CSS of input error text

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        baseUrl = "https://www.netflix.com/";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @Test(priority = 1)
    public void validateField() throws InterruptedException {


        System.out.println("Successfully loaded the website");

        
        WebElement netflixText = driver.findElement(By.id(NETFLIX_LOGO));
        Assert.assertTrue(netflixText.isDisplayed());
        System.out.println("Verified Page");

        
        WebElement loginBtn = driver.findElement(By.xpath(LOGIN_BTN));
        loginBtn.click();
        System.out.println("Clicked on Login Button");

        
        System.out.println("Navigating to Sign in page");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        
        WebElement signInText = driver.findElement(By.xpath(SIGN_IN_TEXT));
        Assert.assertTrue(signInText.isDisplayed());
        System.out.println("Sign in Page Verified");

        

        WebElement emailField = driver.findElement(By.id(EMAIL_FIELD));
        emailField.clear();
        emailField.sendKeys("88");
        Thread.sleep(2000);
        emailField.clear();
        Thread.sleep(2000);
        emailField.sendKeys("abc");

        
        WebElement inputError = driver.findElement(By.cssSelector(INPUT_FIELD_ERROR));

        if (inputError.isDisplayed()) {
            System.out.println("Value not acceptable");
        }

    }


    //Unsuccessful login test case
    @Test(priority = 2)
    public void loginFailTest() {
        System.out.println("Successfully loaded the website");

        WebElement netflixText = driver.findElement(By.id(NETFLIX_LOGO));
        Assert.assertTrue(netflixText.isDisplayed());
        System.out.println("Verified Page");

    
        WebElement loginBtn = driver.findElement(By.xpath(LOGIN_BTN));
        loginBtn.click();
        System.out.println("Clicked on Login Button");

      
        System.out.println("Navigating to Sign in page");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


      
        WebElement signInText = driver.findElement(By.xpath(SIGN_IN_TEXT));
        Assert.assertTrue(signInText.isDisplayed());
        System.out.println("Sign in Page Verified");


        
        WebElement emailField = driver.findElement(By.id(EMAIL_FIELD));
        emailField.clear();
        emailField.sendKeys("abc123@gmail.com");


        WebElement passField = driver.findElement(By.id(PASSWORD_FIELD));
        passField.clear();
        passField.sendKeys("anyRandomNumber");

        WebElement signInButton = driver.findElement(By.xpath(SIGN_IN_BUTTON));
        signInButton.click();
        System.out.println("Clicked Sign in Button");

  
        WebElement loginUIText = driver.findElement(By.xpath(LOGIN_FAILED_TEXT));
        if(loginUIText.isDisplayed()) {
            System.out.println("Please insert correct credentials");
        }

    }

   
    @Test(priority = 3)
    public void loginSuccessTest() {
        System.out.println("Successfully loaded the website");

        
        WebElement netflixText = driver.findElement(By.id(NETFLIX_LOGO));
        Assert.assertTrue(netflixText.isDisplayed());
        System.out.println("Verified Page");

       
        WebElement loginBtn = driver.findElement(By.xpath(LOGIN_BTN));
        loginBtn.click();
        System.out.println("Clicked on Login Button");

       
        System.out.println("Navigating to Sign in page");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


      
        WebElement signInText = driver.findElement(By.xpath(SIGN_IN_TEXT));
        Assert.assertTrue(signInText.isDisplayed());
        System.out.println("Sign in Page Verified");


        
        WebElement emailField = driver.findElement(By.id(EMAIL_FIELD));
        emailField.clear();
        emailField.sendKeys("Hurvai7@gmail.com");

     

        WebElement passField = driver.findElement(By.id(PASSWORD_FIELD));
        passField.clear();
        passField.sendKeys("Hello123.");

        WebElement signInButton = driver.findElement(By.xpath(SIGN_IN_BUTTON));
        signInButton.click();
        System.out.println("Clicked Sign in Button");

        WebElement loginUIText = driver.findElement(By.xpath(LOGIN_SUCCESSFUL_TEXT));
        boolean flag = loginUIText.isDisplayed();
        Assert.assertTrue(flag);
        if(flag) {
            System.out.println("Hooray! You've logged in successfully");
        }

    }


    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();

    }

}
