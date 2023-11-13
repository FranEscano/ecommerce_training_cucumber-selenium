package uk.co.twoitesting.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import uk.co.twoitesting.pom_components.AccountMenuPOM;
import uk.co.twoitesting.pom_components.NavBarPOM;
import uk.co.twoitesting.pom_pages.*;

public class Hooks {

     WebDriver driver;
     String baseUrl = "https://www.edgewordstraining.co.uk/demo-site/my-account/";
     MyAccountPOM account;
     NavBarPOM navBar;
     ShopPOM shopper;
     CartPOM myCart;
     CheckoutPOM checkout;
     OrdersPOM order;
     AccountMenuPOM accountMenu;

     String orderNumber;

    @Before
    public void setUp(){
        driver = new ChromeDriver();
        account = new MyAccountPOM(driver);
        navBar = new NavBarPOM(driver);
        shopper = new ShopPOM(driver);
        myCart = new CartPOM(driver);
        checkout = new CheckoutPOM(driver);
        order = new OrdersPOM(driver);
        accountMenu = new AccountMenuPOM(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
