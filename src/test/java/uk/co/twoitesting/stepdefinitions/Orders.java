package uk.co.twoitesting.stepdefinitions;

import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import uk.co.twoitesting.pom_components.AccountMenuPOM;
import uk.co.twoitesting.pom_components.NavBarPOM;
import uk.co.twoitesting.pom_pages.OrdersPOM;

public class Orders {

    private final OrdersPOM order;
    private final AccountMenuPOM accountMenu;
    private final NavBarPOM navBar;


    public Orders(Hooks hooks) {
        this.order = hooks.order;
        this.accountMenu = hooks.accountMenu;
        this.navBar = hooks.navBar;
    }

    @Then("I can see my order")
    public void iCanSeeMyOrder() {
        navBar.clickAccount();
        accountMenu.pressOrders();
        System.out.println("User is in orders section");
        WebElement rowInfo = order.findOrder("#" +order.getOrderNumber());
        System.out.println(rowInfo.getText());
    }
}
