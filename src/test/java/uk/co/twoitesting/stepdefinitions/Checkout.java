package uk.co.twoitesting.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import uk.co.twoitesting.pom_components.NavBarPOM;
import uk.co.twoitesting.pom_pages.CheckoutPOM;

import java.util.List;
import java.util.Map;

public class Checkout {

    private final NavBarPOM navBar;
    private final CheckoutPOM checkout;

    public Checkout(Hooks hooks) {
        this.navBar = hooks.navBar;
        this.checkout = hooks.checkout;
    }

    @And("I navigate to the checkout section")
    public void iNavigateToTheCheckoutSection() {
        navBar.clickCheckout();
        System.out.println("User is in checkout section");
    }

    @When("I complete the form with")
    public void iCompleteTheFormWith(DataTable table) {
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);

        for (Map<String, String> data : rows) {
            checkout.populateForm(data.get("firstName"), data.get("lastName"), data.get("address"), data.get("city"), data.get("postCode"), data.get("phone"), data.get("email"));
        }
        System.out.println("User entered details");
    }

    @And("Place an order")
    public void placeAnOrder() {
        checkout.clickPlaceOrder();

    }

}
