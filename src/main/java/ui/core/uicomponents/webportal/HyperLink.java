package ui.core.uicomponents.webportal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.core.uicomponents.contracts.Clickable;
import ui.core.uicomponents.contracts.Gettable;
import ui.core.uicomponents.utilities.ElementLocator;

public class HyperLink implements Clickable, Gettable {

    private WebDriver driver;
    private String hyperLinkLocatorValue;
    private String hyperLinkLocatorType;
    private ElementLocator elementLocator =  new ElementLocator();

    public HyperLink(WebDriver driver, String hyperLinkLocatorValue, String hyperLinkLocatorType){
        this.driver = driver;
        this.hyperLinkLocatorValue= hyperLinkLocatorValue;
        this.hyperLinkLocatorType= hyperLinkLocatorType;

    }
    @Override
    public void click() throws Exception {
        getHyperLink().click();

    }

    @Override
    public String getText(String attributeName) {
        return null;
    }

    public WebElement getHyperLink() throws Exception {

        By locator = elementLocator.getElement(hyperLinkLocatorType,hyperLinkLocatorValue);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));

    }

}
