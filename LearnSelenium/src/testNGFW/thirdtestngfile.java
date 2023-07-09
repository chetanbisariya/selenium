package testNGFW;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.Reporter;

@Test 
public class thirdtestngfile {
    public String baseUrl = "http://demo.guru99.com/test/newtours/";
    String driverPath = "C:\\geckodriver.exe";
    public WebDriver driver; 
    public String expected = null;
    public String actual = null;
        
    @BeforeTest
      public void launchBrowser() {
          System.out.println("launching firefox browser"); 
          System.setProperty("webdriver.gecko.driver", driverPath);
          driver= new FirefoxDriver();
          driver.get(baseUrl);
          Reporter.log("Opening the browser");
      }
      
      @BeforeMethod
      public void verifyHomepageTitle() {
          String expectedTitle = "Welcome: Mercury Tours";
          String actualTitle = driver.getTitle();
          Assert.assertEquals(actualTitle, expectedTitle);
          Reporter.log("Verifying Home Page");
      }
      
        @Test(priority = 0)
      public void register(){
          driver.findElement(By.linkText("REGISTER")).click() ;
          expected = "Register: Mercury Tours";
          actual = driver.getTitle();
          Assert.assertEquals(actual, expected);
      }
          @Test(priority = 1)
      public void support() {
            driver.findElement(By.linkText("SUPPORT")).click() ;
            expected = "Under Construction: Mercury Tours";
            actual = driver.getTitle();
            Assert.assertEquals(actual, expected);
      }
      @AfterMethod
      public void goBackToHomepage ( ) {
            driver.findElement(By.linkText("Home")).click() ;
      }
       
      @AfterTest
      public void terminateBrowser(){
          driver.close();
      }
}