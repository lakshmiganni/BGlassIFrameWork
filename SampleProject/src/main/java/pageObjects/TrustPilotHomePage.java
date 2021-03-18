package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.BasePage;

public class TrustPilotHomePage extends BasePage {


    private @FindBy(xpath = "//section[@class = 'header-section']/h2")
    WebElement reviewsElement;

    String trustPilotReviews;
    public String totalReviews()
    {
        return trustPilotReviews = reviewsElement.getText();
    }

}
