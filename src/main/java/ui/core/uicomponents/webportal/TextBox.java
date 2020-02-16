package ui.core.uicomponents.webportal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.core.uicomponents.contracts.Gettable;
import ui.core.uicomponents.contracts.Settable;

import org.openqa.selenium.By;
import ui.core.uicomponents.utilities.ElementLocator;

public class TextBox implements Settable, Gettable {
    private String textBoxLocatorValue;
    private String textBoxLocatorType;
    private WebDriver driver;
    ElementLocator elementLocator =  new ElementLocator();

    public TextBox(WebDriver driver, String textBoxLocatorType,String textBoxLocatorValue){
        this.driver = driver;
        this.textBoxLocatorValue = textBoxLocatorValue;
        this.textBoxLocatorType = textBoxLocatorType;

    }

    @Override
    public String getText(String attributeName) {
        return null;
    }

    @Override
    public void setText(String text) throws Exception {
     getTextBox().sendKeys(text);

    }

    WebElement getTextBox() throws Exception {
        By locator = elementLocator.getElement(textBoxLocatorType, textBoxLocatorValue);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));

    }

}
