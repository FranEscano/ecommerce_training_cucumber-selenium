package uk.co.twoitesting.pom_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static uk.co.twoitesting.utilities.UtilityLibrary.waitForElementToBeClickable;

public class OrderReceivedPOM {
    private final WebDriver driver;

    public OrderReceivedPOM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".order > strong")
    private WebElement orderNumber;

    public String getOrderNumber() {
        waitForElementToBeClickable(driver, orderNumber, 3);
        return orderNumber.getText();
    }
}
