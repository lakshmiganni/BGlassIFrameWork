package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

public class LoginSteps extends BaseStepDefs {

    @When("^I click on Login/SinUp button$")
    public void iClickOnLoginSinUpButton() {
        gumTreeHomePage.clickOnLoginSignUp();
    }

    @Then("^I enter Email as \"([^\"]*)\"$")
    public void iEnterEmailAs(String email) throws Throwable {
       loginPage.enterEmail(email);
    }

    @And("^I enter Password as \"([^\"]*)\"$")
    public void iEnterPasswordAs(String password) throws Throwable {
        loginPage.enterPassword(password);
    }

    @Then("^I get the email error message as \"([^\"]*)\"$")
    public void iGetTheEmailErrorMessageAs(String emailErrMsg) throws Throwable {
        String actualEmailErrMsg = loginPage.emailErrMsg();
        System.out.println("---- actualEmailErrMsg ----:"+actualEmailErrMsg);

        Assert.assertEquals(actualEmailErrMsg,emailErrMsg);

    }

    @And("^Password error message as \"([^\"]*)\"$")
    public void passwordErrorMessageAs(String pwdErrMsg) throws Throwable {
        String actualPwdErrMsg = loginPage.pwdErrMsg();
        System.out.println("---- actualPwdErrMsg ----:"+actualPwdErrMsg);
        Assert.assertEquals(actualPwdErrMsg,pwdErrMsg);

    }

    @When("^I click on Login button$")
        public void iClickOnLoginButton() {
        loginPage.clickOnLoginButton();
        }
}
