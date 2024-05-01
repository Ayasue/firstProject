package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class LoginPage {
    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//input[@id='user-name']")
    public WebElement userName;

    @FindBy(css = "input[id=password]")
    public WebElement password;

    @FindBy(css = "input[id=login-button]")
    public WebElement loginButton;

    @FindBy()
    public WebElement somThing;

}
