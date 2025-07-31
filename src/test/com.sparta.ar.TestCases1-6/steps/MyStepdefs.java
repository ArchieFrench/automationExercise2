import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;


public class MyStepdefs {
    @Managed
    SignUp signUp;

    @Managed
    WebDriver driver;


    @Given("I am on the Signup section")
    public void iAmOnTheSignupSection() {
    }

    @When("I enter an email")
    public void iEnterAnEmail() {
    }

    @And("and a password")
    public void andAPassword() {
    }

    @And("I click the Signup button")
    public void iClickTheSignupButton() {
    }

    @Then("I should land on the Enter Account Information page")
    public void iShouldLandOnTheEnterAccountInformationPage() {
    }

    @Given("I am on the registration page")
    public void iAmOnTheRegistrationPage() {
    }

    @When("I select the title {string}")
    public void iSelectTheTitle(String arg0) {
    }

    @And("I enter the name {string}")
    public void iEnterTheName(String arg0) {
    }

    @And("I enter the email {string}")
    public void iEnterTheEmail(String arg0) {
    }

    @And("I enter the password {string}")
    public void iEnterThePassword(String arg0) {
    }

    @And("I select date of birth {string} {string} {string}")
    public void iSelectDateOfBirth(String arg0, String arg1, String arg2) {
    }

    @And("I check the newsletter subscription")
    public void iCheckTheNewsletterSubscription() {
    }

    @And("I check the special offers subscription")
    public void iCheckTheSpecialOffersSubscription() {
    }

    @And("I enter address information:")
    public void iEnterAddressInformation() {
    }

    @Then("I should see a successful registration message")
    public void iShouldSeeASuccessfulRegistrationMessage() {
    }
}
