package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;

import java.time.Duration;

public class SeleniumUtils {
    /**
     * This method clicks on the given element, switches to the newly opened tab and prints its url.
     * @param driver - is used to open new web application
     * @param element - is clicked to open new tab
     */
    public static void switchToNewTab(WebDriver driver, WebElement element){
       String mainWindow = driver.getWindowHandle();

       element.click();
       for (String windowHandle: driver.getWindowHandles()){
           if (!windowHandle.equals(mainWindow)){
               driver.switchTo().window(windowHandle);
           }
       }
        System.out.println(driver.getCurrentUrl());
    }
    public static void click(WebDriver driver, WebElement element){
        /**
         * This method waits for element to be clickable
         * before clicking on it
         *
         */

       FluentWait wait = new FluentWait(driver).ignoring(ElementClickInterceptedException.class)
                       .withTimeout(Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(element));

    }


    /**
     * ths method accepts alert, if alert is not there
     *     it ignores the exception
     * @param driver
     */
    public static void acceptAlert(WebDriver driver){

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
        wait.until(ExpectedConditions.alertIsPresent());
        try {
            driver.switchTo().alert().accept();
        }
        catch (NoAlertPresentException e){
            System.out.println("Alert doesn't exists!");
            e.printStackTrace();
        }
    }

    /**
     * ths method dismiss alert, if alert is not there
     *     it ignores the exception
     * @param driver
     */
    public static void dismissAlert(WebDriver driver){

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
        wait.until(ExpectedConditions.alertIsPresent());
        try {
            driver.switchTo().alert().dismiss();
        }
        catch (NoAlertPresentException e){
            System.out.println("Alert doesn't exists!");
            e.printStackTrace();
        }
    }


    /**
     * The method returns if element is present in the DOM
     * @param driver to go to webpage
     * @param locator of the web element
     * @return
     */
    public static boolean isElementPresent(WebDriver driver, By locator){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        try {
            driver.findElement(locator);
            return true;
        }
        catch (NoSuchElementException e){
            return false;
        }

    }

    /**
     * This method will try to click on element multiple times
     * by ignoring StaleElementexception
     * @param driver to go to webpage
     * @param locator to click on
     * @param retries number of tris
     * @throws InterruptedException
     */


    public static void clickWithRetries(WebDriver driver, By locator,int retries) throws InterruptedException {
        int numOfRetries = 0;
        while (numOfRetries < retries){
            try {
                WebElement element = driver.findElement(locator);
                element.click();
                return; // it's successful , exit the method
            }
            catch (StaleElementReferenceException e) {
                //it's not successful, try again
                numOfRetries++;
                waitForSecond(1);
            }
            catch (NoSuchElementException e){
                System.out.println("wrong locator!");

            }
        }

        }



        public static void waitForSecond(int numOfSecond){
        try{
            Thread.sleep(numOfSecond*1000);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        }

}
