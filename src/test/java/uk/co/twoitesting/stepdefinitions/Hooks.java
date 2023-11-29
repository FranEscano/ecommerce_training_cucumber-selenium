package uk.co.twoitesting.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import uk.co.twoitesting.pom_components.NavBarPOM;
import uk.co.twoitesting.pom_pages.CartPOM;
import uk.co.twoitesting.pom_pages.MyAccountPOM;

public class Hooks {

     private WebDriver driver;
     String baseUrl = "https://www.edgewordstraining.co.uk/demo-site/my-account/";
     private final SharedDictionary shareDict;

    public Hooks(SharedDictionary shareDict) {
        this.shareDict = shareDict;
    }

    @Before
    public void setUp(){
        driver = new FirefoxDriver();
        shareDict.addDict("mydriver", driver);
        shareDict.addDict("baseURL", baseUrl);
        driver.get(baseUrl);
        MyAccountPOM account = new MyAccountPOM(driver);
        account.acceptCookies();
    }

    @After
    public void tearDown() {
        this.driver = (WebDriver) shareDict.readDict("mydriver");
        NavBarPOM navBar = new NavBarPOM(driver);
        navBar.clickCart();

        CartPOM myCart = new CartPOM(driver);
        if(myCart.productInCart()){
            myCart.removeItem();
        }


        driver.quit();
    }
}
