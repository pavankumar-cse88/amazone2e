package webportal.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui.core.uicomponents.webportal.Button;
import ui.core.uicomponents.webportal.TextBox;

public class UserNamePage {

     private WebDriver driver;
     private TextBox userNameTextBox;
     private Button userNamePageContinueButton;

     @FindBy(name = "email")
     WebElement emailTextBox;


     @FindBy(id="continue")
     WebElement continueButton;


    UserNamePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        userNameTextBox = new TextBox(this.driver,emailTextBox);
        userNamePageContinueButton = new Button(this.driver,continueButton);

    }

    public PasswordPage setUserNameAndClickContinue(String userName) throws Exception {
        userNameTextBox.setText(userName);
        userNamePageContinueButton.click();
        return new PasswordPage(driver);
    }




}
