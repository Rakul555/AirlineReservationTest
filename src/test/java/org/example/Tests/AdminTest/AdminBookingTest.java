package org.example.Tests.AdminTest;

import org.example.Pages.AdminPages.AdminBooking;
import org.testng.annotations.Test;



public class AdminBookingTest extends AdminBaseTest {

    AdminBooking adminBooking;

    @Test
    public void bookingValidation(){
        adminBooking = new AdminBooking(driver);
        adminBooking.setNavElement();
        adminBooking.setViewPassengersClick();
        adminBooking.setBookingCheck();
    }
}
