package pages.components.impl;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import pages.components.WebComponent;

public class SearchComponent extends WebComponent {

    public SearchComponent(WebElement rootElement) {
        super(rootElement);
    }

    public void performSearch(String searchPhrase){
        sendKeys(searchPhrase);
        sendKeys(Keys.ENTER);
    }
}
