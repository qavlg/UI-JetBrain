package auto.jetbrainsui.pages;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    private static final Logger LOG = LoggerFactory.getLogger(MainPage.class);

    private static final By COOKIE_ACCEPT_ALL = By.cssSelector("[data-jetbrains-cookies-banner-action='ACCEPT_ALL']");

    private static final By ACCOUNT_BUTTON = By.cssSelector("path[d='M15 10H9a4 4 0 0 0-4 4v7h14v-7a4 4 0 0 0-4-4z']");

    private static final By DEVELOPER_TOOLS_ELEMENT = By.cssSelector("button[data-focus-method='mouse']");


    public void clickCookieAcceptButton() {
        $(COOKIE_ACCEPT_ALL).click();
        LOG.info("Click on the Cookie accept button");
    }

    public void clickAccountButton() {
        $(ACCOUNT_BUTTON).click();
        LOG.info("Click on the Account button");
    }

    public void clickDeveloperToolsElement() {
        $(DEVELOPER_TOOLS_ELEMENT).click();
        LOG.info("Click on the Developer tools element");
    }
}
