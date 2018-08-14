package runner;

import PO.DoBuyPO;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DoBuyStepDef {

     WebDriver driver;
     DoBuyPO doBuyPO;


    @Before
    public void setUpBeforeClass() throws Exception {


        doBuyPO.authenticateOnPage(driver);
    }

    @After
    public void tearDownAfterClass() throws Exception {
        driver.quit();
    }


    @Given("^that the user is authenticated in the application$")
    public void that_the_user_is_authenticated_in_the_application() throws Throwable {
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\Deise\\eclipse-workspace\\chromedriver_win32\\chromedriver.exe");
       //driver = new ChromeDriver();
       // doBuyPO.authenticateOnPage(driver);


    }

    @And("^the customer performs a product search$")
    public void the_customer_performs_a_product_search(DataTable data) {
        doBuyPO.searchProduct(data, driver);


    }

    @And("^the user click search button$")
    public void the_user_click_search_button() throws Throwable {
        doBuyPO.search(driver);
    }

    @And("^the user selects the product$")
    public void the_user_selects_the_product(DataTable data) throws Throwable {
        doBuyPO.selectProduct(data, driver);
        System.out.println(data.cells(1).get(0).get(0));
    }

    @Given("^click add to cart$")
    public void click_add_to_cart() throws Throwable {
        doBuyPO.addCart(driver);

    }

    @And("^the user view product in cart$")
    public void the_user_view_product_in_cart(DataTable data) throws Throwable {
        doBuyPO.validateProduct(data, driver);

    }

    @And("^click the continue button$")
    public void click_the_continue_button() throws Throwable {
        doBuyPO.continueButton(driver);
    }

    @And("^user informs data from your address$")
    public void user_informs_data_from_your_address(DataTable data) throws Throwable {
        doBuyPO.informAddress(data, driver);

    }


    @And("^the user ends the purchase$")
    public void the_user_ends_the_purchase() throws Throwable {
        doBuyPO.clickFinalizeBuy(driver);

    }

    @Then("^user to complete the payment method$")
    public void user_to_complete_the_payment_method(DataTable data) throws Throwable {
        doBuyPO.informPayment(data, driver);

    }

     @And("^user confirm your address$")
    public void user_confirm_your_address() throws Throwable {
        doBuyPO.confirmAddress(driver);

    }
//    @And("^ user logging out of the system$")
//    public void  user_logging_out_of_the_system() throws Throwable {
//        doBuyPO.doLoggingOf(driver);
//
//    }


    @And("^add two units$")
    public void add_two_units() throws Throwable {
        doBuyPO.AddUnits(driver);

    }











}



