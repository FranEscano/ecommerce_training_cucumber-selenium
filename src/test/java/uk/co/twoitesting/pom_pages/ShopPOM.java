package uk.co.twoitesting.pom_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static uk.co.twoitesting.utilities.UtilityLibrary.*;

public class ShopPOM {

    private final WebDriver driver;

    public ShopPOM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Locators

    @FindBy(xpath = "//*[@id=\"main\"]/ul/li[3]/a[1]/h2")
    private WebElement cap;

    @FindBy(xpath = "//*[@id=\"main\"]/ul/li[3]/a[2]")
    private WebElement capAddBtn;

    @FindBy(linkText = "View cart")
    private WebElement viewCartLink;


    public String getCap() {
        return cap.getText();
    }

    //Methods
    public String addCap(){
        capAddBtn.click();
        return getCap();
    }

    public void viewCart(){
        waitForElementToBeClickable(driver,viewCartLink,2);
        viewCartLink.click();
    }
}
