package tests;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;


public class TestSignup {
    private static final String DRIVER_LOCATION = "src/test/resources/chromedriver.exe";
    private static final String BASE_URL = "https://automationexercise.com/login";

    private static ChromeDriverService service;
    private WebDriver driver = new ChromeDriver();

    private static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--headless");
        options.addArguments("--remote-allow-origins=*");
        return options;
    }

    @BeforeAll
    public static void beforeAll() throws IOException, IOException {
        service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File(DRIVER_LOCATION))
                .usingAnyFreePort()
                .build();
        service.start();
    }

    @BeforeEach
    public void setup() {
        driver = new RemoteWebDriver(service.getUrl(), getChromeOptions());
    }

    @Test
    @DisplayName("Check that the webdriver works")
    public void checkWebDriver() {
        driver.get(BASE_URL);
        Assertions.assertEquals(BASE_URL, driver.getCurrentUrl());
        Assertions.assertEquals("Automation Exercise - Signup / Login", driver.getTitle());
    }

    @Test
    @DisplayName("Given I enter a valid username and email, when I click signup, then I should land on the signup page")
    public void successfulSignupRedirection(){
        // Arrange
        driver.get(BASE_URL);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement nameField = driver.findElement(By.name("name"));
        WebElement emailField = driver.findElement(By.name("email"));
        WebElement signupButton= driver.findElement(new By.ByXPath("//*[@id=\"form\"]/div/div/div[3]/div/form/button"));

        // Act
        nameField.sendKeys("Abdallah Alhajahmed");
        emailField.sendKeys("abdallah98fc@gmail.com");
        signupButton.click();
        // Assert
        MatcherAssert.assertThat(driver.getCurrentUrl(), Matchers.is("https://automationexercise.com/signup"));
    }

    @Test
    @DisplayName("Given I am on the signup page, when I enter all my details, I should see a successful registration message")
    public void successfulRegistration(){
        // Arrange - sign up
        driver.get(BASE_URL);
//        WebElement mrRadioButton = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/form/div[1]/div[1]/label"));
        WebElement nameField = driver.findElement(By.id("name"));
        WebElement emailField = driver.findElement(By.id("email"));
        WebElement passwordField = driver.findElement(By.id("password"));

//        WebElement daysField = driver.findElement(By.id("days"));
//        WebElement monthsField = driver.findElement(By.id("months"));
//        WebElement yearsField = driver.findElement(By.id("years"));

//        WebElement newsletterField = driver.findElement(By.id("newsletter"));
//        WebElement parternersField = driver.findElement(By.id("optin"));

        WebElement firstnameField = driver.findElement(By.id("first_name"));
        WebElement lastnameField = driver.findElement(By.id("last_name"));
//        WebElement companyField = driver.findElement(By.id("company"));
        WebElement address1Field = driver.findElement(By.id("address1"));
//        WebElement address2Field = driver.findElement(By.id("address2"));
        WebElement countryField = driver.findElement(By.id("country"));
        WebElement stateField = driver.findElement(By.id("state"));
        WebElement cityField = driver.findElement(By.id("city"));
        WebElement zipcodeField = driver.findElement(By.id("zipcode"));
        WebElement mobileField = driver.findElement(By.id("mobile_number"));
        WebElement createAccountButton = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/form/button"));


        nameField.sendKeys("Abdallah Alhajahmed");
        emailField.sendKeys("abdallah98fc@gmail.com");
        passwordField.sendKeys("123456!!!!");
        firstnameField.sendKeys("Abdallah");
        lastnameField.sendKeys("Alhajahmed");
        address1Field.sendKeys("5 Random Street");
        countryField.sendKeys("India");
        stateField.sendKeys("Delhi");
        cityField.sendKeys("Gurgoan");
        zipcodeField.sendKeys("523823");
        mobileField.sendKeys("07545415894");
        createAccountButton.click();
        // Assert
        MatcherAssert.assertThat(driver.getCurrentUrl(), Matchers.is("https://automationexercise.com/account_created"));

    }

    @AfterEach
    public void teardown() {
        driver.quit();
    }

    @AfterAll
    static void afterAll() {
        service.stop();
    }

}