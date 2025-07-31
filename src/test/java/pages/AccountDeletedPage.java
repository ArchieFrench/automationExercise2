package pages; // Changed from com.yourcompany.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountDeletedPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private final By accountDeletedHeading = By.xpath("//h2[@data-qa='account-deleted']");
    private final By continueButton = By.cssSelector("a[data-qa='continue-button']");


    public AccountDeletedPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isAccountDeletedMessageVisible() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(accountDeletedHeading)).isDisplayed();
        } catch (org.openqa.selenium.TimeoutException e) {
            return false;
        }
    }

    public void clickContinueButton() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
        } catch (org.openqa.selenium.TimeoutException e) {
            System.out.println("No 'Continue' button found after account deletion or it wasn't clickable within the timeout.");
        }
    }
}