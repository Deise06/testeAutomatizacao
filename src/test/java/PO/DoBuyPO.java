package PO;

import cucumber.api.DataTable;

import org.junit.Assert;
import org.openqa.selenium.*;

import java.io.FileInputStream;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class DoBuyPO {



    public void authenticateOnPage(WebDriver driver) {
        String valorPropriedade = null;
        String e_mail = null;
        String senha = null;

        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("C:\\Automacao\\AutomacaoPrj\\src\\test\\resources\\configuracoes\\config.properties"));

            valorPropriedade = properties.getProperty("url.site");
            driver.get(valorPropriedade);
            driver.manage().window().maximize();
            e_mail = properties.getProperty("e_mail");
            senha = properties.getProperty("senha");

        } catch (Exception e) {
            e.printStackTrace();
        }

        driver.findElement(By.id("topbar-login-link")).click();


        driver.manage().timeouts().setScriptTimeout(50, TimeUnit.SECONDS);
        driver.switchTo().frame("iframeLogin");

        driver.findElement(By.name("signinField")).sendKeys(e_mail);
        driver.findElement(By.name("password")).sendKeys(senha);
        driver.findElement(By.id("signinButtonSend")).click();
    }

    public void searchProduct(DataTable data, WebDriver driver) {

        driver.findElement(By.id("suggestion-search")).sendKeys(data.cells(1).get(0).get(0));

    }

    public void search(WebDriver driver) {
        driver.findElement(By.id("suggestion-search")).sendKeys(Keys.RETURN);
    }

    public void selectProduct(DataTable data, WebDriver driver) throws InterruptedException {
        List<WebElement> cardsProdutos = driver.findElements(By.className("card"));

        for (WebElement card : cardsProdutos) {
            if (card.findElement(By.className("product-title")).getText().contains(data.cells(0).get(0).get(0))) {
                card.click();
                break;
            }
        }
    }

    public void fillsAddress(DataTable data, WebDriver driver) throws InterruptedException {
        driver.findElement(By.id("txtReceiverName")).sendKeys(data.cells(1).get(0).get(0));
        driver.findElement(By.id("txtPostalCode")).sendKeys(data.cells(1).get(0).get(1));
        driver.findElement(By.id("txtNumber")).sendKeys(data.cells(1).get(0).get(2));

        WebElement webElement = driver.findElement(By.xpath("//button[contains(@data-id, 'sltType')]"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click()", webElement);
        List<WebElement> selectedItens = driver.findElement(By.cssSelector(".form-type-address > .open > .open > .dropdown-menu.inner")).findElements(By.tagName("span"));
        selectedItens
                .stream()
                .filter(item -> item.getText().trim().equals(data.cells(1).get(0).get(3)))
                .findFirst()
                .ifPresent(WebElement::click);
        driver.findElement(By.id("txtReferencePoint")).sendKeys(data.cells(1).get(0).get(4));
        driver.findElement(By.id("btn-set-delivery")).click();
        confirmAddress(driver);
        Thread.sleep(3000);

    }


    public void addCart(WebDriver driver) throws InterruptedException {
        driver.findElement(By.className("button-success").className("fluid")).click();
        Thread.sleep(2000);

        driver.findElement(By.className("cart").className("cart-link")).click();
    }

    public void validateProduct(DataTable data, WebDriver driver) throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"main\"]/div/main/div/div/div[1]/div/div/div[2]/div[3]/div")).getText().trim()
                .contains(data.cells(1).get(0).get(0).trim()));
     }


    public void continueButton(WebDriver driver) {
        driver.findElement(By.id("btn-continue")).click();

    }

    public void confirmAddress(WebDriver driver) throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.className("steps-control-wrapperbtn").className("btn-success")).click();


    }


    public void clickEndsBuy(WebDriver driver) throws InterruptedException {

        Thread.sleep(3000);

        driver.findElement(By.className("btn-success").id("btn-finalize-cart")).click();


    }


    public void fillsPayment(DataTable data, WebDriver driver) throws InterruptedException {
        DoBuyPO doBuyPO = new DoBuyPO();
        doBuyPO.confirmAddress(driver);
        Thread.sleep(2000);
        driver.findElement(By.className("select-card-item").className("card-id-2")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("txtCardNumber")).sendKeys(data.cells(1).get(0).get(1));
        Thread.sleep(2000);
        driver.findElement(By.id("txtName")).sendKeys(data.cells(1).get(0).get(2));
        Thread.sleep(2000);
        driver.findElement(By.id("expirationDate")).sendKeys(data.cells(1).get(0).get(3));
        Thread.sleep(2000);
        driver.findElement(By.id("txtSecurityCode")).sendKeys(data.cells(1).get(0).get(4));
        Thread.sleep(2000);
        driver.findElement(By.id("txtDocument")).sendKeys(data.cells(1).get(0).get(5));
        Thread.sleep(2000);
        selectParcel(driver, data);

        driver.findElement(By.className("container-title").className("edit-link")).click();


    }


    public void selectParcel(WebDriver driver, DataTable data) throws InterruptedException {
        WebElement webElement = driver.findElement(By.xpath(".//button[@data-id ='sltInstallment']"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click()", webElement);
        Thread.sleep(2000);

        WebElement elemDiv = driver.findElement(By.xpath("//*[@id=\"singleCard\"]/div/div[5]"));
        List<WebElement> listOpcoes = elemDiv.findElements(By.tagName("li"));
        listOpcoes.get(1).click();
        Thread.sleep(2000);

    }

    public void AddUnits(WebDriver driver) throws InterruptedException {
        driver.findElement(By.xpath(".//a[@data-track='ClicouQuantidadeMais']")).click();

    }

    public void removeUnits(WebDriver driver) throws InterruptedException {

       Thread.sleep(2000);
        driver.findElement(By.className("ui-spinner-button").className("ui-spinner-down")).click();

    }


    public void doLoggingOutOf(WebDriver driver) throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.className("profile").className(" icon-topbar-link")).click();
        Thread.sleep(2000);
       JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("javascript:wm.login.logout();");




}
    }




















