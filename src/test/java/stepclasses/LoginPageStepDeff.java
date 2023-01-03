package stepclasses;

import POMpackage.POMSerExcCustomer_email;
import POMpackage.POMofLogInPage;
import POMpackage.POMofNewCustomer;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.implementation.FieldAccessor;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class LoginPageStepDeff extends BaseClass {

    POMofLogInPage loginpage;
    POMofNewCustomer PomnewCustomer;
    POMSerExcCustomer_email serexCustomer;

    @Given("user should launch the browser {string}")
    public void user_should_launch_the_browser(String browser)  {
        serexCustomer=new POMSerExcCustomer_email(driver);

        logger= Logger.getLogger("nonCommerceDemo");
        browserSetUp(browser);

        loginpage=new POMofLogInPage(driver);
        PomnewCustomer = new POMofNewCustomer(driver);

        PropertyConfigurator.configure("log4j.properties");
logger.info("this is info");


    }
    @When("open demo login page with page title {string}")
    public void open_demo_login_page_with_page_title(String string) {
  logger.debug("this is debug");
     setURL("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
        Assert.assertEquals(driver.getTitle(),string);
    }

    @Then("user should enter Username {string} and Password {string}")
    public void user_should_enter_username_and_password(String string, String string2) {

      loginpage.enterUserName(string);
      loginpage.enterPassword(string2);
    }

    @Then("user should click on login and should login succesfully with page title {string}")
    public void user_should_click_on_login_and_should_login_succesfully_with_page_title(String string) throws InterruptedException {
       loginpage.loginButton();
       Thread.sleep(3000);
        Assert.assertEquals(string,driver.getTitle());
    }

    @Then("user should sign out, with page title {string}")
    public void user_should_sign_out_with_page_title(String string) {
   loginpage.signOut();
    Assert.assertEquals(string,driver.getTitle());
    driver.close();
    }
    // customer --------------------------------------------------------------
    @Then("user clicks on customers menu")
    public void user_clicks_on_customers_menu() throws InterruptedException {


        PomnewCustomer.clickOnCustomerMenu();
    }

    @Then("user clicks on customers menu Item")
    public void user_clicks_on_customers_menu_item() throws InterruptedException {

        PomnewCustomer.clickOnCustomerItem();
    }
    @When("maximize the browser window")
    public void maximize_the_browser_window() {

    }
    @Then("click on Add New button")
    public void click_on_add_new_button() throws InterruptedException {
        Thread.sleep(3000);
        PomnewCustomer.clickOnAddNew();

    }

    @Then("customer can view Add New customer Page with title {string}")
    public void customer_can_view_add_new_customer_page(String string) throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertEquals(driver.getTitle(), string);
    }

    @Then("user enters customer info")
    public void user_enters_customer_info() throws InterruptedException {
        Thread.sleep(4000);
       PomnewCustomer.emailId("diwa@143gmail.com");
        PomnewCustomer.password("143@diwakar");
        PomnewCustomer.firstName("diwakar");
        PomnewCustomer.lastName("reddy");
        PomnewCustomer.gender("female");
        PomnewCustomer.dateofbirth("8/18/1998");
        PomnewCustomer.compamy_Name("DiwakarTrading");
        PomnewCustomer.tax_exempt();
        PomnewCustomer.setCustomer_role("Forum Moderators");
        PomnewCustomer.getAdmin_Comment("hloddd lajnsl....");
    }

    @Then("click on save button")
    public void click_on_save_button() throws InterruptedException {
        Thread.sleep(2000);
        PomnewCustomer.setSaveBtn();
    }

    @Then("user should view confirmation message {string}")
    public void user_should_view_confirmation_message(String string) throws InterruptedException {
        Thread.sleep(3000);
          Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains(string));

        }


    @Then("close browser")
    public void close_browser() {
driver.close();
    }
//____________Existing customer details__through email ID_______________________//

    @Then("user should enter email id")
    public void user_should_enter_email_id() throws InterruptedException {
        Thread.sleep(3000);
        serexCustomer.setTxt_Email("diwa@143gmail.com");
    }
    @Then("click on search button")
    public void click_on_search_button() throws InterruptedException {
        Thread.sleep(2000);
   serexCustomer.click_Search();

    }
    @Then("user should find details on table")
    public void user_should_find_details_on_table() throws InterruptedException {
        Thread.sleep(2000);
    Assert.assertTrue( serexCustomer.search_Cusromer_by_Email("diwa@143gmail.com"));

    }
    @Then("user enter First and Last Name")
    public void user_enter_first_and_last_name() throws InterruptedException {
            Thread.sleep(3000);

        serexCustomer.setFirst_Name("Rajanala");
       serexCustomer.setLast_name_Name("NagaMadhu");

    }
    @Then("user should find details on table on second column")
    public void user_should_find_details_on_table_on_second_column(){
        serexCustomer.search_by_names("Rajanala","NagaMadhu");

    }

}
