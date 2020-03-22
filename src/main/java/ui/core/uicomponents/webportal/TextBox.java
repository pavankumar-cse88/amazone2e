package ui.core.uicomponents.webportal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.core.uicomponents.contracts.Gettable;
import ui.core.uicomponents.contracts.Settable;

public class TextBox implements Settable, Gettable {

    private WebDriver driver;
    private WebElement textBox;

    public TextBox(WebDriver driver, WebElement textBox) {
        this.driver = driver;
        this.textBox = textBox;

    }

    @Override
    public String getText(String attributeName) {
        return null;
    }

    @Override
    public void setText(String text) {
     getTextBox().sendKeys(text);

    }

    private WebElement getTextBox() {
        WebDriverWait wait = new WebDriverWait(driver, 25);
        return wait.until(ExpectedConditions.visibilityOf(textBox));

    }

}
