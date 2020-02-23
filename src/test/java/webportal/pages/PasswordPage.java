package webportal.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui.core.uicomponents.webportal.Button;
import ui.core.uicomponents.webportal.TextBox;

public class PasswordPage {

    private WebDriver driver;
    private TextBox passwordTextBox;
    private Button continueSignInButton;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(id = "signInSubmit" )
    WebElement continueSinIn;


    PasswordPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
        passwordTextBox =  new TextBox(driver,password);
        continueSignInButton = new Button(driver,continueSinIn);

    }
    public void enterPasswordAndClickOnLoginButton(String password) throws Exception {
        passwordTextBox.setText(password);
        continueSignInButton.click();

    }
}
