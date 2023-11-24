package uk.co.twoitesting.pom_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static uk.co.twoitesting.utilities.UtilityLibrary.*;

public class ShopPOM {

    private final WebDriver driver;
    private enum Products{cap, belt}

    public ShopPOM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Locators

    @FindBy(xpath = "//*[@id=\"main\"]/ul/li[3]/a[1]/h2")
    private WebElement capText;
    @FindBy(xpath = "//*[@id=\"main\"]/ul/li[2]/a[1]/h2")
    private WebElement beltText;

    @FindBy(css = "a[data-product_id='29']")
    private WebElement capAddBtn;
    @FindBy(css = "a[data-product_id='28']")
    private WebElement beltAddBtn;

    @FindBy(linkText = "View cart")
    private WebElement viewCartLink;


    public String getCap() {
        return capText.getText();
    }

    public String getBelt(){
        return beltText.getText();
    }

    //Methods
    public String addProduct(String product){
        String prodText = "";
        Products prod = Products.valueOf(product);
        switch (prod){
            case cap:
                prodText = addCap();
                break;
            case belt:
                prodText = addBelt();
                break;
        }
        return prodText;
    }
    public String addCap(){
        capAddBtn.click();
        return getCap();
    }

    public String addBelt(){
        beltAddBtn.click();
        return getBelt();
    }

    public void viewCart(){
        waitForElementToBeClickable(driver,viewCartLink,2);
        viewCartLink.click();
    }
}
