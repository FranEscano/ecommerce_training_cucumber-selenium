package uk.co.twoitesting.pom_components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavBarPOM {

    //Constructor

    public NavBarPOM(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //Locators
    @FindBy(linkText = "Shop")
    private WebElement shopNav;

    @FindBy(partialLinkText = "account")
    private WebElement accountNav;

    @FindBy(linkText = "Checkout")
    private WebElement checkoutNav;

    //Methods
    public void clickShop(){
        shopNav.click();
    }

    public void clickAccount() {
        accountNav.click();
    }

    public void clickCheckout(){
        checkoutNav.click();
    }
}
