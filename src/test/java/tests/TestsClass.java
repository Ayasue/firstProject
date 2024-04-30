package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.HomePage;
import pages.LoginPage;
import utils.Config;
import utils.Driver;

public class TestsClass {
    LoginPage loginPage = new LoginPage();
    CartPage cartPage = new CartPage();
    HomePage homePage = new HomePage();
    @Test
    public void shopping(){
        Driver.getDriver().get(Config.getProperties("sauceDemo"));
        loginPage.userName.sendKeys(Config.getProperties("sauceUser"));
        loginPage.password.sendKeys(Config.getProperties("saucePassword"));
        loginPage.loginButton.click();
        String url = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(url,Driver.getDriver().getCurrentUrl());
        homePage.addTShirt.click();
        Assert.assertEquals(homePage.cartWithNumber.getText(), "1");
        homePage.cart.click();
        cartPage.checkOut.click();
        cartPage.firstName.sendKeys(Config.getProperties("sauceFirstName"));
        cartPage.lastName.sendKeys(Config.getProperties("sauceLastName"));
        cartPage.zipCode.sendKeys(Config.getProperties("sauceZipCode"));
        cartPage.submit.click();






    }
}
