package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class WebDriverConfigurator {
    public static WebDriver initializeDriver(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":

                WebDriverManager.chromedriver().browserVersion("131.0.6778.86").setup();
                return new ChromeDriver();

            case "yandex":

                WebDriverManager.chromedriver().browserVersion("128").setup();
                ChromeOptions yandexOptions = new ChromeOptions();
                yandexOptions.setBinary("D:\\Users\\Евгения\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
                return new ChromeDriver(yandexOptions);
                default:
                throw new IllegalArgumentException("Неизвестный браузер: " + browser);
        }
    }
}