package podorozhniki.epam.DriversTrips.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import podorozhniki.epam.DriversTrips.Driver.DBConnection;
import podorozhniki.epam.DriversTrips.Driver.Driver;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Yana_Velbovets on 7/30/2014.
 */
public class MyTripsPage extends DBConnection {

    protected int numFromPage;

    @FindBy(xpath = "//li[@id='li_driver']/a")
    protected WebElement asDriverTab;

    private By details_button = By.xpath("//a[contains(text(),'Details')]");

    public MyTripsPage() {
        PageFactory.initElements(Driver.getInstance(), this);
    }

    public void gotoAsDriverTab() {
        asDriverTab.click();
    }

    public int countAmountOfTripsnDB(String query) throws SQLException {
       int count = 0;
        ResultSet rs = null;
        rs = queryExecutor(query);
        while (rs.next()){
            count++;
        }
        System.out.println("Amount of lines in the table " + count);
        return count;
    }

    // count trips on the page
    public int countTripsOnThePage() {
        List<WebElement> buttonJoins = Driver.getInstance().findElements(details_button);
        int numElem = buttonJoins.size();
        if (numElem == 0) {
            // log.error("Preconditions are wrong: there is no trip");
            System.out.println("There are no trip on the page");
        } else {
            numFromPage = 0;
            try {
                buttonJoins = Driver.getInstance().findElements(details_button);
                numFromPage = numFromPage + buttonJoins.size();
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        }
        // log.info("there are " + numFromPage + " trips on the main page");
        System.out.println("There are " + numFromPage
                + " trips on the main page");
        return numFromPage;
    }

}
