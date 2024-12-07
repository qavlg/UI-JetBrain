package auto.jetbrainsui.pages;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    private static final Logger LOG = LoggerFactory.getLogger(MainPage.class);

    private static final By COOKIE_ACCEPT_ALL = By.cssSelector("[data-jetbrains-cookies-banner-action='ACCEPT_ALL']");

    private static final By ACCOUNT_BUTTON = By.cssSelector("a[data-test='site-header-profile-action']");

    private static final By DEVELOPER_TOOLS_ELEMENT = By.cssSelector("nav>div:first-child>button[aria-label='Developer Tools: Open submenu']");

    private static final By KOTLIN_ELEMENT = By.xpath("(//span[contains(text(), 'Kotlin')])[1]");

    public void clickCookieAcceptButton() {
        $(COOKIE_ACCEPT_ALL).shouldBe(visible, Duration.ofSeconds(10));

        if ($(COOKIE_ACCEPT_ALL).isDisplayed()) {
            $(COOKIE_ACCEPT_ALL).click();
            LOG.info("Click on the Cookie accept button");
        } else {
            LOG.warn("Cookie accept button not found, skipping click");
        }
    }

    public void clickAccountButton() {
        $(ACCOUNT_BUTTON).shouldBe(clickable, Duration.ofSeconds(6)).click();
        LOG.info("Click on the Account button");
    }

    public void clickDeveloperToolsElement() {
        $(DEVELOPER_TOOLS_ELEMENT).shouldBe(clickable, Duration.ofSeconds(6)).click();
        LOG.info("Click on the Developer tools element");
    }

    public void clickKotlinElement() {
        $(KOTLIN_ELEMENT).shouldBe(clickable, Duration.ofSeconds(6)).click();
        LOG.info("Click on the Kotlin element");
    }
}