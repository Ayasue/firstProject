package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.LoginPage;
import utils.Config;
import utils.Driver;
import utils.SeleniumUtils;

public class LoginDemoSteps {
    WebDriver driver = Driver.getDriver();
    LoginPage loginPage = new LoginPage();

    @Given("user goes to {string}")
    public void user_goes_to(String string) {
        driver.get("https://www.saucedemo.com/");
    }

    @When("user provides correct user name")
    public void user_provides_correct_user_name() {
        loginPage.userName.sendKeys(Config.getProperties("sauceUser"));
    }
    @When("user provides correct password")
    public void user_provides_correct_password() {
       loginPage.password.sendKeys(Config.getProperties("saucePassword"));
    }
    @Then("user clicks on login button")
    public void user_clicks_on_login_button() {
       loginPage.loginButton.click();
    }
    @Then("verify user successfully logged in")
    public void verify_user_successfully_logged_in() {
        Assert.assertEquals(Config.getProperties("sauceDemoMain"),Driver.getDriver().getCurrentUrl());
        driver.close();
    }
}
