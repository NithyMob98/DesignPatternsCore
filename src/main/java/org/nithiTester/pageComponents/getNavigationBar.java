package org.nithiTester.pageComponents;

import org.nithiTester.abstractComponent.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class getNavigationBar extends AbstractComponent {
    By itemFlights = By.cssSelector("a[title='Flights']");
    By links = By.cssSelector("a");

    public getNavigationBar(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
    }

    public  String searchFlight(){
        return  findelement(itemFlights).getAttribute("class");
    }
    public int linksCount(){
       return findelements(links).size();
    }
}
