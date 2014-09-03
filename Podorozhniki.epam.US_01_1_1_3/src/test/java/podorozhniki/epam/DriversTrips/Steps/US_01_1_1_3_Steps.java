package podorozhniki.epam.DriversTrips.Steps;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import podorozhniki.epam.DriversTrips.Driver.Driver;
import podorozhniki.epam.DriversTrips.Pages.MainPageAfterLogin;
import podorozhniki.epam.DriversTrips.Pages.MainPageBeforeLogin;
import podorozhniki.epam.DriversTrips.Pages.MyTripsPage;

import static org.junit.Assert.assertEquals;

/**
 * Created by Yana_Velbovets on 7/30/2014.
 */
public class US_01_1_1_3_Steps {

    private String query = "SELECT " +
            "trip.id_trip, " +
            "trip.id_person " +
            "FROM " +
            "public.trip " +
            "where id_person=233 ";
    private String driverLoginName = "Driver";
    private String driverLoginPassword = "123";

    private MainPageAfterLogin mainPageAfterLogin;
    private MainPageBeforeLogin mainPageBeforeLogin;
    private MyTripsPage myTripsPage;
    private int ammOfTripsDB;
    private int ammOfTripsPage;

    @Before
    public void driver() {
        Driver.init();
        Driver.getInstance().manage().window().maximize();
        Driver.getInstance().get("http://evbyminsd7238.minsk.epam.com:8080/pdrzh/main");
    }

    @After
    public void closeBrowser() {
        Driver.tearDown();
    }

    @Test
    public void checkAmountOfTrips() {
        mainPageBeforeLogin = new MainPageBeforeLogin();
        mainPageBeforeLogin.assertFieldsArePresent();
        mainPageBeforeLogin.enterLoginAndPass(driverLoginName, driverLoginPassword);
        mainPageAfterLogin = mainPageBeforeLogin.pressTheLoginButton();
        myTripsPage = mainPageAfterLogin.goToMyTripsPage();
        myTripsPage.gotoAsDriverTab();
        try {
            ammOfTripsDB = myTripsPage.countAmountOfTripsnDB(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ammOfTripsPage = myTripsPage.countTripsOnThePage();
        assertEquals(ammOfTripsDB, ammOfTripsPage);
    }
}
