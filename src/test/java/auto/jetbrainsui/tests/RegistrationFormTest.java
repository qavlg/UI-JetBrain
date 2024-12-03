package auto.jetbrainsui.tests;

import com.codeborne.selenide.Configuration;
import auto.jetbrainsui.pages.MainPage;
import auto.jetbrainsui.pages.RegistrationFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static org.junit.jupiter.api.Assertions.*;

public class RegistrationFormTest {

    MainPage mp;
    RegistrationFormPage rfp;

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
    }

    @BeforeEach
    public void setUp() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
        mp = page();
        rfp = page();
        open("https://www.jetbrains.com");
    }

    @Test
    @DisplayName("#1. JetBrains Account's window will be opened after clicking the 'Account' button and the 'Continue With Email Button' will be clickable")
    public void checkTheMainElementsInAccountForm() {
        mp.clickCookieAcceptButton();
        mp.clickAccountButton();
        assertAll("Check two conditions",
                () -> assertEquals("JetBrains Account", rfp.checkTitleAfterSubmitting(),
                        "Incorrect title"),
                () -> assertTrue(rfp.checkContinueWithEmailButton(),
                        "Not clickable")
        );
    }

    @Test
    @DisplayName("#2. After clicking on the Continue button appears the error text under Email field when the field is empty")
    public void checkTheErrorIfEmailIsEmpty() {
        mp.clickCookieAcceptButton();
        mp.clickAccountButton();
        rfp.clickContinueWithEmailButton();
        rfp.clickContinueButton();

        assertEquals("You can't leave this field empty.", rfp.checkTheErrorIfEmailIsEmpty(),
                "Incorrect the text of the error when email is empty");
    }

    @Test
    @DisplayName("#3. After clicking on the Continue button appears the error text under Email field when email is invalid")
    public void checkTheErrorIfEmailIsInvalid() {
        String email = "test,test@test.ru";

        mp.clickCookieAcceptButton();
        mp.clickAccountButton();
        rfp.clickContinueWithEmailButton();
        rfp.inputTextIntoEmailField(email);
        rfp.clickContinueButton();

        assertEquals("The email address you entered has an invalid format. Check it and try again.", rfp.checkTheErrorIfEmailIsInvalid(),
                "Incorrect the text of the error when email is invalid");
    }

    @Test
    @DisplayName("#4. After clicking on the Continue button appears the error text under Email field when email does not exist")
    public void checkTheErrorIfEmailDoesNotExist() {
        String email = "testtesttest@test.ru";

        mp.clickCookieAcceptButton();
        mp.clickAccountButton();
        rfp.clickContinueWithEmailButton();
        rfp.inputTextIntoEmailField(email);
        rfp.clickContinueButton();

        assertAll("Check two conditions",
                () -> assertEquals("We couldn't find an account associated with this email address. Check the spelling of the email address or create a new account.", rfp.checkTheErrorIfEmailDoesNotExist(),
                        "Incorrect the text of the error when email does not exist"),
                () -> assertTrue(rfp.checkCreateNewAccountElement(),
                        "Not clickable")
        );
    }

    @Test
    @DisplayName("#5. The 'Continue with button' are active on the Registration form")
    public void checkContinueWithButtons() {
        mp.clickCookieAcceptButton();
        mp.clickAccountButton();

        assertAll("Check two conditions",
                () -> assertTrue(rfp.checkContinueWithGoogle(),
                        "Not clickable"),
                () -> assertTrue(rfp.checkContinueWithGitHub(),
                        "Not clickable"),
                () -> assertTrue(rfp.checkContinueWithApple(),
                        "Not clickable")
        );

    }
}