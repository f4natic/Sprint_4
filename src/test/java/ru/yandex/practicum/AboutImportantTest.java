package ru.yandex.practicum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.practicum.base.BaseTest;
import ru.yandex.practicum.page.AboutImportantPage;
import ru.yandex.practicum.page.MainPage;

import static org.junit.Assert.assertEquals;
import static ru.yandex.practicum.base.Constants.SCOOTER_URL;

@RunWith(Parameterized.class)
public class AboutImportantTest extends BaseTest {

    private final int id;
    private final boolean answerDisplayed;

    public AboutImportantTest(int id, boolean answerDisplayed) {
        this.id = id;
        this.answerDisplayed = answerDisplayed;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][] {
                {0, true}, {1, true}, {2, true},
                {3, true}, {4, true}, {5, true},
                {6, true}, {7, true},
        };
    }

    @Test
    public void shouldShowTextOnClick() {
        driver.get(SCOOTER_URL);

        MainPage mainPage = new MainPage(driver);
        mainPage.acceptCookie();

        AboutImportantPage infoPage = new AboutImportantPage(driver);
        infoPage.scrollToImportant();
        infoPage.clickOnQuestion(id);
        assertEquals(String.format("На %d вопросе не показывается ответ", id), answerDisplayed, infoPage.answerOnQuestion(id));
    }
}
