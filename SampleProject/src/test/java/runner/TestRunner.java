/**
 *
 */
package runner;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.BrowserFactory;
import utils.ConfigFileReader;
import utils.Utilities;

import java.util.Properties;


@CucumberOptions(

        features = {"src/test/java/features/"},
        glue = {"stepDefinitions"},
        monochrome = true,

        plugin = {"pretty", "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html",
                "json:target/cucumber.json"}
)
public class TestRunner extends AbstractTestNGCucumberTests {

    static Properties prop;



    @BeforeClass
    public static void setup() {
        prop = ConfigFileReader.loadProperties();
        BrowserFactory.getDriver();
    }

    @AfterClass
    public static void afterClass(){
        Utilities.loadReport();
        BrowserFactory.close();
    }

}
