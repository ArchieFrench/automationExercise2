package webFramework.pages;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

@DefaultUrl("https://www.automationexercise.com/")
public class HomePage extends PageObject {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className="fc-button-label")
    private WebElementFacade cookieAcceptButton;

    @FindBy(className = "navbar-nav")
    private WebElementFacade linksContainer;

    public void acceptCookies() {
        cookieAcceptButton.click();
    }

    public void clickProductsButton() {
        List<WebElement> links = linksContainer.findElements(By.tagName("a"));
        for(WebElement link: links) {
            System.out.println(link.getText());
        }
        System.out.println(links.get(1).getText());
        links.get(1).click();
    }
}
