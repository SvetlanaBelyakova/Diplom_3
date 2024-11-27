import io.qameta.allure.Description;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.Browser;

import java.util.Collection;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AccountConstructorTest extends BaseTest {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Browser.getBrowserData();
    }

    public AccountConstructorTest(String browser) {
        super(browser);
    }

    private final String LOGIN_URL = "https://stellarburgers.nomoreparties.site/";
    private final String PROFILE_URL = "https://stellarburgers.nomoreparties.site/account/profile";

    // При нажатии на кнопку личного кабинета, появляется страница с логином
    @Test
    @Description("Тестирование перехода из личного кабинета в конструктор при нажатии на «Конструктор»")
    public void testConstructorButtonFromPersonalCabinet() {
        loginPage.openPersonalAccount();
        loginPage.inputEmail("kotik@yandex.ru");
        loginPage.inputPassword("myrmyrmyrmyr");
        loginPage.clickLoginSubmit();
        assertEquals("URL после входа должен быть главной страницей", LOGIN_URL, driver.getCurrentUrl());
        loginPage.openPersonalAccount();
        assertEquals("URL после входа в аккаунт и повторного клика по кнопке «Личный кабинет» должен вести на страницу профиля", PROFILE_URL, driver.getCurrentUrl());
        loginPage.openBuilder();
        assertEquals("URL после нажатия кнопки Конструктор из личного кабинета должен быть главной страницей", LOGIN_URL, driver.getCurrentUrl());
    }

    // При нажатии на кнопку личного кабинета, появляется страница с логином
    @Test
    @Description("Тестирование перехода из личного кабинета в конструктор при нажатии на логотип Stellar Burgers")
    public void testConstructorButtonFromStellarBurgersLogo() {
        loginPage.openPersonalAccount();
        loginPage.inputEmail("sobaka@yandex.ru");
        loginPage.inputPassword("gavgavgav");
        loginPage.clickLoginSubmit();
        assertEquals("URL после входа должен быть главной страницей", LOGIN_URL, driver.getCurrentUrl());
        loginPage.openPersonalAccount();
        assertEquals("URL после входа в аккаунт и повторного клика по кнопке «Личный кабинет» должен вести на страницу профиля", PROFILE_URL, driver.getCurrentUrl());
        loginPage.clickOnStellarBurgersLogo();
        assertEquals("URL после нажатия на логотип Stellar Burgers должен быть главной страницей", LOGIN_URL, driver.getCurrentUrl());
    }
}