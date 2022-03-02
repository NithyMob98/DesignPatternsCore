package org.nithiTester;

import org.nithiTester.abstractComponent.SearchFlightAvail;
import org.nithiTester.abstractComponent.StatergyFactory;
import org.nithiTester.pageComponents.getFooterNav;
import org.nithiTester.pageComponents.getNavigationBar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class TravelHomePage {
    //responsibility is to rediect to othe class
    SearchFlightAvail searchFlightAvail;
    WebDriver driver;
    By sectionFooterElement = By.id("traveller-home");
    By sectionNavigationElement = By.id("buttons");


    public TravelHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToHomePage() {
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
    }

    public void closeAll() {
        driver.quit();
    }

    public getNavigationBar getNavigationBar() {
        return new getNavigationBar(driver, sectionNavigationElement);
    }

    public getFooterNav getFooterNav() {
        return new getFooterNav(driver, sectionFooterElement);

    }
    public void setBookingStatergy(String str){
        System.out.println("Lastest code da");
        StatergyFactory stf = new StatergyFactory(driver);
        searchFlightAvail=stf.createStatergy(str);

        this.searchFlightAvail=searchFlightAvail;

    }
    public void checkAvailibility(HashMap<String,String> reservationDetails){
        searchFlightAvail.checkAvail(reservationDetails);

    }
    public String getPagetitle(){
      return   driver.getTitle();
    }
}
