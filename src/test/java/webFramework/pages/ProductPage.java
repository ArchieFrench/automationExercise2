package webFramework.pages;

import io.cucumber.java.be.I;
import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

@DefaultUrl("https://www.automationexercise.com/products")
public class ProductPage extends PageObject {

    @FindBy(className = "single-products")
    List<WebElementFacade> products;

    @FindBy(className="fa-shopping-cart")
    WebElementFacade cart;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void scrollDownPage() throws InterruptedException {
        Actions actions = new Actions(getDriver());
        actions.scrollByAmount(0,600).perform();
    }

    public void addNthItemToCart(int n) throws InterruptedException {
        Actions actions = new Actions(getDriver());
        actions
                .moveToElement(products.get(n))
                .moveToElement(products.get(n).findElement(By.className("add-to-cart")))
                .click().perform();
    }

    public void clickContinueShopping() throws InterruptedException {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(getDriver().findElement(By.xpath("//*[@id=\"cartModal\"]/div/div/div[3]/button"))).click().perform();
    }

    public void clickViewCartButton() {
        cart.click();
    }
}
