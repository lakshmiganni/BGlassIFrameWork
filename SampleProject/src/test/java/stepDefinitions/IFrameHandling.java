package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import utils.ConfigFileReader;

import java.io.IOException;

public class IFrameHandling extends BaseStepDefs{

    String totalReviews_gumTree;
    String totalReviews_trustPilot;
    String parentWindow;


    @Given("^I navigate to Gumtree homepage$")
    public void iNavigateToGumtreeHomepage() {

        driver.navigate().to(ConfigFileReader.getApplicationUrl());
    }

    @And("^reviews listed in Trustpilot should match with the reviews in the Gumtree website$")
    public void reviewsListedInTrustpilotShouldMatchWithTheReviewsInTheGumtreeWebsite() {

        Assert.assertEquals(stringHandler.subStringFirstSpace(totalReviews_gumTree),stringHandler.subStringFirstSpace(totalReviews_trustPilot) );
    }

    @When("^I scroll down to see the Trustpilot reviews$")
    public void iScrollDownToSeeTheTrustpilotReviews() {
        utils.waitForPageLoad(driver,60);
        gumTreeHomePage.scrollDownToReviews();
    }


    @Then("^I can see the reviews given by Trustpilot$")
    public void iCanSeeTheReviewsGivenByTrustpilot() {

        totalReviews_gumTree = (gumTreeHomePage.totalReviews()).trim();
        System.out.println("--- totalReviews_gumTree --- : "+totalReviews_gumTree);
       // System.out.println("--- totalReviews_gumTree index--- : "+totalReviews_gumTree.indexOf(" "));

    }

    @When("^I click on total reviews link$")
    public void iClickOnTotalReviewsLink() throws IOException {
        parentWindow = utils.getParentWindow(driver);
        gumTreeHomePage.clickOnReviews();
    }

    @Then("^A new trustpilot webpage is opened$")
    public void aNewTrustpilotWebpageIsOpened() throws IOException {

       String parent =  utils.openWindow(driver,parentWindow);
    }

    @Then("^I can see the total reviews in trustpilot website$")
    public void iCanSeeTheTotalReviewsInTrustpilotWebsite() {
        totalReviews_trustPilot = (trustPilotHomePage.totalReviews()).trim();

        System.out.println("--- totalReviews_trustPilot --- :"+totalReviews_trustPilot);
        driver.close();//closes the newly opened webpage
        driver.switchTo().window(parentWindow);//switching to the parent window
    }

}



