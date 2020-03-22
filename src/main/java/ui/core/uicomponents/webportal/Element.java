package ui.core.uicomponents.webportal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import ui.core.uicomponents.contracts.Hoverable;

public class Element implements Hoverable {

    private WebElement element;
    private WebElement clickOn;
    WebDriver driver;

    public Element(WebDriver driver,WebElement element){

        this.driver = driver;
        this.element = element;

    }

    public Element(WebDriver driver){
        this.driver = driver;
    }

    @Override
    public void mouseHoverAndClick(WebElement hoverOn, WebElement clickOn) {
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverOn).build().perform();
        actions.moveToElement(clickOn).click().build().perform();
    }
}
