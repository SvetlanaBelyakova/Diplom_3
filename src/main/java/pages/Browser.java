package pages;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Browser {
    // Метод для получения данных о браузерах для запуска тестов
    public static Collection<Object[]> getBrowserData() {
        List<Object[]> browsers = new ArrayList<>();
        browsers.add(new Object[]{"chrome"});
        browsers.add(new Object[]{"yandex"});
        return browsers;
    }
}