package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import project.properties.BasePage;
//import static org.junit.jupiter.api.Assertions;


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
        String actualLogin = loginRow.getAttribute("value");
        String actualPassword = passwordRow.getAttribute("value");
        //Assertions.assertTrue(actualLogin.contains(login), "Необходимое значение не введено в поле логина");
        //Assertions.assertTrue(actualPassword.contains(password), "Необходимое значение не введено в поле пароля");
    }

    public void submitClick() {

        submitButton.click();
    }
}
