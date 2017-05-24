package tests;

import static org.junit.Assert.*;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import pages.AccountValidatePage;
import pages.LogInPage;
import pages.MainPage;
import pages.MyDawanda;
import pages.RegisterPage;
import utils.CredentialGenerator;

public class RegistrationLoginAndLogoutTest extends AbstractTest {

    private final String email = CredentialGenerator.generateEmail();

    /**
     * Scenario 1:
     * 1. Open main page https://en.dawanda.com/
     * 2. Navigate to "Login now" button and click "Register" link in dropdown
     * 3. Fill in registration form and submit
     * 4. Check the message that the user has to validate his account
     * 5. Logout
     */
    @Test
    public void checkForSuccessfulRegistration() {
        MainPage mainPage = PageFactory.initElements(getDriver(), MainPage.class);
        mainPage.openMainPage();
        mainPage.goToRegisterPage();
        RegisterPage registerPage = PageFactory.initElements(getDriver(), RegisterPage.class);
        registerPage.fillRegisterForm(email);
        AccountValidatePage accountValidatePage = PageFactory.initElements(getDriver(), AccountValidatePage.class);
        assertThat(accountValidatePage.getEmailHint(), CoreMatchers.containsString(email));
        mainPage.logOut();
    }

    /**
     * Scenario 2:
     * 1. Open main page https://en.dawanda.com/
     * 2. Click "Login now" button
     * 3. Fill in and submit valid credentials for test account
     * 4. Log out from test account
     */
    @Test
    public void openMainPageLogInAndLogOut() {
        MainPage mainPage = PageFactory.initElements(getDriver(), MainPage.class);
        mainPage.openMainPage();
        mainPage.goToLogInPage();
        LogInPage logInPage = PageFactory.initElements(getDriver(), LogInPage.class);
        logInPage.fillLogInForm();
        MyDawanda myDawanda = PageFactory.initElements(getDriver(), MyDawanda.class);
        myDawanda.logOut();
    }
}
