package OrangeHRM.tests;

import OrangeHRM.pages.AdminPage;
import OrangeHRM.pages.LoginPage;
import org.junit.Test;

public class AdminTests {
    LoginPage loginPage = new LoginPage();
    AdminPage adminPage = new AdminPage();
    @Test
    public void loginTest(){
        loginPage.userName.sendKeys("Admin");
        loginPage.password.sendKeys("admin123");
        loginPage.submit.click();

        adminPage.adminTab.click();
        adminPage.editButton.click();
        adminPage.deleteInput.click();


    }
}
