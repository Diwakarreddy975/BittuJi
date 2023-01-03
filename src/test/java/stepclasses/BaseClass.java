package stepclasses;

import POMpackage.POMSerExcCustomer_email;
import POMpackage.POMofLogInPage;
import POMpackage.POMofNewCustomer;
import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseClass {
  public    static WebDriver driver;
public Logger logger;

   public void browserSetUp(String browser){
       if (browser.equalsIgnoreCase("chrome")){
        WebDriverManager.chromedriver().setup();
                  driver=new ChromeDriver();
          }
        if (browser.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver=new FirefoxDriver();

        }

    }
    public void setURL(String url){
        driver.get(url);

    }
    public static String randomString(){
       String generetedstring1= RandomStringUtils.randomAlphabetic(5);
       return generetedstring1;
    }
    public static   void helpwaitTimer(WebElement ele, Duration timeoutinseco){
        WebDriverWait wait= new WebDriverWait(driver,timeoutinseco);
        wait.until(ExpectedConditions.visibilityOf(ele));
    }
    public static void JsClick(WebElement ele){
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click",ele);
    }


}
