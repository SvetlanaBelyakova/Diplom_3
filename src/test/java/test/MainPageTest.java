package test;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.MainPage;
import settings.Constants;
import settings.WebDriverCreator;


import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.equalTo;


@DisplayName("Проверка конструктора (главной страницы)")
public class MainPageTest {
    private WebDriver webDriver;
    private MainPage mainPage;


    @Before
    @Step("Запуск браузера")
    public void startUp() {
        String browserName = System.getProperty("browser", "chrome");
        webDriver = WebDriverCreator.createDriver(browserName);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        webDriver.get(Constants.MAIN_PAGE_URL);
        mainPage = new MainPage(webDriver);
    }
    @After
    @Step("Закрытие браузера")
    public void tearDown() {
        webDriver.quit();
    }

    @Test
    @Step("Нажатие на вкладку Булочки")
    @DisplayName("Проверка работы вкладки Булочки в разделе с ингредиентами")
    public void checkScrollToBunsIsSuccess() {
        Allure.parameter("Браузер", System.getProperty("browser", "chrome"));

        mainPage.clickFillingsButton();
        mainPage.clickBunsButton();
        mainPage.scrollToElementAndWait(mainPage.getBunsTypes());

        MatcherAssert.assertThat(
                "Список 'Булочки' не видно на странице",
                webDriver.findElement(mainPage.getBunsTypes()).isDisplayed(),
                equalTo(true)
        );
    }

    @Test
    @Step("Нажатие на вкладку Соусы")
    @DisplayName("Проверка работы вкладки Соусы в разделе с ингредиентами")
    public void checkScrollToSaucesIsSuccess() {
        Allure.parameter("Браузер", System.getProperty("browser", "chrome"));

        mainPage.clickSaucesButton();
        mainPage.scrollToElementAndWait(mainPage.getSaucesTypes());

        MatcherAssert.assertThat(
                "Список 'Соусы' не видно на странице",
                webDriver.findElement(mainPage.getSaucesTypes()).isDisplayed(),
                equalTo(true)
        );
    }

    @Test
    @Step("Нажатие на вкладку Начинки")
    @DisplayName("Проверка работы вкладки Начинки в разделе с ингредиентами")
    public void checkScrollToFillingsIsSuccess() {
        Allure.parameter("Браузер", System.getProperty("browser", "chrome"));

        mainPage.clickFillingsButton();
        mainPage.scrollToElementAndWait(mainPage.getFillingsTypes());

        MatcherAssert.assertThat(
                "Список 'Начинки' не видно на странице",
                webDriver.findElement(mainPage.getFillingsTypes()).isDisplayed(),
                equalTo(true)
        );
    }
}