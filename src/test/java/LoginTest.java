import io.qameta.allure.Description;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.Browser;
import pages.Constants;

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

    @Test
    @Description("Тестирование входа по кнопке 'Войти в аккаунт' на главной странице")
    public void testLoginViaLoginAccountButton() {
        registrationPage.clickLoginButton();
        loginPage.inputEmail(Constants.TEST_USER_EMAIL);
        loginPage.inputPassword(Constants.TEST_USER_PASSWORD);
        loginPage.clickLoginSubmit();
        assertEquals("URL после входа должен быть страницей профиля", Constants.PROFILE_URL, driver.getCurrentUrl());
    }

    @Test
    @Description("Тестирование входа через кнопку 'Личный кабинет'")
    public void testLoginViaPersonalCabinetButton() {
        loginPage.openPersonalAccount();
        loginPage.inputEmail(Constants.TEST_USER_EMAIL);
        loginPage.inputPassword(Constants.TEST_USER_PASSWORD);
        loginPage.clickLoginSubmit();
        assertEquals("URL после входа должен быть страницей профиля", Constants.PROFILE_URL, driver.getCurrentUrl());
    }

    @Test
    @Description("Тестирование входа через кнопку в форме регистрации")
    public void testLoginViaRegisterFormButton() {
        registrationPage.clickLoginButton();
        registrationPage.scrollToRegisterLink();
        registrationPage.clickRegisterButton();
        loginPage.openRegistrationLogin();
        loginPage.inputEmail(Constants.TEST_USER_EMAIL);
        loginPage.inputPassword(Constants.TEST_USER_PASSWORD);
        loginPage.clickLoginSubmit();
        assertEquals("URL после входа должен быть страницей профиля", Constants.PROFILE_URL, driver.getCurrentUrl());
    }

    @Test
    @Description("Тестирование входа через кнопку в форме восстановления пароля")
    public void testLoginViaForgotPasswordButton() {
        registrationPage.clickLoginButton();
        registrationPage.scrollToRegisterLink();
        loginPage.clickRecoverPassword();
        loginPage.inputEmail(Constants.TEST_USER_EMAIL);
        loginPage.inputRecoveryPassword(Constants.TEST_USER_PASSWORD);
        loginPage.clickRecoveryLoginSubmit();
        assertEquals("URL после входа должен быть страницей профиля", Constants.PROFILE_URL, driver.getCurrentUrl());
    }
}