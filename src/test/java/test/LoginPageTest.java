package test;

import com.github.javafaker.Faker;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.MainPage;
import pages.PasswordPage;
import pages.RegistrationPage;
import settings.Constants;
import settings.WebDriverCreator;
import user.UserApi;

import java.time.Duration;

import static org.hamcrest.Matchers.equalTo;

@DisplayName("Авторизация пользователя")
public class LoginPageTest {
    private WebDriver webDriver;
    private LoginPage loginPage;
    private MainPage mainPage;
    private RegistrationPage regPage;
    private PasswordPage passwordPage;
    private String name;
    private String email;
    private String password;
    Faker faker = new Faker();

    @Before
    @Step("Запуск браузера, подготовка тестовых данных")
    public void startUp() {
        String browserName = System.getProperty("browser", "chrome");
        webDriver = WebDriverCreator.createDriver(browserName);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webDriver.get(Constants.MAIN_PAGE_URL);

        loginPage = new LoginPage(webDriver);
        mainPage = new MainPage(webDriver);
        regPage = new RegistrationPage(webDriver);
        passwordPage = new PasswordPage(webDriver);

        name = faker.name().firstName();
        email = faker.internet().safeEmailAddress();
        password = faker.letterify("???????");

        Allure.addAttachment("Имя", name);
        Allure.addAttachment("Email", email);
        Allure.addAttachment("Пароль", password);

        new UserApi().createUser(name, email, password);
    }

    @After
    @Step("Закрытие браузера, очистка тестовых данных")
    public void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
        new UserApi().deleteUser(email, password);
    }

    @Step("Авторизация пользователя")
    private void authUser() {
        loginPage.setEmail(email);
        loginPage.setPassword(password);
        loginPage.clickAuthButton();
        loginPage.waitFormSubmitted();
    }

    @Test
    @DisplayName("Вход через клик по кнопке 'Войти в аккаунт' на главной")
    public void authFromMainPageButtonIsSuccess() {
        Allure.parameter("Браузер", System.getProperty("browser", "chrome"));

        mainPage.clickAuthButton();
        loginPage.waitAuthFormVisible();
        authUser();

        MatcherAssert.assertThat(
                "Текст на кнопке 'Войти в аккаунт' должен поменяться на 'Оформить заказ'",
                mainPage.getAuthButtonText(),
                equalTo("Оформить заказ")
        );
    }

    @Test
    @DisplayName("Вход через клик по кнопке 'Личный Кабинет' в хеддере страницы")
    public void authFromProfileButtonIsSuccess() {
        Allure.parameter("Браузер", System.getProperty("browser", "chrome"));

        mainPage.clickLinkToProfile();
        loginPage.waitAuthFormVisible();
        authUser();

        MatcherAssert.assertThat(
                "Текст на кнопке 'Войти в аккаунт' должен поменяться на 'Оформить заказ'",
                mainPage.getAuthButtonText(),
                equalTo("Оформить заказ")
        );
    }

    @Test
    @DisplayName("Вход через формy восстановления пароля")
    public void authLinkFromForgotPasswordFormIsSuccess() {
        Allure.parameter("Браузер", System.getProperty("browser", "chrome"));

        webDriver.get(Constants.FORGOT_PASSWORD_URL);

        regPage.clickAuthLink();
        loginPage.waitAuthFormVisible();
        authUser();

        MatcherAssert.assertThat(
                "Текст на кнопке 'Войти в аккаунт' должен поменяться на 'Оформить заказ'",
                mainPage.getAuthButtonText(),
                equalTo("Оформить заказ")
        );
    }
}