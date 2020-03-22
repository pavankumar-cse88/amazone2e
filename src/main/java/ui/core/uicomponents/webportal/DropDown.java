package ui.core.uicomponents.webportal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.core.uicomponents.contracts.Selectable;

import java.util.ArrayList;
import java.util.List;

public class DropDown implements Selectable {

    WebDriver driver;
    String dropDown;

    public DropDown(WebDriver driver, String dropDown){
        this.driver = driver;
        this.dropDown = dropDown;
    }
    @Override
    public void select(String value) {

    }

    @Override
    public List<String> getValues(String keyword) {
        List<String> suggestions = new ArrayList<>();
        try {
            List<WebElement> sug = getDropDown();
            for (WebElement suggestion:sug) {
                suggestions.add(suggestion.getAttribute("data-keyword"));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return suggestions;
    }

    public List<WebElement> getDropDown() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        //Thread.sleep(100);
        System.out.println("All suggestions list"+ dropDown);
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div#suggestions>div")));

    }
}
