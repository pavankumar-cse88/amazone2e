package webportal.pages;

import constants.LocatorTypes;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import ui.core.uicomponents.webportal.Button;
import ui.core.uicomponents.webportal.HyperLink;

public class HomePage {
    private WebDriver driver;
    private HyperLink helloSignInHyperLink;
    private Button singInButton;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        helloSignInHyperLink = new HyperLink(driver,
                "//span[contains(text(),'Hello. Sign in')]", LocatorTypes.xpath);
        singInButton = new Button(driver,
                "//div[@id='nav-tools']//a[@data-nav-role='signin']",LocatorTypes.xpath);

    }
     public UserNamePage clickOnLogin() throws Exception {
        Actions actions = new Actions(driver);
        actions.moveToElement(helloSignInHyperLink.getHyperLink()).build().perform();
        actions.moveToElement(singInButton.getButton()).click().build().perform();
        return new UserNamePage(driver);


    }





}
