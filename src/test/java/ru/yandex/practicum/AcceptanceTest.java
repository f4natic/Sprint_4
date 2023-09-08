package ru.yandex.practicum;

import org.junit.Test;
import ru.yandex.practicum.base.BaseTest;

import static org.junit.Assert.assertEquals;

//Класс для проверки, что selenium и webdriver manager работают
public class AcceptanceTest extends BaseTest {
    private String exampleUrl = "https://example.org/";
    @Test
    public void shouldGetPageTitle() {
        driver.get(exampleUrl);

        String title = driver.getTitle();
        String expected = "Example Domain";
        assertEquals(expected, title);
    }
}
