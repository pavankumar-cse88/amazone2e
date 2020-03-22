package ui.core.uicomponents.webportal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.core.uicomponents.contracts.Clickable;
import ui.core.uicomponents.contracts.Gettable;

public class HyperLink implements Clickable, Gettable {

    private WebDriver driver;
    WebElement hyperLink;

    public HyperLink(WebDriver driver, WebElement hyperLink){
        this.driver = driver;
        this.hyperLink = hyperLink;

    }
    @Override
    public void click() {
        getHyperLink().click();

    }

    @Override
    public String getText(String attributeName) {
        return null;
    }

    public WebElement getHyperLink() {

        WebDriverWait wait = new WebDriverWait(driver, 5);
        return wait.until(ExpectedConditions.visibilityOf(hyperLink));

    }
}
