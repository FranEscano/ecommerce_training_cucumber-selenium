package uk.co.twoitesting.pom_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static uk.co.twoitesting.utilities.UtilityLibrary.waitForElementToBeClickable;

public class MyAccountPOM {

    private final WebDriver driver;

    //Constructor
    public MyAccountPOM(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Locators
    @FindBy(linkText = "Dismiss")
    private WebElement dismissLink;

    @FindBy(id = "username")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(css = "button[name='login']")
    private WebElement loginBtn;

    @FindBy(className = "woocommerce-MyAccount-navigation")
    private WebElement accountMenu;


    //Getters

    public WebElement getAccountMenu() {
        return accountMenu;
    }

    public WebElement getUsernameField() {
        return usernameField;
    }

    //Methods
    public void acceptCookies(){
        waitForElementToBeClickable(driver, dismissLink, 2);
        dismissLink.click();
    }
    public void login(String username, String password){
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginBtn.click();
    }


}
