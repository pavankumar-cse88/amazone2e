package webportal.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ui.core.uicomponents.webportal.Button;
import ui.core.uicomponents.webportal.TextBox;

public class PasswordPage {

    private WebDriver driver;
    TextBox passwordTextBox;
    Button continueButton;
    public PasswordPage(WebDriver driver){
        this.driver=driver;
        passwordTextBox = new  TextBox(driver,"name","password");
        continueButton = new Button(driver,"signInSubmit","id");

    }

    public void enterPasswordAndClickOnLoginButton(String password) throws Exception {
        passwordTextBox.setText(password);
        continueButton.click();

    }
}
