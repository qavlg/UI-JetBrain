package auto.jetbrainsui.tests;

import auto.jetbrainsui.pages.KotlinPage;
import auto.jetbrainsui.pages.MainPage;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.junit.jupiter.api.Assertions.*;

public class KotlinTest {

    MainPage mp;
    KotlinPage kp;

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
    }

    @BeforeEach
    public void setUp() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
        mp = page();
        kp = page();
        open("https://www.jetbrains.com");
    }

    @Test
    @DisplayName("#6. The title is 'Get involved in' After clicking on the 'Join the community' button")
    public void checkTheUrlAndTitleOfCommunity() {

        mp.clickCookieAcceptButton();
        mp.clickDeveloperToolsElement();
        mp.clickKotlinElement();
        kp.clickCommunityButton();

        String expectedUrl = "https://kotlinlang.org/community/";
        WebDriverWait wait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(10));
        wait.until(driver -> driver.getCurrentUrl().equals(expectedUrl));
        String currentUrl = getWebDriver().getCurrentUrl();

        assertAll("Check two conditions",
                () -> assertEquals("Get involved in\n" +
                        "the community", kp.checkTitleCommunity(), "Incorrect title"),
                () -> assertEquals(expectedUrl,
                        currentUrl, "Current url is wrong")
        );
    }

    @Test
    @DisplayName("#7. There is the clickable button 'Get started' on the Kotlin page")
    public void checkTheGetStartedButton() {

        mp.clickCookieAcceptButton();
        mp.clickDeveloperToolsElement();
        mp.clickKotlinElement();

        assertAll("Check two conditions",
                () -> assertEquals("Get started", kp.checkTheNameOfTheGetStartedButton(),
                        "Incorrect name"),
                () -> assertTrue(kp.checkTheGetStartedButton(),
                        "Not clickable")
        );
    }

    @Test
    @DisplayName("#8. The text 'The latest news' is not clickable")
    public void checkTheLatestNews() {

        mp.clickCookieAcceptButton();
        mp.clickDeveloperToolsElement();
        mp.clickKotlinElement();

        assertTrue(kp.checkTheLatestNews(),
                "Clickable");
    }

    @Test
    @DisplayName("#9. The 'Advanced search' is invisible when text is not typed in the search field")
    public void checkVisibilityTheAdvancedButton() {

        mp.clickCookieAcceptButton();
        mp.clickDeveloperToolsElement();
        mp.clickKotlinElement();
        kp.clickSearchButton();

        assertTrue(kp.checkVisibilityTheAdvancedButton(),
                "Visible");
    }

    @Test
    @DisplayName("#10. The 'Advanced search' is clickable when text is typed in the search field")
    public void checkTheAdvancedButton() {
        String text = "Kotlin";

        mp.clickCookieAcceptButton();
        mp.clickDeveloperToolsElement();
        mp.clickKotlinElement();
        kp.clickSearchButton();
        kp.inputTextIntoSearchField(text);

        assertTrue(kp.checkTheAdvancedButton(),
                "Not clickable");
    }

    @Test
    @DisplayName("#11.The text 'Showing results for' is visible when text is typed in the search field")
    public void checkShowingResultsText() {
        String text = "Kotlin";

        mp.clickCookieAcceptButton();
        mp.clickDeveloperToolsElement();
        mp.clickKotlinElement();
        mp.clickCookieAcceptButton();
        kp.clickSearchButton();
        kp.inputTextIntoSearchField(text);

        assertEquals("Showing results for «Kotlin»", kp.checkTheShowingResultsText(),
                "Incorrect text");
    }

    @Test
    @DisplayName("#12. The 'Advanced search' is invisible when text was deleted from the search field")
    public void checkDeleteButton() {
        String text = "Kotlin";

        mp.clickCookieAcceptButton();
        mp.clickDeveloperToolsElement();
        mp.clickKotlinElement();
        mp.clickCookieAcceptButton();
        kp.clickSearchButton();
        kp.inputTextIntoSearchField(text);
        kp.clickDeleteButton();

        assertTrue(kp.checkVisibilityTheAdvancedButton(),
                "Visible");
    }

    @Test
    @DisplayName("#13.The text 'Hi, stranger!' is visible after clicking 'Run' button")
    public void checkTextAfterClickingRunButton() {

        mp.clickCookieAcceptButton();
        mp.clickDeveloperToolsElement();
        mp.clickKotlinElement();
        mp.clickCookieAcceptButton();
        kp.clickRunButton();

        assertEquals("Hi, stranger!\n" +
                        "Current count: 0 1 2 3 4 5 6 7 8 9 10", kp.checkTextAfterClickingRunButton(),
                "Incorrect text");

    }

    @Test
    @DisplayName("#14. 'Ideal For Tests', 'Functional', 'ObjectOriented' are clickable")
    public void checkContinueWithButtons() {

        mp.clickCookieAcceptButton();
        mp.clickDeveloperToolsElement();
        mp.clickKotlinElement();
        mp.clickCookieAcceptButton();
        kp.clickRunButton();

        assertAll("Check two conditions",
                () -> assertTrue(kp.checkIdealForTestsButton(),
                        "Not clickable"),
                () -> assertTrue(kp.checkFunctionalButton(),
                        "Not clickable"),
                () -> assertTrue(kp.checkObjectOrientedButton(),
                        "Not clickable")
        );
    }

    @Test
    @DisplayName("#15. The text 'Liftoff!' is invisible after clicking 'Close' button")
    public void checkElementAfterClickingCloseButton() {

        mp.clickCookieAcceptButton();
        mp.clickDeveloperToolsElement();
        mp.clickKotlinElement();
        mp.clickCookieAcceptButton();
        kp.clickAsynchronousButton();
        kp.clickRunButton();
        kp.clickAsynchronousButton();
        kp.clickCloseButton();

        assertTrue(kp.checkVisibilityTextAfterClickingRunButton(),
                "Invisible");
    }

    @AfterEach
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}