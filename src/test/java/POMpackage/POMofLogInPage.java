package POMpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class POMofLogInPage {
    WebDriver driver;
    public POMofLogInPage(WebDriver driver){

       this.driver=driver;
    }
    By userName= By.xpath("//*[@id='Email']");
    By password= By.xpath("//*[@id='Password']");
    By loginBtn= By.xpath("//*[@class='button-1 login-button']");
    By signout = By.xpath("//*[@id='navbarText']/ul/li[3]");
//Actions on Login PAGE
public void enterUserName(String usrName){
    driver.findElement(userName).clear();
    driver.findElement(userName).sendKeys(usrName);
}
    public void enterPassword(String psw){
        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(psw);
    }
    public void loginButton(){

        driver.findElement(loginBtn).click();
    }
public void signOut(){
        driver.findElement(signout).click();
}



}
