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
        createInstanceForContracts();
     }

     public PasswordPage setUserNameAndClickContinue(String userName) {
         try {
             userNameTextBox.setText(userName);
             userNamePageContinueButton.click();
             return new PasswordPage(driver);
         }
         catch(Exception error){
             throw new RuntimeException("Error in navigating to password page" + error.getMessage());
         }
     }

     void createInstanceForContracts(){
         try {
             userNameTextBox = new TextBox(this.driver, emailTextBox);
             userNamePageContinueButton = new Button(this.driver, continueButton);
         }
         catch(Exception error){
             throw new RuntimeException("Error in creating instances" + error.getMessage());
         }
     }
}
