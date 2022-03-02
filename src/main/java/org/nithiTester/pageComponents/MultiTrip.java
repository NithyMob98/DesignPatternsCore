package org.nithiTester.pageComponents;

import org.nithiTester.abstractComponent.AbstractComponent;
import org.nithiTester.abstractComponent.SearchFlightAvail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.function.Consumer;

public class MultiTrip extends AbstractComponent implements SearchFlightAvail {
    private By iconMutlticity = By.cssSelector("input[id='ctl00_mainContent_rbtnl_Trip_2']");
    private By popMulticity = By.cssSelector("a[id='MultiCityModelAlert']");

    private By fromOrigin = By.id("ctl00_mainContent_ddl_originStation1_CTXT");
    private By toDestn = By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");

    private By fromOrigin2 = By.id("ctl00_mainContent_ddl_originStation2_CTXT");
    private By toDestn2 = By.id("ctl00_mainContent_ddl_destinationStation2_CTXT");
    private By fromOrigin3 = By.id("ctl00_mainContent_ddl_originStation3_CTXT");
    private By toDestn3 = By.id("ctl00_mainContent_ddl_destinationStation3_CTXT");


    private By chkBox = By.id("ctl00_mainContent_SeniorCitizenDiv");
    private By seachButton = By.cssSelector("input[id='ctl00_mainContent_btn_FindFlights']");



    public MultiTrip(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
    }

    @Override
    public void checkAvail(HashMap<String,String> reservationDetails) {
        makeStateReady(s->selectOriginStation1(reservationDetails.get("origin1"))); //after the PreReq is done then it will go and select origin
        selectDestnStation1(reservationDetails.get("destination1"));
        selectOriginStation2(reservationDetails.get("origin2"));
        selectDestnStation2(reservationDetails.get("destination2"));
        selectCheckBox();
        selectOriginStation3(reservationDetails.get("origin3"));
        selectDestnStation3(reservationDetails.get("destination3"));
        selectCheckBox();
        clickSearch();



    }
    public void clickMulticityIcon(){
    findelement(iconMutlticity).click();
        findelement(popMulticity).click();
        waitForElementTDissappear(popMulticity);
    }
    public void selectOriginStation1(String origin){
        findelement(fromOrigin).click();
        By originStation = By.cssSelector("div[id='ctl00_mainContent_ddl_originStation1_CTNR'] a[value='"+origin+"']");
        findelement(originStation).click();
    }
    public void selectDestnStation1(String destn){
        findelement(toDestn).click();
        By destnStation = By.cssSelector("div[id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] a[value='"+destn+"']");
        findelement(destnStation).click();
    }
    public void selectOriginStation2(String origin){
        findelement(fromOrigin2).click();
        By originStation = By.cssSelector("div[id='ctl00_mainContent_ddl_originStation2_CTNR'] a[value='"+origin+"']");
        findelement(originStation).click();
    }
    public void selectDestnStation2(String destn){
        findelement(toDestn2).click();
        By destnStation = By.cssSelector("div[id='glsctl00_mainContent_ddl_destinationStation2_CTNR'] a[value='"+destn+"']");
        findelement(destnStation).click();

    }
    public void selectOriginStation3(String origin){
        findelement(fromOrigin3).click();
        By originStation = By.cssSelector("div[id='ctl00_mainContent_ddl_originStation3_CTNR'] a[value='"+origin+"']");
        findelement(originStation).click();
    }
    public void selectDestnStation3(String destn){
        findelement(toDestn3).click();
        By destnStation = By.cssSelector("div[id='glsctl00_mainContent_ddl_destinationStation3_CTNR'] a[value='"+destn+"']");
        findelement(destnStation).click();

    }
    public void selectCheckBox(){
        findelement(chkBox).click();
    }
    public void clickSearch(){
        findelement(seachButton).click();
    }

    public void makeStateReady(Consumer<MultiTrip> consumer){
        System.out.println("im in multitrip da");

        clickMulticityIcon();
        consumer.accept(this);  // will run the fn here only after the prerequiste is done
        System.out.println("make ready state exited");


    }



}

