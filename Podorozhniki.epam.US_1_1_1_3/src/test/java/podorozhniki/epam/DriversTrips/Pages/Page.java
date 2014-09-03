package podorozhniki.epam.DriversTrips.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import podorozhniki.epam.DriversTrips.Driver.Driver;

/**
 * Created by Yana_Velbovets on 7/30/2014.
 */
public class Page {

    public Page waitForElementFindBy(WebElement element) {
        WebDriverWait wait = new WebDriverWait(Driver.getInstance(), 15, 1);
        wait.until(ExpectedConditions.visibilityOf(element));
        return this;
    }

}
