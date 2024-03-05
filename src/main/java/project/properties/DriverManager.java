package project.properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Properties;

import static java.lang.System.setProperty;

public class DriverManager {
    private static WebDriver driver;
    private static Properties properties = TestProperties.getINSTANCE().getProperties();

    public static WebDriver getWebDriver(){
        if (driver == null){
            initDriver();
        }
        return driver;
    }
    public static void initDriver(){
        setProperty("webdriver.chrome.driver", properties.getProperty("WEB_DRIVER_PATH")); // Установка пути к драйверу Chrome
        driver = new ChromeDriver(); // Создание экземпляра ChromeDriver
        driver.get(properties.getProperty("HOST_NAME"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().setScriptTimeout(Duration.ofMillis(500));
        driver.manage().window().maximize();
    }


    public static void closeDriver(){
        driver.quit();
    }
}
