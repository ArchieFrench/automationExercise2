package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import static org.hamcrest.Matchers.is;

public class SignupTests {
    private static final String DRIVER_LOCATION = "src/test/resources/chromedriver.exe";
    private static final String BASE_URL = "https://automationexercise.com/";
    private WebDriverWait wait;

    private static ChromeDriverService service;
    private WebDriver driver;

    private static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--headless");
        options.addArguments("--remote-allow-origins=*");
        return options;
    }

    @BeforeAll
    public static void beforeAll() throws IOException {
        service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File(DRIVER_LOCATION))
                .usingAnyFreePort()
                .build();
        service.start();
    }

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().minimize();
    }

    @Test
    @DisplayName("Verify that homepage is visible successfully")
    public void checkWebDriver() {
        driver.get(BASE_URL);
        Assertions.assertEquals(BASE_URL, driver.getCurrentUrl());
        Assertions.assertEquals("Automation Exercise", driver.getTitle());
    }

    @Test
    @DisplayName("Given I am on the HomePage, I should see that 'New User Signup!' is visible")
    public void newUserSignup() {
        driver.get(BASE_URL);

        // Click on 'Signup / Login' button
        WebElement signInUpButton = driver.findElement(By.cssSelector("a[href='/login']"));
        wait.until(ExpectedConditions.elementToBeClickable(signInUpButton)).click();

        // Verify 'New User Signup!' is visible
        WebElement newUserField = driver.findElement(By.xpath("//h2[text()='New User Signup!']"));
        newUserField.isDisplayed();

        // Enter name and email address
        WebElement nameField = driver.findElement(By.xpath("//input[@name='name']"));
        WebElement emailField = driver.findElement(By.xpath("(//input[@email='email'])"));
        WebElement signupButton = driver.findElement(By.xpath("//button[text()='Signup']"));
        nameField.sendKeys("Abdallah Alhajahmed");
        emailField.sendKeys("abdallah98fc@gmail.com");
        signupButton.click();

        WebElement accountText = driver.findElement(By.xpath("//b[text()='Enter Account Information']"));
        accountText.isDisplayed();




        // Assert
//        MatcherAssert.assertThat(driver.getCurrentUrl(), Matchers.is("https://automationexercise.com/signup"));
    }
//    @Test
//    @DisplayName("Given I enter a valid username and email, when I click signup, then I should land on the signup page")
//    public void successfulSignupRedirection(){
//        // Arrange
//        driver.get(BASE_URL);

//
//        // Act

//    }


    @AfterEach
    public void teardown() {
        driver.quit();
    }

    @AfterAll
    static void afterAll() {
        service.stop();
    }

}
