package uk.co.twoitesting.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import uk.co.twoitesting.pom_components.AccountMenuPOM;
import uk.co.twoitesting.pom_components.NavBarPOM;
import uk.co.twoitesting.pom_pages.OrderReceivedPOM;
import uk.co.twoitesting.pom_pages.OrdersPOM;

public class Orders {

    private final OrdersPOM order;
    private final AccountMenuPOM accountMenu;
    private final NavBarPOM navBar;
    private final OrderReceivedPOM orderReceived;
    private String orderNumber;



    public Orders(Hooks hooks) {
        this.order = hooks.order;
        this.accountMenu = hooks.accountMenu;
        this.navBar = hooks.navBar;
        this.orderNumber = hooks.orderNumber;
        this.orderReceived = hooks.orderReceived;
    }

    @Then("I receive a confirmation order number")
    public void iReceiveAConfirmationOrderNumber() {
        orderNumber = orderReceived.getOrderNumber();
        order.setOrderNumber(orderNumber);
        System.out.println("The order number is: " +orderNumber);
    }

    @And("that order number is in my order history")
    public void thatOrderNumberIsInMyOrderHistory(){
        navBar.clickAccount();
        accountMenu.pressOrders();
        System.out.println("User is in orders section");
        WebElement rowInfo = order.findOrder("#" +order.getOrderNumber());
        System.out.println(rowInfo.getText());
    }
}
