
import io.qameta.allure.Step;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import pages.*;

public abstract class BaseTest {
    protected WebDriver driver;
    protected RegistrationPage registrationPage;
    protected LoginPage loginPage;
    protected ConstructorPage constructorPage;
    protected final String browser;

    public BaseTest(String browser) {
        this.browser = browser;
    }

    @Step("Инициализация WebDriver")
    @Before
    public void setUp() {
        driver = BrowserType.valueOf(browser.toUpperCase()).createDriver();
        driver.get(Constants.BASE_URL);
        registrationPage = new RegistrationPage(driver);
        loginPage = new LoginPage(driver);
        constructorPage = new ConstructorPage(driver);
    }

    @Step("Закрытие WebDriver и удаление пользователя")
    @After
    public void tearDown() {
        try {
            // Удаление пользователя после теста
            UserService.deleteUser (Constants.TEST_USER_EMAIL);
        } catch (Exception e) {
            // Логирование ошибки при удалении пользователя
            System.err.println("Ошибка при удалении пользователя: " + e.getMessage());
        } finally {
            if (driver != null) {
                driver.quit(); // Закрытие WebDriver
            }
        }
    }
}