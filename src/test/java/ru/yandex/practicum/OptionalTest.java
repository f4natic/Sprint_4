package ru.yandex.practicum;

import org.junit.Test;
import ru.yandex.practicum.base.BaseTest;
import ru.yandex.practicum.page.MainPage;
import ru.yandex.practicum.page.OrderStatusPage;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static ru.yandex.practicum.base.Constants.SCOOTER_URL;

public class OptionalTest extends BaseTest {

    @Test
    public void shouldReturnNoSuchOrder() {
        driver.get(SCOOTER_URL);

        MainPage mainPage = new MainPage(driver);
        mainPage.acceptCookie();
        mainPage.clickOnOrderStatus().waitOrderStatusElements().fillOrderNumber("abcdef").clickGoButton();
        OrderStatusPage orderStatusPage = new OrderStatusPage(driver);
        assertEquals(true, orderStatusPage.isNoSuchOrder());
    }

    @Test
    public void shouldMoveToMainPage() {
        driver.get(SCOOTER_URL);

        MainPage mainPage = new MainPage(driver);
        mainPage.acceptCookie().clickScooterAnchor();
        assertEquals(true, mainPage.isMainPage());
    }

    @Test
    public void shouldMoveToYaPage() {
        driver.get(SCOOTER_URL);

        MainPage mainPage = new MainPage(driver);
        mainPage.acceptCookie().clickYaAnchor();
        boolean result = false;
        Set<String> windowHandles = driver.getWindowHandles();
        for(String handle:windowHandles) {
            result |= driver.switchTo().window(handle).getCurrentUrl().contains("dzen");
        }
        assertTrue(result);
    }
}
