package org.nithiTester;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DemoTest extends BaseTest{
    WebDriver driver;

    @BeforeTest
    public void setUp(){
        driver = initDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }

    @Test(dataProvider="getData")
    public void flightTEst(HashMap<String,String> reservationDetails){


        TravelHomePage homePage = new TravelHomePage(driver);
        homePage.goToHomePage();
        System.out.println(homePage.getNavigationBar().searchFlight());
        System.out.println(homePage.getNavigationBar().linksCount());

        System.out.println(homePage.getFooterNav().searchFlight());
        System.out.println(homePage.getFooterNav().linksCount());
        // homePage.setBookingStatergy(new RoundTrip(driver,blockElement));


        homePage.setBookingStatergy("multitrip");
        homePage.checkAvailibility(reservationDetails);
        System.out.println("multi done da");

        homePage.setBookingStatergy("roundtrip");
        homePage.checkAvailibility(reservationDetails);
    }



    @DataProvider
    public Object[][] getData() throws IOException {
   List<HashMap<String,String>> l =  getJsonData(System.getProperty("user.dir")+"//src//test//java//org//nithiTester//reservationDetails.json");

    return new Object[][]{
            {l.get(0)},{l.get(1)}

        };

    }


/*
        @DataProvider
    public Object[][] getData2(){
        HashMap<String,String> reservationDetails = new HashMap<String,String>();
        reservationDetails.put("origin","MAA");
        reservationDetails.put("destination","JAI");
        reservationDetails.put("origin1","MAA");
        reservationDetails.put("destination1","JAI");
        reservationDetails.put("origin2","JAI");
        reservationDetails.put("destination2","HYD");
        reservationDetails.put("origin3","HYD");
        reservationDetails.put("destination3","MAA");

        HashMap<String,String> reservationDetails2 = new HashMap<String,String>();
        reservationDetails2.put("origin","JAI");
        reservationDetails2.put("destination","HYD");
        reservationDetails2.put("origin1","JAI");
        reservationDetails2.put("destination1","MAA");
        reservationDetails2.put("origin2","JAI");
        reservationDetails2.put("destination2","HYD");
        reservationDetails2.put("origin3","HYD");
        reservationDetails2.put("destination3","MAA");
        List<HashMap<String,String>> l = new ArrayList<HashMap<String,String>>();
        l.add(reservationDetails);
        l.add(reservationDetails2);

         return new Object[][]{
                 {l.get(0)},{l.get(1)}
         };

    }*/
}
