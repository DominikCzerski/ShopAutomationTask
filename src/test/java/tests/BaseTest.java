package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class BaseTest {

    protected static WebDriver driver;
    private final String pageUrl = "http://automationpractice.com";

    @BeforeEach
    public void driverStart() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(pageUrl);
    }

   @AfterEach
    public void driverQuit() {
        driver.quit();
    }

}
