package ru.yandex.practicum;

import org.junit.Test;
import ru.yandex.practicum.base.BaseTest;
import ru.yandex.practicum.page.*;

import static org.junit.Assert.assertEquals;
import static ru.yandex.practicum.base.Constants.SCOOTER_URL;

public class OrderTest extends BaseTest {

    @Test
    public void shouldCreateOrderFromTopButton() {
        driver.get(SCOOTER_URL);
        new MainPage(driver).acceptCookie().clickOnTopOrderButton();
        new ForWhomPage(driver).fillNameInput("Джон").fillLastNameInput("Доу")
                .fillAddressInput("ул.Питерская").clickOnMetro("Тверская")
                .fillPhoneInput("+79990001919").clickNext();
        new AboutRentPage(driver).fillDateInput("21.10.2023")
                .fillTimeInput(1).chooseColor("black").fillComment("-").confirm();
        new ConfirmPage(driver).confirmOrder();
        OrderSuccessPage orderSuccessPage = new OrderSuccessPage(driver);
        assertEquals(true, orderSuccessPage.orderExist());
    }

    @Test
    public void shouldCreateOrderFromBottomButton() {
        driver.get(SCOOTER_URL);
        new MainPage(driver).acceptCookie().clickOnBottomOrderButton();
        new ForWhomPage(driver).fillNameInput("Николай").fillLastNameInput("Николаев")
                .fillAddressInput("Красный проспект").clickOnMetro("Сокол")
                .fillPhoneInput("88005553535").clickNext();
        new AboutRentPage(driver).fillDateInput("12.12.2027")
                .fillTimeInput(1).chooseColor("grey").fillComment("Доп номер ххххххххххх").confirm();
        new ConfirmPage(driver).confirmOrder();
        OrderSuccessPage orderSuccessPage = new OrderSuccessPage(driver);
        assertEquals(true, orderSuccessPage.orderExist());
    }
}
