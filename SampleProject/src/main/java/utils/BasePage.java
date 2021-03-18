/**
 *
 */
package utils;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

//import pageObjects.*;

public abstract class BasePage {

    private static final int MAX_TIMEOUT = 60;

    public Utilities utils = new Utilities();


    //initialize webdriver
    public static WebDriver driver;

    //webdriver wait
    private static WebDriverWait waitDriver;

    public static Properties prop;
    public static Properties OR;

    //timeouts
    private final static int TIMEOUT = 60;
    private final static int PAGE_LOAD_TIMEOUT = 100;


    public BasePage() {

        driver = BrowserFactory.getDriver();
        PageFactory.initElements(driver, this);
        prop = ConfigFileReader.loadProperties();
        try {
            driver.manage().window().maximize();
            waitDriver = new WebDriverWait(driver, TIMEOUT);
            driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

        } catch (Exception exception) {

        }
    }

}
