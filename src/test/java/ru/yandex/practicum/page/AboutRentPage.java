package ru.yandex.practicum.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AboutRentPage {
    private WebDriver driver;
    private By dateInput = By.xpath(".//input[contains(@placeholder,'* Когда привезти самокат')]");
    private By time = By.className("Dropdown-root");
    private By commentInput = By.xpath(".//input[contains(@placeholder,'Комментарий для курьера')]");
    private By confirmButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']");

    public AboutRentPage(WebDriver driver) {
        this.driver = driver;
    }

    public AboutRentPage fillDateInput(String date) {
        driver.findElement(dateInput).sendKeys(date);
        driver.findElement(By.xpath(String.format(".//div[@role='button' and text()='%s']",date.substring(0, 1)))).click();
        return this;
    }

    public AboutRentPage fillTimeInput(int numberElement) {
        driver.findElement(time).click();
        List<WebElement> elements = driver.findElements(By.className("Dropdown-option"));
        elements.get(numberElement).click();
        return this;
    }

    public AboutRentPage chooseColor(String color) {
        driver.findElement(By.id(color)).click();
        return this;
    }

    public AboutRentPage fillComment(String comment) {
        driver.findElement(commentInput).sendKeys(comment);
        return this;
    }

    public AboutRentPage confirm() {
        driver.findElement(confirmButton).click();
        return this;
    }

}
