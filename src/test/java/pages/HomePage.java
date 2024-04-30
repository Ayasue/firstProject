package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class HomePage {
    public HomePage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")

    public WebElement addTShirt;

    @FindBy(xpath = "//span[@class='shopping_cart_badge']")
    public WebElement cartWithNumber;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    public WebElement cart;




}
