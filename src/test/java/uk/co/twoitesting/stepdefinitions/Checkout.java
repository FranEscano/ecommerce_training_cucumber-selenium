package uk.co.twoitesting.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import uk.co.twoitesting.pom_components.NavBarPOM;
import uk.co.twoitesting.pom_pages.CheckoutPOM;
import uk.co.twoitesting.pom_pages.OrdersPOM;

public class Checkout {

    private final NavBarPOM navBar;
    private final CheckoutPOM checkout;
    private final OrdersPOM order;
    private String orderNumber;

    public Checkout(Hooks hooks) {
        this.navBar = hooks.navBar;
        this.checkout = hooks.checkout;
        this.orderNumber = hooks.orderNumber;
        this.order = hooks.order;
    }

    @And("I navigate to the checkout section")
    public void iNavigateToTheCheckoutSection() {
        navBar.clickCheckout();
        System.out.println("User is in checkout section");
    }

    @When("I complete the form with {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void iCompleteTheFormWith(String firstName, String lastName, String address, String city, String postCode, String phone, String email) {
        checkout.populateForm(firstName,lastName, address, city, postCode, phone, email);

        System.out.println("User entered details");
    }

    @And("Place an order")
    public void placeAnOrder() {
        checkout.clickPlaceOrder();
        orderNumber = checkout.getOrderNumber();
        order.setOrderNumber(orderNumber);
        System.out.println("The order number is: " +orderNumber);

    }

}
