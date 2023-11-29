package uk.co.twoitesting.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import uk.co.twoitesting.pom_components.AccountMenuPOM;
import uk.co.twoitesting.pom_components.NavBarPOM;
import uk.co.twoitesting.pom_pages.OrderReceivedPOM;
import uk.co.twoitesting.pom_pages.OrdersPOM;

public class Orders {

private final WebDriver driver;

    private final SharedDictionary shareDict;

    public Orders(SharedDictionary shareDict) {
        this.driver = (WebDriver) shareDict.readDict("mydriver");
        this.shareDict = shareDict;

    }

    @Then("I receive a confirmation order number")
    public void iReceiveAConfirmationOrderNumber() {
        OrderReceivedPOM orderReceived = new OrderReceivedPOM(driver);
        String orderNumber = orderReceived.getOrderNumber();
        shareDict.addDict("orderNumber", orderNumber);
        System.out.println("The order number is: " + orderNumber);
    }

    @And("that order number is in my order history")
    public void thatOrderNumberIsInMyOrderHistory(){
        NavBarPOM navBar = new NavBarPOM(driver);
        navBar.clickAccount();

        AccountMenuPOM accountMenu = new AccountMenuPOM(driver);
        accountMenu.pressOrders();
        System.out.println("User is in orders section");

        OrdersPOM order = new OrdersPOM(driver);
        WebElement rowInfo = order.findOrder("#" +shareDict.readDict("orderNumber").toString());
        System.out.println(rowInfo.getText());
    }
}
