package ru.yandex.practicum;

import org.junit.Test;
import ru.yandex.practicum.base.BaseTest;
import ru.yandex.practicum.page.AboutImportantPage;
import ru.yandex.practicum.page.MainPage;

import static org.junit.Assert.assertEquals;
import static ru.yandex.practicum.base.Constants.SCOOTER_URL;

public class AboutImportantTest extends BaseTest {

    @Test
    public void shouldShowTextOnClick() {
        driver.get(SCOOTER_URL);

        new MainPage(driver).acceptCookie();

        AboutImportantPage infoPage = new AboutImportantPage(driver);
        infoPage.scrollToImportant();
        infoPage.clickOnQuestionOne();
        assertEquals("На первом вопросе не показывается ответ", true, infoPage.answerOneShowText());
        infoPage.clickOnQuestionTwo();
        assertEquals("На втором вопросе не показывается ответ", true, infoPage.answerTwoShowText());
        infoPage.clickOnQuestionThree();
        assertEquals("На третьем вопросе не показывается ответ", true, infoPage.answerThreeShowText());
        infoPage.clickOnQuestionFour();
        assertEquals("На четвертом вопросе не показывается ответ", true, infoPage.answerFourShowText());
        infoPage.clickOnQuestionFive();
        assertEquals("На пятом вопросе не показывается ответ", true, infoPage.answerFiveShowText());
        infoPage.clickOnQuestionSix();
        assertEquals("На шестом вопросе не показывается ответ", true, infoPage.answerSixShowText());
        infoPage.clickOnQuestionSeven();
        assertEquals("На седьмом вопросе не показывается ответ", true, infoPage.answerSevenShowText());
        infoPage.clickOnQuestionEight();
        assertEquals("На восьмом вопросе не показывается ответ", true, infoPage.answerEightShowText());
    }
}
