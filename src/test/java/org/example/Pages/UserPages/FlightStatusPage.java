package org.example.Pages.UserPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class FlightStatusPage {
    WebDriver driver;

    public FlightStatusPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@formcontrolname='flightNumber']")
    WebElement fightNumber;

    @FindBy(xpath = "//input[@formcontrolname='date']")
    WebElement dateElement;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitButton;

    @FindBy(xpath = "//div[@class='flight-no-big']")
    WebElement verificationText;

    public void setFightNumber(String flightNo){
        fightNumber.sendKeys(flightNo);
    }

    public void setDateElement(String date){
        dateElement.sendKeys(date);
    }

    public void setSubmitButton(){
        submitButton.click();
    }

    public void setVerificationText(String flightNo){
        Assert.assertEquals(verificationText.getText().toLowerCase(),flightNo.toLowerCase());
    }


}
