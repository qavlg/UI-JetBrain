package auto.jetbrainsui.pages;

import com.codeborne.selenide.Condition;
import auto.jetbrainsui.helpers.AllureLogger;
import org.openqa.selenium.By;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;


public class RegistrationFormPage {
    private final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(RegistrationFormPage.class));

    private static final By ACCOUNT_TITLE = By.xpath("//h1[@class='rs-h1']");

    private static final By CONTINUE_WITH_EMAIL_BUTTON = By.xpath("//span[normalize-space()='Continue with email']");

    private static final By EMAIL_FIELD = By.cssSelector("#email");

    private static final By CONTINUE_BUTTON = By.cssSelector("button[type='submit']");

    private static final By IF_EMAIL_IS_EMPTY_THEN_ERROR_TEXT = By.xpath("//div[@class='_errorMessage_v916iw_596']");

    private static final By IF_EMAIL_IS_INVALID_THEN_ERROR_TEXT = By.xpath("//span[contains(text(),'The email address you entered has an invalid forma')]");

    private static final By IF_EMAIL_DOES_NOT_EXIST_THEN_ERROR_TEXT = By.xpath("//form[@class='flex flex-col gap-y-4']//span[1]");

    private static final By CREATE_NEW_ACCOUNT_ELEMENT = By.xpath("//a[normalize-space()='create a new account']");

    private static final By ACCOUNT_AGREEMENT_ELEMENT = By.xpath("//a[@class='bad-link'][normalize-space()='JetBrains Account Agreement']");

    private static final By CONTINUE_WITH_GOOGLE_BUTTON = By.xpath("//span[normalize-space()='Continue with Google']");

    private static final By CONTINUE_WITH_GITHUB_BUTTON = By.xpath("//span[normalize-space()='Continue with GitHub']");

    private static final By CONTINUE_WITH_APPLE_BUTTON = By.xpath("//span[normalize-space()='Continue with Apple']");


    public String checkTitleAfterSubmitting() {
        LOG.info("Check whether the Account title is correct");
        $(ACCOUNT_TITLE).shouldBe(visible);
        return $(ACCOUNT_TITLE).getText();
    }

    public boolean checkContinueWithEmailButton() {
        LOG.info("Check whether the Continue with email button is clickable");
        try {
            $(CONTINUE_WITH_EMAIL_BUTTON).shouldBe(Condition.clickable);
            LOG.info("The Continue with Email button is clickable");
            return true;
        } catch (Exception e) {
            LOG.error("The Continue with Email button is not clickable");
            return false;
        }
    }

    public void clickContinueWithEmailButton() {
        $(CONTINUE_WITH_EMAIL_BUTTON).click();
        LOG.info("Click on the Continue with email button");
    }

    public void clickContinueButton() {
        $(CONTINUE_BUTTON).click();
        LOG.info("Click on the Continue button");
    }


    public String checkTheErrorIfEmailIsEmpty() {
        LOG.info("Check whether the text 'You can't leave this field empty.' is correct");
        $(IF_EMAIL_IS_EMPTY_THEN_ERROR_TEXT).shouldBe(visible);
        return $(IF_EMAIL_IS_EMPTY_THEN_ERROR_TEXT).getText();
    }

    public String checkTheErrorIfEmailIsInvalid() {
        LOG.info("Check whether the text 'The email address you entered has an invalid format. Check it and try again.' is correct");
        $(IF_EMAIL_IS_INVALID_THEN_ERROR_TEXT).shouldBe(visible);
        return $(IF_EMAIL_IS_INVALID_THEN_ERROR_TEXT).getText();
    }

    public void inputTextIntoEmailField(String email) {
        $(EMAIL_FIELD).setValue(email);
        LOG.info("Enter email: " + email);
    }

    public String checkTheErrorIfEmailDoesNotExist() {
        LOG.info("Check whether the text 'We couldn't find an account associated with this email address. Check the spelling of the email address or create a new account.' is correct");
        $(IF_EMAIL_DOES_NOT_EXIST_THEN_ERROR_TEXT).shouldBe(visible);
        return $(IF_EMAIL_DOES_NOT_EXIST_THEN_ERROR_TEXT).getText();
    }

    public boolean checkCreateNewAccountElement() {
        LOG.info("Check whether Create a new account element is clickable");
        try {
            $(CREATE_NEW_ACCOUNT_ELEMENT).shouldBe(Condition.clickable);
            LOG.info("Create a new account element is clickable");
            return true;
        } catch (Exception e) {
            LOG.error("Create a new account element is not clickable");
            return false;
        }
    }

    public void clickAccountAgreementElement() {
        $(ACCOUNT_AGREEMENT_ELEMENT).click();
        LOG.info("Click on the Account Agreement Element");
    }

    public boolean checkContinueWithGoogle() {
        LOG.info("Check whether the Continue with Google is clickable");
        try {
            $(CONTINUE_WITH_GOOGLE_BUTTON).shouldBe(Condition.clickable);
            LOG.info("The Continue with Google button is clickable");
            return true;
        } catch (Exception e) {
            LOG.error("The Continue with Google button is not clickable");
            return false;
        }
    }

    public boolean checkContinueWithGitHub() {
        LOG.info("Check whether the Continue with GitHub is clickable");
        try {
            $(CONTINUE_WITH_GITHUB_BUTTON).shouldBe(Condition.clickable);
            LOG.info("The Continue with GitHub button is clickable");
            return true;
        } catch (Exception e) {
            LOG.error("The Continue with GitHub button is not clickable");
            return false;
        }
    }

    public boolean checkContinueWithApple() {
        LOG.info("Check whether the Continue with Apple is clickable");
        try {
            $(CONTINUE_WITH_APPLE_BUTTON).shouldBe(Condition.clickable);
            LOG.info("The Continue with Apple button is clickable");
            return true;
        } catch (Exception e) {
            LOG.error("The Continue with Apple button is not clickable");
            return false;
        }
    }
}
