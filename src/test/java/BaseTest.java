
import org.openqa.selenium.WebDriver;
import io.qameta.allure.Step;
import org.junit.After;
import org.junit.Before;
import pages.ConstructorPage;
import pages.LoginPage;
import pages.RegistrationPage;
import pages.WebDriverConfigurator;
import java.util.concurrent.TimeUnit;

public abstract class BaseTest {
    protected WebDriver driver;
    protected RegistrationPage registrationPage;
    protected LoginPage loginPage;
    protected ConstructorPage constructorPage;
    protected final String BASE_URL = "https://stellarburgers.nomoreparties.site/";
    protected final String browser;

    public BaseTest(String browser) {
        this.browser = browser;
    }

    @Step("Инициализация WebDriver")
    @Before
    public void setUp() {
        driver = WebDriverConfigurator.initializeDriver(browser);
        driver.get(BASE_URL);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        registrationPage = new RegistrationPage(driver);
        loginPage = new LoginPage(driver);
        constructorPage = new ConstructorPage(driver);
        System.out.println("Тест выполняется в браузере: " + browser);
    }

    @Step("Закрытие WebDriver")
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}