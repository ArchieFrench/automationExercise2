package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.LoginSteps;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest; // Import for ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource; // Import for CsvSource
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest {

    private WebDriver driver;
    private LoginSteps loginSteps;

    // We no longer need the hardcoded TEST_EMAIL and TEST_PASSWORD constants
    // private final String TEST_EMAIL = "your_registered_email@example.com";
    // private final String TEST_PASSWORD = "your_password";

    @BeforeEach
    public void setUp() {
        // Set the path to your ChromeDriver executable
        // System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        loginSteps = new LoginSteps(driver); // Initialize your step definitions
    }

    // Changed from @Test to @ParameterizedTest
    // @CsvSource provides the test data as comma-separated values for each run
    @ParameterizedTest(name = "Login with Email: {0}") // Optional: name for better test reporting
    @CsvSource({
            "markblackmore26@gmail.com, Password123",
            "usernameuser@realemail.com, PasswordPassword2930",
            "oshuaj@mailg.com, PersonThing27"
    })
    public void testCase2_LoginUserWithCorrectEmailAndPassword(String email, String password) { // Method now accepts parameters
        // Test Case Steps as per Automation Exercise:
        // 1. Launch browser
        // 2. Navigate to url 'http://automationexercise.com'
        loginSteps.givenUserIsOnHomePage();

        // 3. Verify that home page is visible successfully. (Done in givenUserIsOnHomePage)

        // 4. Click on 'Signup / Login' button.
        // 5. Verify 'Login to your account' is visible.
        loginSteps.whenUserClicksSignupLogin();

        // 6. Enter correct email address and password.
        // 7. Click 'login' button.
        // Now using the 'email' and 'password' parameters from @CsvSource
        loginSteps.whenUserLogsIn(email, password);

        // 8. Verify that 'Logged in as username' is visible.
        loginSteps.thenUserIsLoggedInSuccessfully();

        // 9. Click 'Delete Account' button.
        // 10. Verify that 'ACCOUNT DELETED!' is visible.
        loginSteps.andUserDeletesAccount();
    }

    @ParameterizedTest(name = "Block Login with incorrect email: {1}")
    @CsvSource({
            "barkmlackmore62@mgail.mco, Aspwords231",
            "suermaneuseruser@user.com, passwrd1211",
            "NameNameName@name.com namename223"
    })
    public void testCase3_LoginUserWithIncorrectCorrectEmailAndPassword(String email, String password) {
        //similar to log in steps
        loginSteps.givenUserIsOnHomePage();
        loginSteps.whenUserClicksSignupLogin();

        //diverts using invalid username and password fields
        loginSteps.whenUserLogsIn(email, password);
        //asserts whats true about a successful login is false in this context
        loginSteps.thenUserIsNotLoggedInSuccessfully();
    }

    @Test
    @DisplayName("Test the log out button: {2}")
    public void testCase4_LogOutWhenUserPressesLogOut() {
        //arranges all other steps
        loginSteps.givenUserIsOnHomePage();
        loginSteps.whenUserClicksSignupLogin();
        loginSteps.whenUserLogsIn("markblackmore26@gmail.com", "Password123");
        //assert that log out logs user out
        //needs to be handled in login steps
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}