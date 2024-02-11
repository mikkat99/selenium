package ru.katkova.tests;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;


public class TrainingAppline {
    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void before() {
        System.setProperty("webdriver.chrome.driver", "src/test/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 30);

        driver.get("http://training.appline.ru/user/login");
    }

    @Test
    public void test() {
        WebElement titleLogin = driver.findElement(By.xpath("//h2"));
        Assert.assertTrue("Страничка не загрузилась", titleLogin.isDisplayed() &&
                titleLogin.getText().contains("Логин"));
        String errorMessage = "Текст не совпал\n" +
                "Ожидали: Логин\n" +
                "Фактическое: " + titleLogin.getText();
        Assert.assertTrue(errorMessage, "Логин".equals(titleLogin.getText()));

        //Авторизация
        String expectedLogin = "Taraskina Valeriya";
        String expectedPassword = "testing";
        fullInputField(driver.findElement(By.xpath("//fieldset//input[contains(@id, 'prependedInput') and contains(@type, 'text')]")), expectedLogin);
        fullInputField(driver.findElement(By.xpath("//fieldset//input[contains(@id, 'prependedInput') and contains(@type, 'password')]")), expectedPassword);
        String actualLogin = driver.findElement(By.xpath("//fieldset//input[contains(@id, 'prependedInput') and contains(@type, 'text')]")).getAttribute("value");
        String actualPassword = driver.findElement(By.xpath("//fieldset//input[contains(@id, 'prependedInput') and contains(@type, 'password')]")).getAttribute("value");
        Assert.assertTrue("Необходимое значение не введено в поле логина", actualLogin.contains(expectedLogin));
        Assert.assertTrue("Необходимое значение не введено в поле пароля", actualPassword.contains(expectedPassword));

        WebElement buttonEnter = driver.findElement(By.xpath("//button[contains(@type, 'submit')]"));
        buttonEnter.click();

        //Проверка заголовка "Панель быстрого запуска"
        WebElement titleTraining = driver.findElement(By.xpath("//h1[contains(@class, 'oro-subtitle')]"));
        Assert.assertTrue("Страничка не загрузилась", titleTraining.isDisplayed() &&
                titleTraining.getText().contains("Панель быстрого запуска"));
        String errorMessage2 = "Текст заголовка таблицы не совпал\n" +
                "Ожидали: Панель быстрого запуска\n" +
                "Фактическое: " + titleTraining.getText();
        Assert.assertTrue(errorMessage2, "Панель быстрого запуска".equals(titleTraining.getText()));



        //Открытие страницы Командировки
        WebElement menuExspenses = driver.findElement(By.xpath("//span[contains(@class, 'title') and contains(text(), 'Расходы')]"));
        menuExspenses.click();

        WebElement menuSubitem = driver.findElement(By.xpath("//span[text()='Командировки']"));
        menuSubitem.click();
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[@class='loader-mask shown']"))));


        WebElement businessTrip = driver.findElement(By.xpath("//h1[contains(@class, 'oro-subtitle')]"));
        String expectedTitle = "Все Командировки";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(@class, 'oro-subtitle')]")));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//h1[contains(@class, 'oro-subtitle')]"), expectedTitle));
        assertEquals("Текст заголовка не совпал. Ожидали: " + expectedTitle +
                ". Фактическое: " + businessTrip.getText(), expectedTitle, businessTrip.getText());


        //Нажатие кнопки Создать командировку
        WebElement buttonCreate = driver.findElement(By.xpath("//a[(text()='Создать командировку') and (contains(@class, 'btn back icons-holder-text '))]"));
        buttonCreate.click();

        //Проверка наличия на странице заголовка "Создать командировку"
        WebElement creatureElement = driver.findElement(By.xpath("//h1[contains(@class, 'user-name')]"));
        String titleExpected = "Создать командировку";
        Assert.assertTrue("Страничка не загрузилась", creatureElement.isDisplayed());
        Assert.assertTrue("Текст заголовка таблицы не совпал. Ожидали: " + titleExpected +
                        ". Фактическое: " + creatureElement.getText(),
                creatureElement.getText().contains(titleExpected));

        //Выбор подразделения Отдел внутренней разработки
        WebElement division = driver.findElement(By.xpath("//select[contains(@name, 'crm_business_trip[businessUnit]')]"));
        division.click();
        Assert.assertTrue("Клик не был совершен", division.getAttribute("name").contains("crm_business_trip[businessUnit]"));


        WebElement subitemMenu = driver.findElement(By.xpath("//option[text()='Отдел внутренней разработки']"));
        subitemMenu.click();
        Assert.assertTrue("Нужный отдел не  выбран", subitemMenu.getText().contains("Отдел внутренней разработки"));

        //Нажатие "Открыть список"
        WebElement listOpen = driver.findElement(By.xpath("//a[text()='Открыть список']"));
        listOpen.click();

        //Выбор организации
        WebElement pointOut = driver.findElement(By.xpath("//span[contains(@class, 'select2-chosen')]"));
        pointOut.click();
        Assert.assertTrue("Клик не был совершен", pointOut.getAttribute("class").contains("select2-chosen"));
        WebElement organization = driver.findElement(By.xpath("//div[contains(text(), '(Safari) Призрачная Организация Охотников')]"));
        organization.click();
        Assert.assertTrue("Клик не был совершен", pointOut.getText().contains("(Safari) Призрачная Организация Охотников"));


        //Постановка чекбокса на "Заказ билетов"
        WebElement checkBox = driver.findElement(By.xpath("//input[contains(@type, 'checkbox') and contains(@name, 'crm_business_trip[tasks][]')]"));
        checkBox.click();
        Assert.assertTrue("Клик не был совершен", checkBox.getAttribute("type").contains("checkbox"));

        //Указание города прибытия
        String expectedCity = "Тула";
        fullInputField(driver.findElement(By.xpath("//input[contains(@type, 'text') and contains(@name, 'crm_business_trip[arrivalCity]')]")), expectedCity);
        String actualCity = driver.findElement(By.xpath("//input[contains(@type, 'text') and contains(@name, 'crm_business_trip[arrivalCity]')]")).getAttribute("value");
        Assert.assertTrue("Необходимое значение не введено в поле город прибытия", actualCity.contains(expectedCity));

        //Указание даты выезда и возвращения
        String expectedDate1 = "12.02.2024";
        WebElement dataExit = driver.findElement(By.xpath("//input[contains(@class, 'datepicker-input') and contains(@name, 'departureDatePlan')]"));
        dataExit.click();
        WebElement data1 = driver.findElement(By.xpath("//a[@class='ui-state-default' and text()='12']"));
        data1.click();
        String actualDate1 = dataExit.getAttribute("value");
        Assert.assertTrue("Необходимое значение не введено в поле дата выезда", actualDate1.contains(expectedDate1));

        String expectedDate2 = "13.02.2024";
        WebElement dataArrival = driver.findElement(By.xpath("//input[contains(@class, 'datepicker-input') and contains(@name, 'returnDatePlan')]"));
        dataArrival.click();
        WebElement data2 = driver.findElement(By.xpath("//td[@data-handler='selectDay']/a[text()='13']"));
        data2.click();
        String actualDate2 = dataArrival.getAttribute("value");
        Assert.assertTrue("Необходимое значение не введено в поле дата возвращения", actualDate2.contains(expectedDate2));


        //Нажатие Сохранить и закрыть
        WebElement saveExit = driver.findElement(By.xpath("//button[contains(@type, 'submit') and contains(text(), 'Сохранить и закрыть')]"));
        saveExit.click();
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[@class='loader-mask shown']"))));

        //Проверка сообщения: "Список командируемых сотрудников не может быть пустым"
        WebElement message = driver.findElement(By.xpath("//span[contains(@class, 'validation-failed') and contains(text(), 'Список командируемых сотрудников не может быть пустым')]"));
        Assert.assertTrue("Клик не был совершен", message.getText().contains("Список командируемых сотрудников не может быть пустым"));
    }

    @After
    public void after() {
        driver.quit();
    }


    /**
     * Явное ожидание кликабельности элемента
     */
    private void waitUtilElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Заполнение полей значениями
     */
    private void fullInputField(WebElement element, String value) {
        waitUtilElementToBeClickable(element);
        element.click();
        element.clear();
        element.sendKeys(value);
        boolean checkFlag = wait.until(ExpectedConditions.attributeContains(element, "value", value));
        Assert.assertTrue("Поле было заполнено некорректно", checkFlag);

    }

}