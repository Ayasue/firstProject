package OrangeHRM.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class AdminPage {
    public AdminPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a/span[text()='Admin']")
    public WebElement adminTab;

    @FindBy (xpath = "(//div[6]/div/button[2])[1]")
    public WebElement editButton;

    @FindBy (xpath = "//input[@placeholder='Type for hints...']")
    public WebElement deleteInput;



    @FindBy (css = "button[type='submit']")
    public WebElement saveButton2;


}
