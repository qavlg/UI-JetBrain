package auto.jetbrainsui.pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class KotlinPage {
    private static final Logger LOG = LoggerFactory.getLogger(KotlinPage.class);

    private static final By JOIN_COMMUNITY_BUTTON = By.cssSelector("div.info-block_item__lGaST.info-block_content__4THgE > a > button");

    private static final By TITLE_OF_COMMUNITY = By.xpath("//div[@class='ktl-hero']");

    private static final By GET_STARTED_BUTTON = By.cssSelector("a[class*='hero_getStartedButton__gq57']");

    private static final By LATEST_NEWS = By.cssSelector("h2[class*='latest-news_h__Q6ZWC rs-h2']");

    private static final By SEARCH_BUTTON = By.cssSelector("button[data-test='header-search-button']");

    private static final By SEARCH_FIELD = By.cssSelector("input[data-test='input__inner']");

    private static final By ADVANCED_BUTTON = By.cssSelector("div[class*='rs-text-3 rs-text-3_hardness_hard']:nth-child(1)");

    private static final By SHOWING_RESULTS_TEXT = By.cssSelector("div[class*='ktl-list-module_searchString_rJnxa']");

    private static final By DELETE_BUTTON = By.cssSelector("button[class*='customClearButton_yecGK']");

    private static final By RUN_BUTTON = By.cssSelector("div.why-kotlin_controlButtons__Iu3rI > button");

    private static final By TEXT_AFTER_CLICKING_RUN = By.cssSelector("span[class*='standard-output darcula']");

    private static final By IDEAL_FOR_TESTS_BUTTON = By.cssSelector("div.why-kotlin_tabList__jiaTT > button:nth-child(5)");

    private static final By FUNCTIONAL_BUTTON = By.cssSelector("div.why-kotlin_tabList__jiaTT > button:nth-child(4)");

    private static final By OBJECT_ORIENTED_BUTTON = By.cssSelector("div.why-kotlin_tabList__jiaTT > button:nth-child(3)");

    private static final By ASYNCHRONOUS_BUTTON = By.cssSelector("div.why-kotlin_tabList__jiaTT > button:nth-child(2)");

    private static final By TEXT_AFTER_CLICKING_RUN_AND_ASYNCHRONOUS = By.cssSelector(".standard-output.darcula:nth-child(1)");

    private static final By CLOSE_BUTTON = By.cssSelector("span[class*='standard-output darcula']");

    public void clickCommunityButton() {
        $(JOIN_COMMUNITY_BUTTON).shouldBe(clickable, Duration.ofSeconds(20)).click();
        LOG.info("Click on the Community button");
    }

    public String checkTitleCommunity() {
        LOG.info("Check if the the community title is correct");
        $(TITLE_OF_COMMUNITY).shouldBe(visible, Duration.ofSeconds(20));
        return $(TITLE_OF_COMMUNITY).getText();
    }

    public String checkTheNameOfTheGetStartedButton() {
        LOG.info("Check whether the name of the Get Started button is correct");
        $(GET_STARTED_BUTTON).shouldBe(visible);
        return $(GET_STARTED_BUTTON).getText();
    }

    public boolean checkTheGetStartedButton() {
        LOG.info("Check whether the Get Started button is clickable");
        try {
            $(GET_STARTED_BUTTON).shouldBe(Condition.clickable);
            LOG.info("The Get Started button is clickable");
            return true;
        } catch (Exception e) {
            LOG.error("The Get Started button is not clickable");
            return false;
        }
    }

    public boolean checkTheLatestNews() {
        LOG.info("Check whether the Latest News is clickable");
        try {
            $(LATEST_NEWS).shouldNotBe(clickable);
            LOG.info("The Latest News is not clickable");
            return true;
        } catch (Exception e) {
            LOG.error("The Latest News is clickable");
            return false;
        }
    }

    public void clickSearchButton() {
        $(SEARCH_BUTTON).shouldBe(clickable, Duration.ofSeconds(10)).click();
        LOG.info("Click on the Search button");

        if (!$(SEARCH_FIELD).isDisplayed()) {
            LOG.info("Expected element not found. Trying again...");
            $(SEARCH_BUTTON).click();
            LOG.info("Second click on the Search button");
        }
    }

    public void inputTextIntoSearchField(String text) {
        $(SEARCH_FIELD).sendKeys(text);
        LOG.info("Enter text");

    }

    public boolean checkVisibilityTheAdvancedButton() {
        LOG.info("Check whether the Advanced is not visible");
        try {
            $(ADVANCED_BUTTON).shouldNotBe(visible);
            LOG.info("The Advanced is not visible");
            return true;
        } catch (Exception e) {
            LOG.error("The Advanced is visible");
            return false;
        }
    }

    public boolean checkTheAdvancedButton() {
        LOG.info("Check whether the Advanced is enable");
        try {
            $(ADVANCED_BUTTON).shouldNotBe(visible);
            LOG.info("The Advanced is enable");
            return true;
        } catch (Exception e) {
            LOG.error("The Advanced is not enable");
            return false;
        }
    }

    public String checkTheShowingResultsText() {
        LOG.info("Check whether the Showing Results text is correct");
        $(SHOWING_RESULTS_TEXT).shouldBe(visible, Duration.ofSeconds(10));
        return $(SHOWING_RESULTS_TEXT).getText();
    }

    public void clickDeleteButton() {
        $(DELETE_BUTTON).shouldBe(clickable, Duration.ofSeconds(10)).click();
        LOG.info("Click on the Delete button");
    }

    public void clickRunButton() {
        $(RUN_BUTTON).shouldBe(clickable).click();
        LOG.info("Click on the Run button");
    }

    public String checkTextAfterClickingRunButton() {
        LOG.info("Check if the text after clicking the Run button is correct");
        $(TEXT_AFTER_CLICKING_RUN).shouldBe(visible, Duration.ofSeconds(10));
        return $(TEXT_AFTER_CLICKING_RUN).getText();
    }

    public boolean checkIdealForTestsButton() {
        LOG.info("Check whether the Ideal for test button is clickable");
        try {
            $(IDEAL_FOR_TESTS_BUTTON).shouldBe(Condition.clickable);
            LOG.info("The Ideal for tests button is clickable");
            return true;
        } catch (Exception e) {
            LOG.error("The Ideal for tests button is not clickable");
            return false;
        }
    }

    public boolean checkFunctionalButton() {
        LOG.info("Check whether the Functional button is clickable");
        try {
            $(FUNCTIONAL_BUTTON).shouldBe(Condition.clickable);
            LOG.info("The Functional button is clickable");
            return true;
        } catch (Exception e) {
            LOG.error("The Functional button is not clickable");
            return false;
        }
    }

    public boolean checkObjectOrientedButton() {
        LOG.info("Check whether the Object oriented button is clickable");
        try {
            $(OBJECT_ORIENTED_BUTTON).shouldBe(Condition.clickable);
            LOG.info("The Object oriented button is clickable");
            return true;
        } catch (Exception e) {
            LOG.error("The Object oriented button is not clickable");
            return false;
        }
    }

    public void clickAsynchronousButton() {
        $(ASYNCHRONOUS_BUTTON).shouldBe(clickable, Duration.ofSeconds(6)).click();
        LOG.info("Click on the Asynchronous button");
    }

    public void clickCloseButton() {
        $(CLOSE_BUTTON).shouldBe(clickable, Duration.ofSeconds(6)).click();
        LOG.info("Click on the Close button");
    }

    public boolean checkVisibilityTextAfterClickingRunButton() {
        LOG.info("Check whether the text is visible or not");
        $(TEXT_AFTER_CLICKING_RUN_AND_ASYNCHRONOUS).shouldBe(visible, Duration.ofSeconds(10));
        return true;
    }
}