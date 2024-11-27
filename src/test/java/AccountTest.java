
import io.qameta.allure.Description;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.Browser;

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
    private final String LOGIN_URL = "https://stellarburgers.nomoreparties.site/";
    private final String PROFILE_URL = "https://stellarburgers.nomoreparties.site/account/profile";

    // При нажатии по кнопке личного кабинета, открывается страница логина вместо главной
    @Test
    @Description("Тестирование перехода в личный кабинет по нажатию на кнопку «Личный кабинет»")
    public void testLoginViaPersonalCabinetButton() {
        loginPage.openPersonalAccount();
        loginPage.inputEmail("kotik@yandex.ru");
        loginPage.inputPassword("myrmyrmyrmyr");
        loginPage.clickLoginSubmit();
        assertEquals("После входа URL должен быть главной страницей", LOGIN_URL, driver.getCurrentUrl());

        // Повторное нажатие по кнопке личного кабинета после входа
        loginPage.openPersonalAccount();
        assertEquals("После повторного клика по кнопке «Личный кабинет» URL должен вести на страницу профиля", PROFILE_URL, driver.getCurrentUrl());
    }
}