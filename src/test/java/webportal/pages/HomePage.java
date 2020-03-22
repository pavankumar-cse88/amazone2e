package webportal.pages;

import jdk.internal.vm.compiler.collections.EconomicMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import ui.core.uicomponents.webportal.DropDown;
import ui.core.uicomponents.webportal.Element;
import ui.core.uicomponents.webportal.TextBox;

import java.util.List;

public class HomePage {
    private WebDriver driver;
    private Element element;
    private TextBox searchBarTextBox;
    private DropDown keywordSuggestionsDropDown;

    @FindBy(xpath = "//span[contains(text(),'Hello. Sign in')]")
    WebElement helloSignIn;

    @FindBy(xpath = "//div[@id='nav-tools']//a[@data-nav-role='signin']")
    WebElement singIn;

    @FindBy(css = "input#twotabsearchtextbox")
    WebElement searchBar;

    String keywordSuggestions = "div#suggestions-template>div>div";


    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        createInstanceForContracts();

    }

    public UserNamePage clickOnLogin() {
        try {
            element.mouseHoverAndClick(helloSignIn, singIn);
            return new UserNamePage(driver);
        }
        catch(Exception error){
            throw new RuntimeException("Error in clicking the Login Button"+ error.getMessage());
        }
    }

    public HomePage enterKeywordInSearchBar(String keyword) {
        try {
            searchBarTextBox.setText(keyword);
            return new HomePage(driver);
        }
        catch(Exception error) {
            throw new RuntimeException("Error getting chrome configurations." + error.getMessage());
        }
    }

    public List<String> getSuggestionsMatching(String keyword){
        try {
            return keywordSuggestionsDropDown.getValues(keyword);
        }
        catch(Exception error){
            throw new RuntimeException("Error getting search suggestions" + error.getMessage());
        }
    }

    private void createInstanceForContracts(){
        try {
            element = new Element(driver);
            searchBarTextBox = new TextBox(driver, searchBar);
            keywordSuggestionsDropDown = new DropDown(driver, keywordSuggestions);
        }
        catch(Exception error){
            throw new RuntimeException("Error in creating the instances for contracts" + error.getMessage());
        }
    }
}
