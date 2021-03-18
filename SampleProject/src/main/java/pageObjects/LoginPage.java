package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.BasePage;

public class LoginPage extends BasePage {


    private @FindBy(id = "email")
    WebElement emailTextBox;

    private @FindBy(id = "fld-password")
    WebElement passwordTextBox;

    private @FindBy(xpath = "//div[@class = 'grid-col-12 form-element']/ul/li")
    WebElement emailErrMessage;

    private @FindBy(xpath = "//div[@class = 'grid-col-12 form-element space-mvs']/ul/li")
    WebElement pwdErrMessage;

    private @FindBy(xpath = "//button[@class='btn-primary btn-full-width']")
    WebElement loginButton;

    public void enterEmail(String email) {
        utils.writeToWebElement(emailTextBox, email);
    }
    public void enterPassword(String password) {
        utils.writeToWebElement(passwordTextBox, password);
    }

    public String emailErrMsg()
    {
        return utils.getText(emailErrMessage);
    }
    public String pwdErrMsg()
    {
        return utils.getText(pwdErrMessage);
    }

    public void clickOnLoginButton()
    {
        utils.clickOnWebElement(driver, loginButton);
    }

    /*

    Your username or password is incorrect
Please enter a valid email address.
Too short. Please enter at least 6 characters.
     */
}
