
package utils;

import com.cucumber.listener.Reporter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public class Utilities {


    /********************Explicit Wait/Expected Conditions*******************************/

    public void waitForElementPresence(WebDriver driver, By element) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(element));
        } catch (Exception e) {

            e.printStackTrace();

            Assert.assertFalse(false, "Failed the test - " + e.getMessage());
        }
    }


    public void waitForElementVisibility(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        try {
            wait.until(ExpectedConditions.visibilityOf(element));

        } catch (Exception e) {

            e.printStackTrace();

            Assert.assertFalse(false, "Failed the test - " + e.getMessage());
        }
    }


    public void waitForElementClickable(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        try {

            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {

            e.printStackTrace();

            Assert.assertFalse(false, "Failed the test - " + e.getMessage());
        }
    }



    public static void waitForPageLoad(WebDriver driver, int i) {

        driver.manage().timeouts().pageLoadTimeout(i, TimeUnit.SECONDS);

    }

    public void clickOnWebElement(WebDriver driver, WebElement element) {
        try {
            waitForElementClickable(driver, element);
            element.click();
        } catch (Exception e) {
            Assert.fail("Element not clickable" + element);
        }
    }
    public void writeToWebElement(WebElement element, String text) {
        element.sendKeys(text);
    }

    public static String getText(WebElement element)
    {
        return element.getText();
    }

    public WebElement getElement(WebDriver driver, By by) throws Exception {
        List<WebElement> elements = driver.findElements(by);
        if (elements.size() == 0) {
            throw new Exception("Given element not present");
        } else {
            return elements.get(0);
        }

    }

    public List<WebElement> getElements(WebDriver driver, By by) throws Exception {
        List<WebElement> elements = driver.findElements(by);
        if (elements.size() == 0) {
            throw new Exception("Given element not present");
        } else {
            return elements;
        }

    }

   public static void loadReport() {
      // Loads the extent config xml to customize on the report.

       Reporter.loadXMLConfig(ConfigFileReader.getReportConfigPath());
   }

    static String parentWindow;
    public static String getParentWindow(WebDriver driver)
    {
        return parentWindow = driver.getWindowHandle(); // Save parent window
    }


    public static String openWindow(WebDriver driver, String parentHandle) throws IOException {
       // parentHandle = getParentWindow(driver); // Save parent window

       // element.click(); // Open child window
        WebDriverWait wait = new WebDriverWait(driver, 30); // Timeout in 10s

        boolean isChildWindowOpen = wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        if (isChildWindowOpen) {
            Set<String> handles = driver.getWindowHandles();
            // Switch to child window
            for (String handle : handles) {
                driver.switchTo().window(handle);
                if (!parentHandle.equals(handle)) {
                    break;
                }
            }
            driver.manage().window().maximize();
        }
        return parentHandle; // Returns parent window if need to switch back
    }

    public void scrollToElement(WebDriver driver, WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", element);
    }



}

