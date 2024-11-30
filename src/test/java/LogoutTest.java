import io.qameta.allure.Description;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.Browser;
import pages.Constants;

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

    @Test
    @Description("Тестирование выхода из аккаунта по кнопке «Выйти» в личном кабинете")
    public void testExitButton() {
        loginPage.openPersonalAccount();
        loginPage.inputEmail(Constants.TEST_USER_EMAIL);
        loginPage.inputPassword(Constants.TEST_USER_PASSWORD);
        loginPage.clickLoginSubmit();
        assertEquals("URL после входа должен быть главной страницей", Constants.BASE_URL, driver.getCurrentUrl());
        loginPage.logout();
        assertEquals("URL после выхода должен быть страницей логина", Constants.LOGIN_URL, driver.getCurrentUrl());
    }
}
