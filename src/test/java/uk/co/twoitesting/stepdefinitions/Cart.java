package uk.co.twoitesting.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hamcrest.MatcherAssert;
import uk.co.twoitesting.pom_components.AccountMenuPOM;
import uk.co.twoitesting.pom_components.NavBarPOM;
import uk.co.twoitesting.pom_pages.CartPOM;
import uk.co.twoitesting.pom_pages.MyAccountPOM;
import uk.co.twoitesting.pom_pages.ShopPOM;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.fail;

public class Cart {

    private final NavBarPOM navBar;
    private final CartPOM myCart;
    private final MyAccountPOM account;
    private final ShopPOM shopper;

    private final AccountMenuPOM accountMenu;

    public Cart(Hooks hooks) {
        this.navBar = hooks.navBar;
        this.myCart = hooks.myCart;
        this.account = hooks.account;
        this.shopper = hooks.shopper;
        this.accountMenu = hooks.accountMenu;
    }

    @When("I add a coupon code")
    public void iAddACouponCode() {
        shopper.viewCart();
        int numOfItems = myCart.numOfItemsInTheCart();
        if(numOfItems == 0){
            fail("No products found in cart");
        } else if (numOfItems == 1) {
            System.out.println("There is 1 product in the cart");
        } else {
            System.out.println(("There are " +numOfItems +" products in the cart"));
        }
        myCart.typeCouponCode("edgewords");
        myCart.applyCoupon();
        System.out.println("User applied code");
    }

    @Then("A discount is applied")
    public void aDiscountIsApplied() {

        MatcherAssert.assertThat(myCart.totalDiscount(), is(myCart.parseToDouble(myCart.getDiscountAmount())));
        System.out.println("15% discount of " +myCart.parseToDouble(myCart.getSubtotal()) + " is " + myCart.totalDiscount());
    }

    @And("I am able to log out")
    public void iAmAbleToLogOut() {
        navBar.clickAccount();

        accountMenu.pressLogout();

        MatcherAssert.assertThat(account.getUsernameField().isDisplayed(), is(true));
        System.out.println("User is logged out");
    }
}
