package org.example.Tests.AdminTest;

import org.example.Pages.UserPages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class AdminBaseTest {
    protected static WebDriver driver;

    @BeforeSuite
    public void setUp() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("http://localhost:4200/");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername("natrajrakul@gmail.com");
        loginPage.setPassword("Rakul@2005");
        loginPage.clickButton();

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlContains("/admin"));
    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
