package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public enum BrowserType {
    CHROME {
        @Override
        public WebDriver createDriver() {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        }
    },
    YANDEX {
        @Override
        public WebDriver createDriver() {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.setBinary("D:\\Users\\Евгения\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
            return new ChromeDriver(options);
        }
    };

    public abstract WebDriver createDriver();
}