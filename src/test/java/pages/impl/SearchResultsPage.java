package pages.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.WebPage;
import pages.components.WebComponent;
import pages.components.impl.SearchResultItemComponent;

import java.util.List;
import java.util.stream.Collectors;

public class SearchResultsPage extends WebPage {

    private static final By SEARCH_RESULTS_ITEM_SELECTOR = By.cssSelector(".repo-list-item");

    public SearchResultsPage(WebDriver driver){
        super(driver);
    }

    public List<String> searchResultsItemsText(){
        return searchResultsItems().stream().
                map(WebComponent::getText).
                collect(Collectors.toList());
    }

    public List<String> searchResultsItemsWithText(String searchPhrase){
        return searchResultsItems()
                .stream().filter(item -> item.containsSearchPhrase(searchPhrase))
                .map(WebComponent::getText)
                .collect(Collectors.toList());
    }

    private List<SearchResultItemComponent> searchResultsItems(){
        return findElements(SEARCH_RESULTS_ITEM_SELECTOR).stream()
                .map(SearchResultItemComponent::new)
                .collect(Collectors.toList());
    }
}
