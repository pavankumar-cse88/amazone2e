package ui.core.uicomponents.webportal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.core.uicomponents.contracts.Clickable;

public class Button implements Clickable {

    WebDriver driver;
    private WebElement button;

    public Button(WebDriver driver, WebElement button) {
        this.driver = driver;
        this.button = button;
    }


    @Override
    public void click() throws Exception {
        getButton().click();

    }

    public WebElement getButton() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        return wait.until(ExpectedConditions.visibilityOf(button));

    }
}
