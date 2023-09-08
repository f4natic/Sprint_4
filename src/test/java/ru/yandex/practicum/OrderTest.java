package ru.yandex.practicum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.practicum.base.BaseTest;
import ru.yandex.practicum.base.ButtonType;
import ru.yandex.practicum.page.*;

import static org.junit.Assert.assertEquals;
import static ru.yandex.practicum.base.Constants.SCOOTER_URL;

@RunWith(Parameterized.class)
public class OrderTest extends BaseTest {
    private final ButtonType buttonType;
    private final String firstName;
    private final String lastName;
    private final String address;
    private final String metroStation;
    private final String phoneNumber;
    private final String orderDate;
    private final int dayCount;
    private final String color;
    private final String comment;
    private final boolean isSuccessfull;

    public OrderTest(ButtonType buttonType, String firstName, String lastName,
                     String address, String metroStation, String phoneNumber,
                     String orderDate, int dayCount, String color,
                     String comment, boolean isSuccessfull) {
        this.buttonType = buttonType;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.metroStation = metroStation;
        this.phoneNumber = phoneNumber;
        this.orderDate = orderDate;
        this.dayCount = dayCount;
        this.color = color;
        this.comment = comment;
        this.isSuccessfull = isSuccessfull;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][] {
                {ButtonType.TOP, "Джон", "Доу", "ул. Красная", "Тверская", "+79009000013", "21.10.2023", 1, "black", "-", true},
                {ButtonType.BOTTOM, "Николай", "Николаев", "ул. Красный проспект", "Сокол", "88005553535", "12.12.2027",2, "grey", "Доп номер ххххххххххх", true},
        };
    }

    @Test
    public void shouldCreateOrder() {
        driver.get(SCOOTER_URL);
        MainPage mainPage = new MainPage(driver);
        switch (buttonType) {
            case TOP: mainPage.acceptCookie().clickOnTopOrderButton();
                break;
            case BOTTOM: mainPage.acceptCookie().clickOnBottomOrderButton();
                break;
        }
        ForWhomPage forWhomPage = new ForWhomPage(driver);
        forWhomPage.fillNameInput(firstName).fillLastNameInput(lastName)
                .fillAddressInput(address).clickOnMetro(metroStation)
                .fillPhoneInput(phoneNumber).clickNext();
        AboutRentPage aboutRentPage = new AboutRentPage(driver);
        aboutRentPage.fillDateInput(orderDate)
                .fillTimeInput(dayCount).chooseColor(color).fillComment(comment).confirm();
        ConfirmPage confirmPage = new ConfirmPage(driver);
        confirmPage.confirmOrder();
        OrderSuccessPage orderSuccessPage = new OrderSuccessPage(driver);
        assertEquals(isSuccessfull, orderSuccessPage.orderExist());
    }
}
