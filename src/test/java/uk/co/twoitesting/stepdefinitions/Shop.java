package uk.co.twoitesting.stepdefinitions;

import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import uk.co.twoitesting.pom_components.NavBarPOM;
import uk.co.twoitesting.pom_pages.ShopPOM;

import java.util.ArrayList;
import java.util.List;

public class Shop {

    private final WebDriver driver;
    private final List<String> productsInCart = new ArrayList<>();

    public Shop(SharedDictionary shareDict) {
        this.driver = (WebDriver) shareDict.readDict("mydriver");
    }

    @When("I add a {string} to the cart")
    public void iAddAProductToTheCart(String product) {
        NavBarPOM navBar = new NavBarPOM(driver);
        navBar.clickShop();

        ShopPOM shopper = new ShopPOM(driver);
        productsInCart.add(shopper.addProduct(product));
        productsInCart.add(shopper.addProduct(product));
        System.out.println("User added " +productsInCart +" to the cart");
    }

}
