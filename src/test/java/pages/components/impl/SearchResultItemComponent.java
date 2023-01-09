package pages.components.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.components.WebComponent;

public class SearchResultItemComponent extends WebComponent {

    private static final By TITLE_SELECTOR = By.cssSelector(".v-align-middle");
    private static final By DESCRIPTION_SELECTOR = By.cssSelector(".mb-1");

    public SearchResultItemComponent(WebElement rootElement) {
        super(rootElement);
    }

    public boolean containsSearchPhrase(String searchPhrase){
        return containsSearchPhraseIgnoringCase(searchPhrase, TITLE_SELECTOR) || containsSearchPhraseIgnoringCase(searchPhrase, DESCRIPTION_SELECTOR);
    }

    private boolean containsSearchPhraseIgnoringCase(String searchPhrase, By selector) {
        return findElement(selector).getText().toLowerCase().contains(searchPhrase);
    }

}
