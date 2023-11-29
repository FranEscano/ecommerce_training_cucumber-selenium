package uk.co.twoitesting.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.WebDriver;
import uk.co.twoitesting.pom_components.AccountMenuPOM;
import uk.co.twoitesting.pom_components.NavBarPOM;
import uk.co.twoitesting.pom_pages.CartPOM;
import uk.co.twoitesting.pom_pages.MyAccountPOM;
import uk.co.twoitesting.pom_pages.ShopPOM;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.fail;

public class Cart {

    private final WebDriver driver;
    private final NavBarPOM navBar;

    public Cart(SharedDictionary shareDict) {
        this.driver = (WebDriver) shareDict.readDict("mydriver");
        this.navBar = new NavBarPOM(driver);
    }

    @When("I add the code {string} to the cart")
    public void iAddTheCodeToTheCart(String couponCode) {
        ShopPOM shopper = new ShopPOM(driver);
        shopper.viewCart();
        CartPOM myCart = new CartPOM(driver);
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
        CartPOM myCart = new CartPOM(driver);
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
//        NavBarPOM navBar = new NavBarPOM(driver);
        navBar.clickAccount();

        AccountMenuPOM accountMenu = new AccountMenuPOM(driver);
        accountMenu.pressLogout();

        MyAccountPOM account = new MyAccountPOM(driver);
        MatcherAssert.assertThat(account.loginFormDisplayed(), is(true));
        System.out.println("User is logged out");
    }

    private double totalDiscount(Integer expectedDiscount){
        CartPOM myCart = new CartPOM(driver);
        return (((double) expectedDiscount /100)*(myCart.getSubtotal()*100))/100;
    }
}
