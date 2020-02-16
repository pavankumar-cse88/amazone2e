package webportal.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ui.core.uicomponents.webportal.Button;
import ui.core.uicomponents.webportal.TextBox;

public class UserNamePage {

     WebDriver driver;
     TextBox userNameTextBox;
     Button userNamePageContinueButton;

    UserNamePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        userNameTextBox = new TextBox(this.driver,"name","email");
        userNamePageContinueButton = new Button(this.driver,"continue","id");

    }

    public PasswordPage setUserNameAndClickContinue(String userName) throws Exception {
        userNameTextBox.setText(userName);
        userNamePageContinueButton.click();
        return new PasswordPage(driver);
    }




}
