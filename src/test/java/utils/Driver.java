package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class Driver {
    static WebDriver driver;

    public static WebDriver getDriver(){
        //if driver object already exists , then we just return it
        if (driver!=null){
            return driver;
        }
        String browser = Config.getProperties("browser");
        switch (browser){
            case "Chrome":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("disable-popup-blocking");

                Map<String, Object> prefs = new HashMap<String, Object>();
                prefs.put("profile.default_content_setting_values.geolocation", 2); // 2 means Block
                options.setExperimentalOption("prefs", prefs);

                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case " Safari":
                driver = new SafariDriver();
                break;
            default:
                driver= new ChromeDriver();

        }
        //these are implicit waits applies to every single webElement
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        return driver;

    }
}
