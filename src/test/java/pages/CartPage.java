package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class CartPage {
    public CartPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id = "checkout")
    public WebElement checkOut;

    @FindBy(id = "first-name")
    public WebElement firstName;

    @FindBy(id = "last-name")
    public WebElement lastName;

    @FindBy(id = "postal-code")
    public WebElement zipCode;

    @FindBy(id = "continue")
    public WebElement submit;
}
