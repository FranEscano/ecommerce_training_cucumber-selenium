package uk.co.twoitesting.stepdefinitions;

import io.cucumber.java.en.When;
import uk.co.twoitesting.pom_components.NavBarPOM;
import uk.co.twoitesting.pom_pages.ShopPOM;

import java.util.ArrayList;
import java.util.List;

public class Shop {

    private final NavBarPOM navBar;
    private final ShopPOM shopper;
    private final List<String> productsChosen = new ArrayList<>();

    public Shop(Hooks hooks) {
        this.navBar = hooks.navBar;
        this.shopper = hooks.shopper;
    }

    @When("I add a {string} to the cart")
    public void iAddAProductToTheCart(String product) {
        navBar.clickShop();
        productsChosen.add(shopper.addProduct(product));
        System.out.println("User added " +productsChosen +" to the cart");
    }

}
