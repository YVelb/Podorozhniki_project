package podorozhniki.epam.DriversTrips.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import podorozhniki.epam.DriversTrips.Driver.Driver;


/**
 * Created by Yana_Velbovets on 7/30/2014.
 */
public class MainPageAfterLogin {

    @FindBy(id = "my_trips")
    protected WebElement myTripsLink;

    public MainPageAfterLogin() {
        PageFactory.initElements(Driver.getInstance(), this);
    }

    public MyTripsPage goToMyTripsPage() {
        myTripsLink.click();
        return new MyTripsPage();
    }
}
