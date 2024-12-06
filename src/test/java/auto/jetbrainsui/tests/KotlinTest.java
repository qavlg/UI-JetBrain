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
    @DisplayName("#6. ")
    public void checkTheMainElementsInAccountForm() {
        mp.clickCookieAcceptButton();
        mp.clickDeveloperToolsElement();
        mp.clickKotlinElement();
        kp.clickContinueButton();

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
    @DisplayName("#7.")
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
    @DisplayName("#8.")
    public void checkTheDevelopedBy() {
        mp.clickCookieAcceptButton();
        mp.clickDeveloperToolsElement();
        mp.clickKotlinElement();

        assertTrue(kp.checkTheLatestNews(),
                "Clickable");
    }

    @Test
    @DisplayName("#9.")
    public void checkVisibilityTheAdvancedButton() {

        mp.clickCookieAcceptButton();
        mp.clickDeveloperToolsElement();
        mp.clickKotlinElement();
        kp.clickSearchButton();

        assertTrue(kp.checkVisibilityTheAdvancedButton(),
                "Invisible");
    }

    @Test
    @DisplayName("#10.")
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

    @AfterEach
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}
