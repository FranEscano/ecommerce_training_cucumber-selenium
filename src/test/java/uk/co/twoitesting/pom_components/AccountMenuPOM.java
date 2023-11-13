package uk.co.twoitesting.pom_components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static uk.co.twoitesting.utilities.UtilityLibrary.waitForElementToBeClickable;

public class AccountMenuPOM {

    private final WebDriver driver;

    public AccountMenuPOM(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Locators
    @FindBy(linkText = "Logout")
    private WebElement logoutBtn;

    @FindBy(linkText = "Orders")
    private WebElement ordersBtn;

    //Methods
    public void pressLogout() {
        waitForElementToBeClickable(driver, logoutBtn, 3);
        logoutBtn.click();
    }

    public void pressOrders(){
        ordersBtn.click();
    }
}
