package org.nithiTester.abstractComponent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public abstract class AbstractComponent {
    WebElement sectionElement;
    WebDriver driver;

    public AbstractComponent(WebDriver driver, By sectionElement) {
        this.driver=driver;
        this.sectionElement= driver.findElement(sectionElement);
    }
    public void waitForElementTDissappear(By webElement){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(webElement));
    }

    public WebElement findelement(By finelem){
       return sectionElement.findElement(finelem);
    }
    public List<WebElement> findelements(By finelem){
        return sectionElement.findElements(finelem);
    }

}
