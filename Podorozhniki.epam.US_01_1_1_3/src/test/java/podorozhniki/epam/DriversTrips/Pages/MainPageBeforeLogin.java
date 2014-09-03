package podorozhniki.epam.DriversTrips.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import podorozhniki.epam.DriversTrips.Driver.Driver;

import static org.junit.Assert.assertTrue;
/**
 * Created by Yana_Velbovets on 7/30/2014.
 */
public class MainPageBeforeLogin {

    @FindBy(id = "inputUsername")
    private WebElement UsernameField;

    @FindBy(id = "inputPassw")
    private WebElement PassField;

    @FindBy(xpath = "//button[@name='submit']")
    private WebElement SubmitBtn;

    @FindBy(xpath = "//a[@class='btn btn-default']")
    private WebElement logoutButton;

    public MainPageBeforeLogin() {
        PageFactory.initElements(Driver.getInstance(), this);
    }

    public void assertFieldsArePresent() {
        assertTrue(UsernameField.isDisplayed());
        assertTrue(PassField.isDisplayed());
        assertTrue(SubmitBtn.isDisplayed());
    }

    public void enterLoginAndPass(String login, String password) {
        UsernameField.clear();
        UsernameField.sendKeys(login);
        PassField.clear();
        PassField.sendKeys(password);
    }

    public MainPageAfterLogin pressTheLoginButton() {
        SubmitBtn.click();
        //waitForElementPresent(logoutButton);
        return new MainPageAfterLogin();
    }

}
