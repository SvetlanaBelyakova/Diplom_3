package settings;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverCreator {

    public static ChromeDriver createDriver(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome": {
                ChromeOptions options = new ChromeOptions();
                options.addArguments(
                        "--no-sandbox"
                );
                WebDriverManager.chromedriver().driverVersion("131.0.6778.85").setup();
                return new ChromeDriver(options);
            }
 // команда для тестов в хроме mvn test -Dbrowser=chrome
// команда для тестов в Яндекс.Браузер mvn test -Dbrowser=yandex
            case "yandex": {
                WebDriverManager.chromedriver().browserVersion("128").setup();
                ChromeOptions options = new ChromeOptions();
                options.setBinary("D:\\Users\\Евгения\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
                return new ChromeDriver(options);
//прямой путь у Яндекса оставила, т.к когда делала через системную переменную, то тесты вообще не проходили, потому папка в пути на кириллице
// и нет возможности переименовать т.к комп не дает, без прямого пути просто не работает и пробовала разные методы
            }
            default:
                throw new IllegalArgumentException("Неизвестный браузер: " + browser);
        }
    }
}
