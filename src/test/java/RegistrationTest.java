import io.qameta.allure.Description;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.Browser;
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
        registrationPage.scrollToRegisterLink();
        registrationPage.clickRegisterButton();
        assertEquals("URL после регистрации должен соответствовать странице регистрации",
                "https://stellarburgers.nomoreparties.site/register",
                driver.getCurrentUrl());
        registrationPage.waitForNameField();
        registrationPage.inputName("Bobik");
        registrationPage.waitForEmailField();
        registrationPage.inputEmail("sobaka@yandex.ru");
        registrationPage.waitForPasswordField();
        registrationPage.inputPassword("gavgavgav");
        registrationPage.clickRegisterLink();
        assertEquals("URL после регистрации должен соответствовать странице логина",
                "https://stellarburgers.nomoreparties.site/login",
                driver.getCurrentUrl());
    }

    @Test
    @Description("Проверка регистрации с коротким паролем")
    public void testRegistrationWithShortPassword() {
        registrationPage.clickLoginButton();
        registrationPage.scrollToRegisterLink();
        registrationPage.clickRegisterButton();
        assertEquals("URL после регистрации должен соответствовать странице регистрации",
                "https://stellarburgers.nomoreparties.site/register",
                driver.getCurrentUrl());
        registrationPage.waitForNameField();
        registrationPage.inputName("Pyshok");
        registrationPage.waitForEmailField();
        registrationPage.inputEmail("kotik@yandex.ru");
        registrationPage.waitForPasswordField();
        registrationPage.inputPassword("myr");
        registrationPage.clickRegisterLink();
        assertTrue("Сообщение об ошибке должно быть видимо", registrationPage.isPasswordErrorVisible());
        assertEquals("Некорректный текст ошибки", "Некорректный пароль", registrationPage.getPasswordErrorMessage());
    }
}