package webportal.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui.core.uicomponents.webportal.Element;

public class HomePage {
    private WebDriver driver;
    private Element element;

    @FindBy(xpath = "//span[contains(text(),'Hello. Sign in')]")
    WebElement helloSignIn;

    @FindBy(xpath = "//div[@id='nav-tools']//a[@data-nav-role='signin']")
    WebElement singIn;

    public HomePage(WebDriver driver){
        this.driver = driver;
        element = new Element(driver);
        PageFactory.initElements(driver, this);
    }

    public UserNamePage clickOnLogin() {
        element.mouseHoverAndClick(helloSignIn, singIn);
        return new UserNamePage(driver);


    }
}
