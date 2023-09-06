package ru.yandex.practicum.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmPage {
    private WebDriver driver;
    private By confirmButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");
    private By decline = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM Button_Inverted__3IF-i' and text()='Нет']");

    public ConfirmPage(WebDriver driver) {
        this.driver = driver;
    }

    public ConfirmPage confirmOrder() {
        driver.findElement(confirmButton).click();
        return this;
    }
}
