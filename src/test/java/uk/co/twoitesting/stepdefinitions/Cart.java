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

    @When("I add the code {string} to the cart")
    public void iAddTheCodeToTheCart(String couponCode) {
        shopper.viewCart();
        int numOfItems = myCart.numOfItemsInTheCart();
        if(numOfItems == 0){
            fail("No products found in cart");
        } else if (numOfItems == 1) {
            System.out.println("There is 1 product in the cart");
        } else {
            System.out.println(("There are " +numOfItems +" products in the cart"));
        }
        myCart.typeCouponCode(couponCode);
        myCart.applyCoupon();
        System.out.println("User applied code");
    }

    @Then("A discount of {int}% is applied")
    public void a_discount_of_is_applied(Integer expectedDiscount) {
        String alertMessage = myCart.getMessageAlert();
        String result;
        switch (alertMessage){
            case "Coupon code applied successfully.":
                result = alertMessage;
                System.out.println(expectedDiscount + "% discount of " + myCart.getSubtotal() + " is " + totalDiscount(expectedDiscount));
                break;
            case "Coupon code already applied!":
                result = alertMessage;
                break;
            default:
                result = "Coupon code does not exist!";
        }
        System.out.println(result);
    }

    @And("I am able to log out")
    public void iAmAbleToLogOut() {
        navBar.clickAccount();

        accountMenu.pressLogout();

        MatcherAssert.assertThat(account.loginFormDisplayed(), is(true));
        System.out.println("User is logged out");
    }

    private double totalDiscount(Integer expectedDiscount){
        return (((double) expectedDiscount /100)*(myCart.getSubtotal()*100))/100;
    }
}
