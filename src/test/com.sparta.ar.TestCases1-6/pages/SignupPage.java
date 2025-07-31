import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;

@DefaultUrl("https://automationexercise.com/login")
public class SignupPage extends PageObject {
    @FindBy(name="name")
    private WebElementFacade usernameField;
    @FindBy(name="email")
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
