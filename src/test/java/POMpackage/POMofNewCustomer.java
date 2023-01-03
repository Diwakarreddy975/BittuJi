package POMpackage;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import stepclasses.BaseClass;

import java.time.Duration;
import java.util.List;
import java.util.Objects;

public class POMofNewCustomer extends BaseClass {
    By customers_menu = By.xpath("//*[@class='nav nav-pills nav-sidebar flex-column nav-legacy']/li[4]");
    @FindBy(xpath = "")
            public  WebElement customers_menuItem;
    By customers_menuItem1 = By.xpath("(//*[@class='nav-item has-treeview menu-is-opening menu-open']/ul//a)[1]");
    By Btn_AddNew= By.xpath("//*[@class='fas fa-plus-square']");
    By txt_Email = By.xpath("//*[@id='Email']");
    By txt_Password =By.xpath("//*[@id='Password']");
    By txt_firstName = By.xpath("//*[@id='FirstName']");
    By txt_lastName = By.xpath("//*[@id='LastName']");
    By gender_Male = By.xpath("//*[@id='Gender_Male']");
    By gender_female = By.xpath("//*[@id='Gender_Female']");
    By dateOfBirth = By.xpath("//*[@id='DateOfBirth']");
    By companyName = By.xpath("//*[@id='Company']");
    By tax_exempt = By.xpath("//*[@id='IsTaxExempt']");
    By customer_role = By.xpath("//ul[@id='SelectedCustomerRoleIds_listbox']/li");
    By list_customer_role=By.xpath("//*[contains(@aria-describedby,'SelectedCustomerRoleIds_taglist')]");
    By admin_Comment = By.xpath("//*[@id='AdminComment']");
    By saveBtn = By.xpath("//*[@class='btn btn-primary']");
    By gender =By.xpath("//*[@id=\"customer-info\"]/div[2]/div[5]/div[2]");
    By succesAlert= By.xpath("//*[@class='alert alert-success alert-dismissable']");
    By list_Administrator = By.xpath("//*[@id='SelectedCustomerRoleIds']/option[1]");
    By Forum_Moderators = By.xpath("//*[@id='SelectedCustomerRoleIds']/option[2]");
    By Guests = By.xpath("//*[@id='SelectedCustomerRoleIds']/option[3]");
    By Vendors = By.xpath("//*[@id='SelectedCustomerRoleIds']/option[5]");
    By Registered = By.xpath("//*[@id='SelectedCustomerRoleIds']/option[4]");
    //Actions
    WebDriver driver;
    public POMofNewCustomer(WebDriver driver)
    {
        this.driver=driver;
        driver.manage().window().maximize();
    }

    public void clickOnCustomerMenu() throws InterruptedException {
       driver.findElement(customers_menu).click();
        Thread.sleep(3000);
    }
    public void clickOnCustomerItem() throws InterruptedException {

        Thread.sleep(2000);

     Actions act=new Actions(driver);
     act.moveToElement(customers_menuItem).click().build().perform();
     System.out.println("Clicked on Customer item 1");

        Thread.sleep(3000);
        System.out.println("Clicked on Customer item 2");
        //helpwaitTimer(ele, Duration.ofSeconds(30));
       //JsClick(ele);
    }

    public void clickOnAddNew(){
        driver.findElement(Btn_AddNew).click();
    }
    public void emailId(String emailid){
        driver.findElement(txt_Email).sendKeys(emailid);
    }
    public void password(String psw){
        driver.findElement(txt_Password).sendKeys(psw);
    }
    public void firstName(String FirstName){
        driver.findElement(txt_firstName).sendKeys(FirstName);
    }
    public void lastName(String LastName){
        driver.findElement(txt_lastName).sendKeys(LastName);
    }
    public void gender(String gender){


        //String s1="male";
        String s2="female";
//        if (s1.equalsIgnoreCase(gender)){
//            driver.findElement(gender_Male).click();
          if (s2.equalsIgnoreCase(gender)) {
              System.out.println(gender);
            driver.findElement(gender_female).click();

        }
        else {
            driver.findElement(gender_Male).click();
        }


    }
//    public void genderfemale(String female){
//        driver.findElement(gender_female).sendKeys(female);
//    }
    public void dateofbirth(String mm_dd_yy){
        driver.findElement(dateOfBirth).sendKeys(mm_dd_yy);
    }
    public void compamy_Name(String name ){
        driver.findElement(companyName).sendKeys(name);
    }
    public void tax_exempt( ){
        driver.findElement(tax_exempt).click();
    }
    public void  setCustomer_role(String string) throws InterruptedException {
        System.out.println(string);

        driver.findElement(list_customer_role).click();
        Thread.sleep(3000);

       // WebElement element = driver.findElement(customer_role);
        // Select dropdown = new Select(element);
//        dropdown.selectByVisibleText("Vendors");

//        String a1 ="Administrators";
//        String a2 ="Forum Moderators";
//        String a3 ="Guests";
//        String a4 ="Registered";
//        String  a5="Vendors";
      /*  if (element.getText().equalsIgnoreCase(string)) {
            driver.findElement(list_Administrator).click();
        } else if (element.getText().equalsIgnoreCase(string)) {
            driver.findElement(Forum_Moderators).click();

        } else if (element.getText().equalsIgnoreCase(string)) {
            driver.findElement(Guests).click();

        } else if (element.getText().equalsIgnoreCase(string)) {
            driver.findElement(Registered).click();

        } else if (element.getText().equalsIgnoreCase(string)) {
            driver.findElement(Vendors).click();

        }*/


        List<WebElement> E = driver.findElements(customer_role);
        System.out.println(E.toString());

        for (WebElement e : E) {
            if (e.getText().equals(string)) {
                e.click();
                break;
            } else if (e.getText().equals(string)) {
                e.click();
                break;
            } else if (e.getText().equals(string)) {
                e.click();
                break;

            } else if (e.getText().equals(string)) {
                e.click();
                break;
            }
            Thread.sleep(3000);


        }
    }

    public void getAdmin_Comment(String comment){

        driver.findElement(admin_Comment).sendKeys(comment);
    }
    public void setSaveBtn(){

        driver.findElement(saveBtn).click();
    }





}
