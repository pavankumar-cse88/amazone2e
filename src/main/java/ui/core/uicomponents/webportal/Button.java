package ui.core.uicomponents.webportal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.core.uicomponents.contracts.Clickable;
import ui.core.uicomponents.utilities.ElementLocator;

public class Button implements Clickable {

    WebDriver driver;
    String textBoxLocatorValue;
    String textBoxLocatorType;
    ElementLocator elementLocator =  new ElementLocator();


    public Button(WebDriver driver,String textBoxLocatorValue,String textBoxLocatorType){
        this.driver = driver;
        this.textBoxLocatorValue = textBoxLocatorValue;
        this.textBoxLocatorType = textBoxLocatorType;

    }

    @Override
    public void click() throws Exception {
        getButton().click();

    }

    public WebElement getButton() throws Exception {
        By locator = elementLocator.getElement(textBoxLocatorType,textBoxLocatorValue);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));

    }
}
