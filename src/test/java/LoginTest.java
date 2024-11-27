import io.qameta.allure.Description;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.Browser;

import java.util.Collection;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LoginTest extends BaseTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Browser.getBrowserData();
    }
    public LoginTest(String browser) {
        super(browser);
    }

    private static final String LOGIN_URL = "https://stellarburgers.nomoreparties.site/login";

    @Test
    @Description("Тестирование входа по кнопке 'Войти в аккаунт' на главной странице")
    public void testLoginViaLoginAccountButton() {
        registrationPage.clickLoginButton();
        loginPage.inputEmail("sobaka@yandex.ru");
        loginPage.inputPassword("gavgavgav");
        loginPage.clickLoginSubmit();
        assertEquals("URL после входа должен быть страницей логина", LOGIN_URL, driver.getCurrentUrl());
    }

    @Test
    @Description("Тестирование входа через кнопку 'Личный кабинет'")
    public void testLoginViaPersonalCabinetButton() {
        loginPage.openPersonalAccount();
        loginPage.inputEmail("sobaka@yandex.ru");
        loginPage.inputPassword("gavgavgav");
        loginPage.clickLoginSubmit();
        assertEquals("URL после входа должен быть страницей логина", LOGIN_URL, driver.getCurrentUrl());
    }

    @Test
    @Description("Тестирование входа через кнопку в форме регистрации")
    public void testLoginViaRegisterFormButton() {
        registrationPage.clickLoginButton();
        registrationPage.scrollToRegisterLink();
        registrationPage.clickRegisterButton();
        loginPage.openRegistrationLogin();
        loginPage.inputEmail("kotik@yandex.ru");
        loginPage.inputPassword("myrmyrmyrmyr");
        loginPage.clickLoginSubmit();
        assertEquals("URL после входа должен быть страницей логина", LOGIN_URL, driver.getCurrentUrl());
    }

    @Test
    @Description("Тестирование входа через кнопку в форме восстановления пароля")
    public void testLoginViaForgotPasswordButton() {
        registrationPage.clickLoginButton();
        registrationPage.scrollToRegisterLink();
        loginPage.clickRecoverPassword();
        loginPage.inputEmail("kotik@yandex.ru");
        loginPage.inputRecoveryPassword("myrmyrmyrmyr");
        loginPage.clickRecoveryLoginSubmit();
        assertEquals("URL после входа должен быть страницей логина", LOGIN_URL, driver.getCurrentUrl());
    }
}