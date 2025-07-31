package webFramework.pages;

import io.cucumber.java.an.E;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


@ExtendWith(SerenityJUnit5Extension.class)
public class TempMain {
    @Managed
    private WebDriver webDriver;

    @Managed
    HomePage homePage;

    @Managed
    ProductPage productPage;

    @Before
    public void setUp() {
        this.webDriver = new ChromeDriver();
        homePage = new HomePage(webDriver);
        productPage = new ProductPage(webDriver);
    }

    @Test
    public void doThis() {
        try {
            homePage.open();
            homePage.acceptCookies();
            homePage.clickProductsButton();

            assertThat(webDriver.getCurrentUrl(), is("https://www.automationexercise.com/products"));

            productPage.scrollDownPage();
            Thread.sleep(1000);
            productPage.addNthItemToCart(1);
            Thread.sleep(1000);
            productPage.clickContinueShopping();

            Thread.sleep(1000);
            productPage.addNthItemToCart(2);
            Thread.sleep(1000);
            productPage.clickContinueShopping();

            Thread.sleep(1000);
            productPage.clickViewCartButton();

            List<String> productNames, productQuantities, productPrices;


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
