package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private final By signupLoginButton = By.cssSelector("a[href='/login']");
    private final By homePageSlider = By.id("slider");
    private final By loggedInAsUserLink = By.xpath("//a[contains(text(),'Logged in as')]");
    private final By deleteAccountButton = By.cssSelector("a[href='/delete_account']");

    // === LOCATORS FOR CONSENT MODAL ===
    // IMPORTANT: YOU MUST FIND THE CORRECT LOCATORS BY INSPECTING THE LIVE WEBSITE!
    // This could be an ID for the whole modal dialog. Verify this!
    // Example: private final By consentModalContainer = By.id("fc-dialog-container");
    private final By consentModalContainer = By.id("fc-dialog-container"); // <-- VERIFY THIS ID on automationexercise.com

    // **UPDATED** consentAcceptButton using the className. Verify this!
    // Example: private final By consentAcceptButton = By.className("fc-button-label");
    private final By consentAcceptButton = By.className("fc-button-label"); // <-- VERIFY THIS CLASS NAME on automationexercise.com
    // ===================================


    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void navigateToHomePage() {
        driver.get("http://automationexercise.com");
        // Call the consent banner handler right after navigating
        handleConsentBanner();
    }

    public boolean isHomePageVisible() {
        try {
            // Wait for a visible element on the home page after potential consent banner interaction
            wait.until(ExpectedConditions.visibilityOfElementLocated(homePageSlider));
            return driver.findElement(homePageSlider).isDisplayed();
        } catch (org.openqa.selenium.TimeoutException e) {
            return false;
        }
    }

    // Handles clicking the consent banner if it appears
    private void handleConsentBanner() {
        try {
            // Wait for the modal container to be visible
            wait.until(ExpectedConditions.visibilityOfElementLocated(consentModalContainer));

            // Wait for the accept button within the modal and click it
            WebElement acceptButton = wait.until(ExpectedConditions.elementToBeClickable(consentAcceptButton));
            acceptButton.click();

            // Wait for the modal to disappear after clicking
            wait.until(ExpectedConditions.invisibilityOfElementLocated(consentModalContainer));

        } catch (org.openqa.selenium.TimeoutException | org.openqa.selenium.NoSuchElementException e) {
            // If the banner doesn't appear or cannot be found, silently continue.
            // This assumes the banner is not always present or is handled by other means.
            System.out.println("Consent banner not found or already handled (or unclickable). Continuing without clicking.");
            // If you *know* the banner should always appear and must be clicked,
            // you might want to re-throw the exception here instead of catching silently.
        }
    }


    public void clickSignupLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(signupLoginButton)).click();
    }

    public boolean isLoggedInAsVisible() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(loggedInAsUserLink)).isDisplayed();
        } catch (org.openqa.selenium.TimeoutException e) {
            return false;
        }
    }

    public void clickDeleteAccount() {
        wait.until(ExpectedConditions.elementToBeClickable(deleteAccountButton)).click();
    }
}