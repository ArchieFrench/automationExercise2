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
    // Example: This could be an ID for the whole modal dialog
    private final By consentModalContainer = By.id("fc-dialog-container"); // Common for some consent tools, e.g., Fandom
    // A more generic CSS selector for a dialog role, if no specific ID
    // private final By consentModalContainer = By.cssSelector("[role='dialog'][aria-modal='true']");

    // This is the "Accept" button within the modal
    // Try to be specific. Look for text like "Accept All", "Got it", "Agree", "Continue"
    private final By consentAcceptButton = By.xpath("//button[normalize-space()='Accept All']");
    // Or if the text varies, and you want to catch any of them:
    // private final By consentAcceptButton = By.xpath("//button[contains(normalize-space(),'Accept') or contains(normalize-space(),'Got it') or contains(normalize-space(),'Agree') or contains(normalize-space(),'Continue')]");
    // Or by a data-qa attribute if present:
    // private final By consentAcceptButton = By.cssSelector("button[data-qa='accept-cookies']");
    // ===================================


    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void navigateToHomePage() {
        driver.get("http://automationexercise.com");
    }

    public boolean isHomePageVisible() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(homePageSlider));
            return driver.findElement(homePageSlider).isDisplayed();
        } catch (org.openqa.selenium.TimeoutException e) {
            return false;
        }
    }

    // Refined Method: Handle the cookie consent banner/modal
    public void handleConsentBanner() {
        try {
            System.out.println("Attempting to handle consent banner...");
            // First, wait for the modal container itself to be visible
            wait.until(ExpectedConditions.visibilityOfElementLocated(consentModalContainer));
            System.out.println("Consent modal container is visible.");

            // Then, wait for the accept button *within* that visible modal and click it
            WebElement acceptButton = wait.until(ExpectedConditions.elementToBeClickable(consentAcceptButton));
            acceptButton.click();
            System.out.println("Clicked consent accept button.");

            // Finally, wait for the modal to disappear after clicking
            wait.until(ExpectedConditions.invisibilityOfElementLocated(consentModalContainer));
            System.out.println("Consent modal has disappeared.");

        } catch (org.openqa.selenium.TimeoutException | org.openqa.selenium.NoSuchElementException e) {
            // If the modal or button is not found or not clickable within the timeout,
            // assume the banner didn't appear or was already handled.
            System.out.println("No consent modal found or it was already handled.");
            // You might want to log the exception (e.getMessage()) here for more details in debug logs
        }
    }

    public void clickSignupLogin() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(signupLoginButton)).click();
        } catch (Exception e) {
            System.err.println("Failed to click Signup/Login button. It might be obscured or not interactable.");
            throw e;
        }
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