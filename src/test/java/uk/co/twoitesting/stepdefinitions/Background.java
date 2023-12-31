package uk.co.twoitesting.stepdefinitions;

import io.cucumber.java.en.*;

import org.hamcrest.MatcherAssert;
import org.openqa.selenium.WebDriver;
import uk.co.twoitesting.pom_pages.MyAccountPOM;

import static org.hamcrest.CoreMatchers.is;

public class Background {

    private final WebDriver driver;


    //    private final MyAccountPOM account;

    public Background(SharedDictionary shareDict) {
        this.driver = (WebDriver) shareDict.readDict("mydriver");
    }



    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        System.out.println("User in login page");
    }
    @When("I enter valid username {string} and password {string}")
    public void i_enter_valid_username_and_password(String username, String password) {
        MyAccountPOM account = new MyAccountPOM(driver);
        account.login(username, password);
        System.out.println("User entered valid username " +username +" and password " +password);
    }

    @Then("I am logged in")
    public void i_am_logged_in() {
        MyAccountPOM account = new MyAccountPOM(driver);
        MatcherAssert.assertThat(account.accountMenuDisplayed(), is(true));
        System.out.println("User is logged in");
    }

}
