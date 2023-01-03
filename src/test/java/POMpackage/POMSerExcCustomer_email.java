package POMpackage;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import stepclasses.BaseClass;


import java.net.IDN;
import java.time.Duration;
import java.util.List;


public class POMSerExcCustomer_email   {
    WebDriver driver;
  public   POMSerExcCustomer_email(WebDriver driver){
      this.driver= driver;

  }
    //By Txt_Email = By.id("SearchEmail");
    @FindBy(id="SearchEmail")
            WebElement Txt_Email;
    By search_BTN= By.xpath("//*[@id='search-customers']");
    //By table = By.xpath("//table[@id='customers-grid']");
    By rows =By.xpath("//table[@id='customers-grid']/tbody/tr");

    By First_Name = By.id("SearchFirstName");
    By Last_name = By.id("SearchLastName");
//    By colums = By.xpath("//table[@id='customers-grid']/tbody/tr/td");
//    Actions____________________----------_____-----------_______---_________

     public void setTxt_Email(String email)  {
       Txt_Email.sendKeys(email);
     }
     public void click_Search(){
         driver.findElement(search_BTN).click();
     }

     public int getNoOfRows(){
      List<WebElement> ele= driver.findElements(rows);
            return ele.size();


     }
//    public int getNoOfcolums(){
//        List<WebElement> ele=   driver.findElements(colums);
//        return ele.size();

    public boolean search_Cusromer_by_Email(String email){
         boolean flag= false;
         for (int i=1 ; i<=getNoOfRows();i++){
           String sr=  driver.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[2]")).getText();
           if (sr.equals(email)){
               flag=true;
           }

         }
        return flag;
    }
    public void setFirst_Name(String firstName){
//      WebElement ele=  driver.findElement(First_Name);
//         helpwaitTimer(ele, Duration.ofSeconds(30));
         driver.findElement(First_Name).sendKeys(firstName);
    }
    public void setLast_name_Name(String lastName){
//        WebElement ele=  driver.findElement(Last_name);
//        helpwaitTimer(ele, Duration.ofSeconds(30));

        driver.findElement(Last_name).sendKeys(lastName);
    }
    public boolean search_by_names(String firstName, String lastName){
        boolean flag= false;
        for (int i=1 ; i<=getNoOfRows();i++){
            String sr=  driver.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[3]")).getText();
            System.out.println(sr);
            if (sr.contains(firstName)||sr.contains(lastName)){

                flag=true;
            }


        }

        return flag;
    }


}
