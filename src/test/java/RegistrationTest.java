import io.qameta.allure.Description;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.Browser;
import pages.Constants;

import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class RegistrationTest extends BaseTest {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Browser.getBrowserData();
    }

    public RegistrationTest(String browser) {
        super(browser);
    }

    @Test
    @Description("Проверка успешной регистрации пользователя")
    public void testSuccessfulRegistration() {
        registrationPage.clickLoginButton();
        registrationPage.inputName("Pyshok");
        registrationPage.inputEmail(Constants.TEST_USER_EMAIL);
        registrationPage.inputPassword(Constants.TEST_USER_PASSWORD);
        registrationPage.clickRegisterButton();
        assertEquals("URL после регистрации должен соответствовать странице логина", Constants.LOGIN_URL, driver.getCurrentUrl());
    }

    @Test
    @Description("Проверка регистрации с коротким паролем")
    public void testRegistrationWithShortPassword() {
        registrationPage.clickLoginButton();
        registrationPage.inputName("Pyshok");
        registrationPage.inputEmail(Constants.TEST_USER_EMAIL);
        registrationPage.inputPassword("myr");
        registrationPage.clickRegisterButton();
        // Предполагается, что метод проверки ошибки будет реализован в RegistrationPage
        assertTrue("Сообщение об ошибке должно быть видимо", registrationPage.isPasswordErrorVisible());
        assertEquals("Некорректный текст ошибки", "Некорректный пароль", registrationPage.getPasswordErrorMessage());
    }
}