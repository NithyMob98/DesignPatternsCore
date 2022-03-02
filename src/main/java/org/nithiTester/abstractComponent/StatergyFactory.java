package org.nithiTester.abstractComponent;

import org.nithiTester.pageComponents.MultiTrip;
import org.nithiTester.pageComponents.RoundTrip;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StatergyFactory {
    WebDriver driver;
    By blockElement = By.id("flightSearchContainer");
    By blockElementM = By.id("content-change");

    public StatergyFactory(WebDriver driver){
        this.driver=driver;
    }


    public SearchFlightAvail createStatergy(String str){

        if(str.equalsIgnoreCase("multitrip")){
            return new MultiTrip(driver,blockElementM);

        }
        if(str.equalsIgnoreCase("roundtrip")){
            return new RoundTrip(driver,blockElement);
        }
        return null;

    }
}
