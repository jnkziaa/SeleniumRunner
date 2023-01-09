import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.impl.HomePage;
import pages.impl.SearchResultsPage;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class GithubSearchTest {

    private static final String SEARCH_PHRASE = "selenium";
    private static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeAll
    static void setUpDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(20000));
    }

    @BeforeAll
    public static void setUpWait(){
        wait = new WebDriverWait(driver, Duration.ofMillis(15000));
    }

    private static void switchOffImplicitWait(){
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(0));
    }

    @Test
    public void checkGithubSearch() throws InterruptedException {
        driver.get("https://github.com");
        HomePage homePage = new HomePage(driver);
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        homePage.searchComponent().performSearch(SEARCH_PHRASE);
        List<String> actualItems = searchResultsPage.searchResultsItemsText();
        List<String> expectedItems = searchResultsPage.searchResultsItemsWithText(SEARCH_PHRASE);

        Assertions.assertEquals(actualItems, expectedItems);
    }

    @AfterAll
    static void tearDown() {
        System.out.println(LocalDateTime.now());
        driver.quit();
    }
}
