package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import project.properties.BasePage;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;


public class MainPage extends BasePage {
    @FindBy(xpath = "//span[contains(@class, 'title') and contains(text(), 'Расходы')]")
    private WebElement costsBtn;

    @FindBy(xpath = "//span[text()='Командировки']")
    private WebElement dropDownList;

    public void costsClick() {
        costsBtn.click();
    }

    public void assignmentClick() {
        wait.until(visibilityOf(dropDownList));
        dropDownList.click();
        loading();
    }

}
