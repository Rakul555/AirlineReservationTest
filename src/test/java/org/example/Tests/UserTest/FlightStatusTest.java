package org.example.Tests.UserTest;

import org.example.Pages.UserPages.FlightStatusPage;
import org.example.Pages.UserPages.HomePage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FlightStatusTest extends BaseTest {
    HomePage homePage;
    FlightStatusPage flightStatusPage;

    @DataProvider
    public Object[][] setFlightData(){
        return new Object[][]{
                {"DA 555","06-06-2026"}
        };
    }

    @Test(dataProvider = "setFlightData")
    public void flightStatusCheck(String flightNo,String date){
        homePage = new HomePage(driver);
        flightStatusPage = new FlightStatusPage(driver);
        homePage.setFlightStatusPage();
        flightStatusPage.setFightNumber(flightNo);
        flightStatusPage.setDateElement(date);
        flightStatusPage.setSubmitButton();
        flightStatusPage.setVerificationText(flightNo);
    }
}
