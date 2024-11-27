import io.qameta.allure.Description;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.Browser;

import java.util.Collection;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LogoutTest extends BaseTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Browser.getBrowserData();
    }
    public LogoutTest(String browser) {
        super(browser);
    }

    private static final String LOGIN_URL = "https://stellarburgers.nomoreparties.site/";
    private static final String PROFILE_URL = "https://stellarburgers.nomoreparties.site/account/profile";

    //  При входе в аккаунт при нажатии по кнопке личного кабинета, после входа появляется страница логина
    @Test
    @Description("Тестирование выхода из аккаунта по кнопке «Выйти» в личном кабинете")
    public void testExitButton() {
        registrationPage.clickLoginButton();
        loginPage.inputEmail("kotik@yandex.ru");
        loginPage.inputPassword("myrmyrmyrmyr");
        loginPage.clickLoginSubmit();
        assertEquals("URL после входа должен быть главной страницей", LOGIN_URL, driver.getCurrentUrl());
        loginPage.openPersonalAccount();
        assertEquals("URL после входа в аккаунт и повторного клика по кнопке «Личный кабинет» должен быть переход на страницу профиля", PROFILE_URL, driver.getCurrentUrl());
        // Клик по кнопке "Выход"
        loginPage.logout();
    }
}
