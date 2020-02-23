package ui.core.uicomponents.utilities;

import org.openqa.selenium.By;

public class ElementLocator {

    public By getElement(String locatorType, String locatorValue) throws Exception {

        if(locatorType.equals("id"))
            return By.id(locatorValue);
        else if(locatorType.equals("name"))
            return By.name(locatorValue);
        else if(locatorType.equals("xpath"))
            return By.xpath(locatorValue);
        else
            throw new Exception("Not valid Locator"+locatorType);
    }
}
