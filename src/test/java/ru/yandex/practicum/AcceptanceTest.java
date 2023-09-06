package ru.yandex.practicum;

import org.junit.Test;
import ru.yandex.practicum.base.BaseTest;

import static org.junit.Assert.assertEquals;
import static ru.yandex.practicum.base.Constants.EXAMPLE_URL;

public class AcceptanceTest extends BaseTest {
    @Test
    public void shouldGetPageTitle() {
        driver.get(EXAMPLE_URL);

        String title = driver.getTitle();
        String expected = "Example Domain";
        assertEquals(expected, title);
    }
}
