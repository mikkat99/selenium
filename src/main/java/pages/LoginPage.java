package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import project.properties.BasePage;

public class LoginPage extends BasePage {
    @FindBy(xpath = "//fieldset//input[contains(@id, 'prependedInput') and contains(@type, 'text')]")
    private WebElement loginRow;
    @FindBy(xpath = "//button[contains(@type, 'submit')]")
    private WebElement submitButton;

    @FindBy(xpath = "//fieldset//input[contains(@id, 'prependedInput') and contains(@type, 'password')]")
    private WebElement passwordRow;

    @FindBy(xpath = "//h2")
    private WebElement titleLogin;

    public void startPage() {

        titleLogin.isDisplayed();
    }

    public void enterLoginAndPassword(String login, String password) {
        loginRow.sendKeys(login);
        passwordRow.sendKeys(password);
    }

    public void submitClick() {

        submitButton.click();
    }
}
