package runner;

import PO.DoBuyPO;
import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class DoBuyStepDef {

    WebDriver driver;
    DoBuyPO doBuyPO;


    @Before
    public void setUpBeforeClass() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Deise\\eclipse-workspace\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        doBuyPO = new DoBuyPO();
        doBuyPO.authenticateOnPage(driver);


    }

    @After
    public void tearDownAfterClass() throws Exception {
       driver.close();

    }



    @Given("^the customer performs a product search$")
    public void the_customer_performs_a_product_search(DataTable data) {
        doBuyPO.searchProduct(data, driver);


    }

    @And("^the user click search button$")
    public void the_user_click_search_button() throws Throwable {
        doBuyPO.search(driver);
    }

    @When("^the user select the product$")
    public void the_user_select_the_product(DataTable data) throws Throwable {

        doBuyPO.selectProduct(data, driver);
    }

    @Given("^click add to cart$")
    public void click_add_to_cart() throws Throwable {
        doBuyPO.addCart(driver);

    }

    @Then("^the user view product in cart$")
    public void the_user_view_product_in_cart(DataTable data) throws Throwable {
        doBuyPO.validateProduct(data, driver);

    }

    @And("^click the continue button$")
    public void click_the_continue_button() throws Throwable {
        doBuyPO.continueButton(driver);
    }

    @And("^user fills data from your address$")
    public void user_fills_data_from_your_address(DataTable data) throws Throwable {
        doBuyPO.fillsAddress(data, driver);

    }


    @Then("^the user ends the buy$")
    public void the_user_ends_the_buy() throws Throwable {
        doBuyPO.clickEndsBuy(driver);

    }

    @Then("^user to complete the payment method$")
    public void user_to_complete_the_payment_method(DataTable data) throws Throwable {
        doBuyPO.fillsPayment(data, driver);

    }

    @And("^user confirm your address$")
    public void user_confirm_your_address() throws Throwable {
        doBuyPO.confirmAddress(driver);

    }

    @And("^user logging out of the system$")
    public void user_logging_out_of_the_system() throws Throwable {
        doBuyPO.doLoggingOutOf(driver);

    }


    @And("^adds two units$")
    public void add_two_units() throws Throwable {
        doBuyPO.AddUnits(driver);

    }

    @But("^remove units$")
    public void remove_units() throws Throwable {
        doBuyPO.removeUnits(driver);

    }




}



