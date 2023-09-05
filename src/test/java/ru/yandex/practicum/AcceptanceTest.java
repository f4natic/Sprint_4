package ru.yandex.practicum;

import org.junit.Test;
import ru.yandex.practicum.base.BaseTest;

import static org.junit.Assert.assertEquals;

public class AcceptanceTest extends BaseTest {

    @Test
    public void shouldGetPageTitle() {
        String title = driver.getTitle();
        String expected = "Example Domain";
        assertEquals(expected, title);
    }
}
