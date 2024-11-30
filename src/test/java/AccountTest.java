
import io.qameta.allure.Description;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.Browser;
import pages.Constants;

import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AccountTest extends BaseTest {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {

        return Browser.getBrowserData();
    }

    public AccountTest(String browser) {

        super(browser);
    }

    @Test
    @Description("Тестирование перехода в личный кабинет по нажатию на кнопку «Личный кабинет»")
    public void testLoginViaPersonalCabinetButton() {
        loginPage.openPersonalAccount();
        loginPage.inputEmail(Constants.TEST_USER_EMAIL);
        loginPage.inputPassword(Constants.TEST_USER_PASSWORD);
        loginPage.clickLoginSubmit();
        assertEquals("После входа URL должен быть главной страницей", Constants.BASE_URL, driver.getCurrentUrl());

        // Повторное нажатие по кнопке личного кабинета после входа
        loginPage.openPersonalAccount();
        assertEquals("После повторного клика по кнопке «Личный кабинет» URL должен вести на страницу профиля", Constants.PROFILE_URL, driver.getCurrentUrl());
    }
}