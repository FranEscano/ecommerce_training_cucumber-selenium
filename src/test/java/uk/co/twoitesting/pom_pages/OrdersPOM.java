package uk.co.twoitesting.pom_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OrdersPOM {

    private final WebDriver driver;

    private static String orderNumber;

    public OrdersPOM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        OrdersPOM.orderNumber = orderNumber;
    }

    public WebElement findOrder(String orderToFind) {
        WebElement rowInfo = null;
        System.out.println(orderToFind);
        List<WebElement> tableRows = driver.findElements(By.cssSelector("#post-7 > div > div > div > table > tbody > tr"));
        for (WebElement row : tableRows) {
            List<WebElement> rowCells = row.findElements(By.cssSelector("#post-7 > div > div > div > table > tbody > tr > td.woocommerce-orders-table__cell.woocommerce-orders-table__cell-order-number"));
            for (WebElement valueInTable : rowCells) {
                if (valueInTable.getText().equals(orderToFind)) {
                    rowInfo = row;
                    System.out.println("valueInTable found");
                }
            }

        }
        return rowInfo;
    }
}
