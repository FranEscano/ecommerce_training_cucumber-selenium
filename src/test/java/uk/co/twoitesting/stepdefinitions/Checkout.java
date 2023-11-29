package uk.co.twoitesting.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import uk.co.twoitesting.pom_components.NavBarPOM;
import uk.co.twoitesting.pom_pages.CheckoutPOM;

import java.util.List;
import java.util.Map;

public class Checkout {

    private final WebDriver driver;

    public Checkout(SharedDictionary shareDict) {
        this.driver = (WebDriver) shareDict.readDict("mydriver");
    }

    @And("I navigate to the checkout section")
    public void iNavigateToTheCheckoutSection() {
        NavBarPOM navBar = new NavBarPOM(driver);
        navBar.clickCheckout();
        System.out.println("User is in checkout section");
    }

    @When("I complete the form with")
    public void iCompleteTheFormWith(DataTable table) {
        CheckoutPOM checkout = new CheckoutPOM(driver);

        List<Map<String, String>> rows = table.asMaps(String.class, String.class);

        for (Map<String, String> data : rows) {
            checkout.populateForm(data.get("firstName"), data.get("lastName"), data.get("address"), data.get("city"), data.get("postCode"), data.get("phone"), data.get("email"));
        }
        System.out.println("User entered details");
    }

    @And("Place an order")
    public void placeAnOrder() {
        CheckoutPOM checkout = new CheckoutPOM(driver);
        checkout.clickPlaceOrder();

    }

}
