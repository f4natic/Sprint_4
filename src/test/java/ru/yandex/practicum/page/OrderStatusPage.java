package ru.yandex.practicum.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderStatusPage {
    private WebDriver driver;
    private By noSuchOrderDiv = By.xpath(".//img[@src='/assets/not-found.png']");

    public OrderStatusPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isNoSuchOrder() {
        return driver.findElement(noSuchOrderDiv).getAttribute("alt").equals("Not found");
    }
}
