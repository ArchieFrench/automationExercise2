package pages;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

@DefaultUrl("https://automationexercise.com/login")
public class SignupPage extends PageObject {
    @FindBy(xpath="//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]")
    private WebElementFacade usernameField;
    @FindBy(xpath="//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]")
    private WebElementFacade emailField;
    @FindBy(xpath="//*[@id=\"form\"]/div/div/div[3]/div/form/button")
    private WebElementFacade signupButton ;

    public void enterUserName(String username) {
        usernameField.type(username);
    }

    public void enterEmail(String email) {
        emailField.type(email);
    }

    public void clickLoginButton() {
        signupButton.click();
    }
}
