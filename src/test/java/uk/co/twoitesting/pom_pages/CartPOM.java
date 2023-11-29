package uk.co.twoitesting.pom_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static uk.co.twoitesting.utilities.UtilityLibrary.*;

public class CartPOM {

    private final WebDriver driver;

    //Constructor

    public CartPOM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Locators
    @FindBy(css = "table.shop_table")
    private WebElement shopTable;

    @FindBy(id = "coupon_code")
    private WebElement couponCodeField;

    @FindBy(css = "button[name='apply_coupon']")
    private WebElement applyCouponBtn;

    @FindBy(css = ".cart-subtotal > td > .amount.woocommerce-Price-amount > bdi")
    private WebElement subtotal;

    @FindBy(css = "#post-5 > div > div > div.woocommerce-notices-wrapper")
    private WebElement codeDontExistAlert;

    @FindBy(css = "tr:nth-of-type(1) > .product-remove > .remove")
    private WebElement removeIcon;

    //Getters

    public String getMessageAlert(){
        waitForElementToBeClickable(driver, codeDontExistAlert, 5);
        return codeDontExistAlert.getText();
    }
    public double getSubtotal() {
        return parseToDouble(subtotal);
    }

    //Methods
    public int numOfItemsInTheCart(){
        waitForElementToBeClickable(driver, shopTable, 2);
        List<WebElement> products = shopTable.findElements(By.tagName("tr"));
        return (products.size()-2); //table includes row header and a row for coupon code
    }

    public void typeCouponCode(String couponCode) {
        couponCodeField.sendKeys(couponCode);
    }

    public void applyCoupon(){
        applyCouponBtn.click();
    }

    public double parseToDouble(WebElement element){
        waitForElementToBeClickable(driver, element, 2);
        return Double.parseDouble(element.getText().substring(1));
    }

    public boolean productInCart(){
        try {
            return removeIcon.isDisplayed();
        }
        catch (Exception e){
            return false;
        }
    }

    public void removeItem(){
        removeIcon.click();
    }
}
