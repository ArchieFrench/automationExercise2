package steps; // Changed from com.yourcompany.automationexercise.steps;

import pages.AccountDeletedPage; // Changed import
import pages.HomePage;           // Changed import
import pages.LoginPage;          // Changed import
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginSteps {
    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private AccountDeletedPage accountDeletedPage;

    public LoginSteps(WebDriver driver) {
        this.driver = driver;
        this.homePage = new HomePage(driver);
        this.loginPage = new LoginPage(driver);
        this.accountDeletedPage = new AccountDeletedPage(driver);
    }

    public void givenUserIsOnHomePage() {
        homePage.navigateToHomePage();
        assertTrue(homePage.isHomePageVisible(), "Home page is not visible.");
        homePage.handleConsentBanner(); // This line remains the same
    }



    public void whenUserClicksSignupLogin() {
        homePage.clickSignupLogin();
        assertTrue(loginPage.isLoginToAccountHeadingVisible(), "'Login to your account' heading is not visible.");
    }

    public void whenUserLogsIn(String email, String password) {
        loginPage.login(email, password);
    }

    public void thenUserIsLoggedInSuccessfully() {
        assertTrue(homePage.isLoggedInAsVisible(), "User is not logged in successfully.");
    }

    public void thenUserIsNotLoggedInSuccessfully() {
        assertFalse(homePage.isLoggedInAsVisible(), "User is not logged in successfully.");
    }

    public void andUserDeletesAccount() {
        homePage.clickDeleteAccount();
        assertTrue(accountDeletedPage.isAccountDeletedMessageVisible(), "'ACCOUNT DELETED!' message is not visible.");
        accountDeletedPage.clickContinueButton();
    }
}