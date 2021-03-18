package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.BasePage;

import java.io.IOException;

public class GumTreeHomePage extends BasePage {


    String gumTreeReviews;
    private @FindBy(xpath = "//div[@class='trustpilot-widget tp-carousel-widget']/iframe")
    WebElement trustPilotFrame;

    private @FindBy(xpath = "//strong[@class = 'bold-underline']")
    WebElement reviewsElement;

    private @FindBy(xpath = "//a[@class = 'button button--dark  css-1t5t3yv em7g81m3']")
    WebElement loginButton;




    public void scrollDownToReviews()
    {
        utils.waitForElementVisibility(driver,trustPilotFrame);
        utils.scrollToElement(driver,trustPilotFrame );
    }

    public String totalReviews()
    {
        driver.switchTo().frame(trustPilotFrame);
        return gumTreeReviews = reviewsElement.getText();
    }

   // String parentWindow;
    public void clickOnReviews() throws IOException {

        utils.clickOnWebElement(driver,reviewsElement);
    }
    public void clickOnLoginSignUp() {
        utils.clickOnWebElement(driver,loginButton);
    }

}
