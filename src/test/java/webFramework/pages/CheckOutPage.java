package webFramework.pages;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

@DefaultUrl("https://www.automationexercise.com/view_cart")
public class CheckOutPage extends PageObject {

    @FindBy(className="cart_description")
    List<WebElementFacade> itemsDescriptions;

    @FindBy(className="cart_price")
    List<WebElementFacade> itemsPrices;

    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getProductNamesInCart() {
        List<String> productNames = new ArrayList<>();

        for(WebElementFacade itemsDescription: itemsDescriptions) {
            productNames.add(itemsDescription.getText());
        }

        return productNames;
    }

    public double totalPriceOfProducts() {
        double total = 0;
        String price;
        for(WebElementFacade itemPrice: itemsPrices) {
            price = itemPrice.getText();
            price = price.substring(3);
            total += Double.valueOf(price);
        }

        return total;
    }
}
