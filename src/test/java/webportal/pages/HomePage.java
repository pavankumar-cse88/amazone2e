package webportal.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[contains(text(),'Hello. Sign in')]")
    WebElement helloSignIn;

    @FindBy(xpath = "//div[@id='nav-tools']//a[@data-nav-role='signin']")
    WebElement singInButton;

     public UserNamePage clickOnLogin(){
        Actions actions = new Actions(driver);
        actions.moveToElement(helloSignIn).build().perform();
        actions.moveToElement(singInButton).click().build().perform();
        return new UserNamePage(driver);


    }





}
