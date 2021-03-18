# BGlassIFrameWork


1. Handled Gumtree Trustpilot reviews which were in an IFrame and compared the results with the TrustPilot website reviews. 
2. Handled login feature with few invalid credentials to show one way of passing test data.


3. Integrating the tests with Jenkins


Following steps are involved in automating the scripts and integrating them Jenkins


1.	Write the test scenarios in Gherkin language using Cucumber tool and save it with “.feature” file extension.
2.   Generate the Step Definitions for the written feature file.
3.	Step Definitions are the java code files that maps each method with each line in the feature file.
4.	We’ll map the Feature file with the corresponding Step Definitions in the TestRunner class and is integrated with TestNG to run tests on different platforms and on different browsers.
5.	Once the test scripts successfully run locally, then we commit in the local repository (Git) and later push the code to GitHub.   
6.	By setting the Desired Capabilities we can run tests on different versions of operations systems and on different versions of browsers as follows:

DesiredCapabilities caps = new DeisredCapabilities();
caps.setCapablity(“browser”,””);
caps.setCapablity(“browser vesrion”,””);
caps.setCapablity(“os”,””);
caps.setCapablity(“os version”,””);
caps.setCapablity(“resolution”,””);

static WebDriver driver = new RemoteWebDriver(new URL(url), caps);

Here “url” is the URL of the browserstack url along with the username and key parameters of that particular account.

7.	Setting the Desired Capabilities is achieved by using Browser Stack.
8.	After having the Jenkins credentials, we create a new item in the Jenkins by giving the url of where actually the final code in GitHub and will Build. We can also set the properties to run daily at night. So that next day it’s easy for us to track all the tests run successfully or failed due to any errors.

