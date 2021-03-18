package utils;

import enums.DriverType;
import enums.EnvironmentType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BrowserFactory {

    private static final int MAX_TIMEOUT = 90;

    static WebDriver driver;
    private static DriverType driverType;
    private static EnvironmentType environmentType;


    public static WebDriver getDriver() {
        if(driver == null){
            return selectDriverInstance();
        }
        return driver;
    }

    private static WebDriver selectDriverInstance() {
        environmentType = ConfigFileReader.getEnvironment();

        switch (environmentType) {
            case LOCAL : driver = createDriverInstance();
                break;
            case REMOTE : driver = createRemoteDriver();
                break;
        }
        return driver;
    }

    private static WebDriver createRemoteDriver() {
        throw new RuntimeException("RemoteWebDriver is not yet implemented");
    }

    private static WebDriver createDriverInstance() {

        String Browser = ConfigFileReader.getBrowser();
        if (Browser.equalsIgnoreCase("CHROME")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (Browser.equalsIgnoreCase("FIREFOX")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (Browser.equalsIgnoreCase("SAFARI")) {
            driver = new SafariDriver();
        }

        driver.manage().timeouts().implicitlyWait(MAX_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().window().maximize();


        return driver;
    }


    public static void close() {
        driver.quit();
        driver = null;
    }
}

