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
import pages.RegistrationPage;
import settings.Constants;
import settings.WebDriverCreator;
import user.UserApi;

import static org.hamcrest.Matchers.equalTo;

@DisplayName("Регистрация нового пользователя")
public class RegistrationPageTest {
    private WebDriver webDriver;
    private RegistrationPage regPage;
    private String name;
    private String email;
    private String password;
    Faker faker = new Faker();


    @Before
    @Step("Запуск браузера, подготовка тестовых данных")
    public void startUp() {
        String browserName = System.getProperty("browser", "chrome");
        webDriver = WebDriverCreator.createDriver(browserName);
        webDriver.get(Constants.REGISTER_PAGE_URL);
        regPage = new RegistrationPage(webDriver);


        name = faker.name().firstName();
        email = faker.internet().safeEmailAddress();
        password = faker.letterify("12345678");

        Allure.addAttachment("Имя", name);
        Allure.addAttachment("Email", email);
        Allure.addAttachment("Пароль", password);
    }

    @After
    @Step("Закрытие браузера, очистка тестовых данных")
    public void tearDown() {
        webDriver.quit();
        new UserApi().deleteUser(email, password);
    }

    @Test
    @DisplayName("Регистрация нового пользователя с валидными данными")
    public void registerNewUserIsSuccess() {
        Allure.parameter("Браузер", System.getProperty("browser", "chrome"));


        regPage.setName(name);
        regPage.setEmail(email);
        regPage.setPassword(password);

        regPage.clickRegisterButton();

        regPage.waitFormSubmitted("Вход");
    }

    @Test
    @DisplayName("Регистрация нового пользователя с коротким паролем (4 символа)")
    public void registerNewUserIncorrectPasswordIsFailed() {
        Allure.parameter("Браузер", System.getProperty("browser", "chrome"));


        regPage.setName(name);
        regPage.setEmail(email);
        regPage.setPassword(faker.letterify("3333"));

        regPage.clickRegisterButton();

        regPage.waitErrorIsVisible();

        checkErrorMessage();
    }


    @Step("Проверка появления сообщения об ошибке")
    private void checkErrorMessage() {
        MatcherAssert.assertThat(
                "Некорректное сообщение об ошибке",
                regPage.getErrorMessage(),
                equalTo("Некорректный пароль")
        );
    }
}