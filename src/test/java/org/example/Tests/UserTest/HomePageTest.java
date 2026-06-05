package org.example.Tests.UserTest;

import org.example.Pages.UserPages.GuestDetailsPage;
import org.example.Pages.UserPages.HomePage;
import org.example.Pages.UserPages.PlaneSelectionPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class HomePageTest extends BaseTest {

    HomePage home;
    PlaneSelectionPage planeSelectionPage;
    GuestDetailsPage guestDetailsPage;

    //-----------------------------------------------------------------------------------
    //                                  Data Provider
    //-----------------------------------------------------------------------------------
    @DataProvider
    public Object[][] dataMethod(){
        return new Object[][]{
                {
                        "Saran@gmail.com",
                        "Saran@2004"
                }
        };
    }

    @DataProvider
    public Object[][] homeDataMethod(){
        return new Object[][]{
                {
                        "PREMIUM_ECONOMY",
                        "COK",
                        "DEL",
                        "06-06-2026"
                }
        };
    }

    @DataProvider
    public Object[][] guestDataMethod() {
        return new Object[][]{
                {"Virat", "Kohli", "38", "MALE", "9788376597"}
        };
    }


    //-----------------------------------------------------------------------------------
    //                                  Test methods
    //-----------------------------------------------------------------------------------


    @Test(dataProvider = "homeDataMethod", priority = 1)
    public void validation(String drop , String from , String to , String date){
        home = new HomePage(driver);
        home.setDrop(drop);
        home.setFrom(from);
        home.setTo(to);
        home.setDate(date);
        home.clickButton();
    }

    @Test(priority = 2)
    public void planeSelection() {
        planeSelectionPage = new PlaneSelectionPage(driver);
        planeSelectionPage.clickButton();
        planeSelectionPage.setSelectButton();
        planeSelectionPage.setContinueButton();

        planeSelectionPage.validate();
    }

    @Test(dataProvider = "guestDataMethod", priority = 3)
    public void guestDetails(String fName, String lName, String age, String gender, String passport) {
        guestDetailsPage = new GuestDetailsPage(driver);
        guestDetailsPage.setFirstName(fName);
        guestDetailsPage.setLastName(lName);
        guestDetailsPage.setAge(age);
        guestDetailsPage.setGender(gender);
        guestDetailsPage.setPassportNumber(passport);
        guestDetailsPage.clickSubmit();
        guestDetailsPage.clickConfirm();
    }

}
