package uk.co.twoitesting.pom_pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static uk.co.twoitesting.utilities.UtilityLibrary.*;


public class CheckoutPOM {

    private final WebDriver driver;

    public CheckoutPOM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Locators
    @FindBy(id = "billing_first_name")
    private WebElement firstNameField;

    @FindBy(id = "billing_last_name")
    private WebElement lastNameField;

    @FindBy(id = "billing_address_1")
    private WebElement addressField;

    @FindBy(id = "billing_city")
    private WebElement cityField;

    @FindBy(id = "billing_postcode")
    private WebElement postcodeField;

    @FindBy(id = "billing_phone")
    private WebElement phoneField;

    @FindBy(id = "billing_email")
    private WebElement emailField;

    @FindBy(id = "place_order")
    private WebElement placeOrderBtn;

    //Methods
    public void populateForm(String firstName, String lastName, String address, String city, String postCode, String phone, String email){
        waitForElementToBeClickable(driver, firstNameField, 2);
        firstNameField.clear();
        firstNameField.sendKeys(firstName);
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
        addressField.clear();
        addressField.sendKeys(address);
        cityField.clear();
        cityField.sendKeys(city);
        postcodeField.clear();
        postcodeField.sendKeys(postCode);
        phoneField.clear();
        phoneField.sendKeys(phone);
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void clickPlaceOrder() {

        Actions actions = new Actions(driver);
        actions.moveToElement(placeOrderBtn);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        waitForElementToBeClickable(driver,placeOrderBtn,3);
        executor.executeScript("arguments[0].click();", placeOrderBtn);
    }
}

