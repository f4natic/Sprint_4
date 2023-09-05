package ru.yandex.practicum.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
    protected WebDriver driver;
    protected final String EXAMPLE_URL = "https://example.org/";

    @Before
    public void init() {
        String driverType = System.getenv("driverType") == null ? "chrome" : System.getenv("driverType");
        switch (driverType) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            default:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
        }
        driver.get(EXAMPLE_URL);
    }

    @After
    public void close() {
        driver.quit();
    }
}
