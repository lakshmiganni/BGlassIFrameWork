package stepDefinitions;

import org.openqa.selenium.WebDriver;
import pageObjects.GumTreeHomePage;
import pageObjects.LoginPage;
import pageObjects.TrustPilotHomePage;
import utils.BrowserFactory;
import utils.ConfigFileReader;
import utils.StringHandler;
import utils.Utilities;

import java.util.Properties;

public class BaseStepDefs {


    public static Properties prop;
    public utils.Utilities utils;
    public static WebDriver driver;
    public utils.StringHandler stringHandler;


    public GumTreeHomePage gumTreeHomePage;
    public TrustPilotHomePage trustPilotHomePage;
    public LoginPage loginPage;


    public BaseStepDefs() {

        prop = ConfigFileReader.loadProperties();
        utils = new Utilities();
        driver = BrowserFactory.getDriver();
        stringHandler = new StringHandler();

        gumTreeHomePage = new GumTreeHomePage();
        trustPilotHomePage = new TrustPilotHomePage();
        loginPage = new LoginPage();

    }

}