package org.nithiTester.pageComponents;

import org.nithiTester.abstractComponent.AbstractComponent;
import org.nithiTester.abstractComponent.SearchFlightAvail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.function.Consumer;

public class RoundTrip extends AbstractComponent implements SearchFlightAvail {

     private By radioButoon =By.id("ctl00_mainContent_rbtnl_Trip_1");
     private By checkBox =By.id("ctl00_mainContent_chk_IndArm");
     private By defDate = By.cssSelector("table[class='ui-datepicker-calendar'] td[class*='ui-datepicker-today'] a");

     private By fromOrigin = By.id("ctl00_mainContent_ddl_originStation1_CTXT");
     private By toDestn = By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");
     private By seachButton = By.cssSelector("input[id='ctl00_mainContent_btn_FindFlights']");

    public RoundTrip(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
    }



    @Override
    public void checkAvail(HashMap<String,String> reservationDetails) {

        makeStateReady(s->selectOriginStation(reservationDetails.get("origin")));
        selectDestnStation(reservationDetails.get("destination"));
        clickCheckBox();
        clickSearch();
    }

    public void clickRadioButtion(){
        findelement(radioButoon).click();
    }

    public void clickCheckBox(){
        findelement(checkBox).click();
    }
    public void selectOriginStation(String origin){
        findelement(fromOrigin).click();
        By originStation = By.cssSelector("div[id='ctl00_mainContent_ddl_originStation1_CTNR'] a[value='"+origin+"']");
        findelement(originStation).click();
    }
    public void selectDestnStation(String destn){
        findelement(toDestn).click();
        By destnStation = By.cssSelector("div[id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] a[value='"+destn+"']");
        findelement(destnStation).click();
    }
    public void clickSearch(){
        findelement(seachButton).click();

    }
    public void makeStateReady(Consumer<RoundTrip> consumer){
        System.out.println("In round trip");
        clickRadioButtion();
        consumer.accept(this);
        System.out.println("Round trip make ready state done");


    }



}
