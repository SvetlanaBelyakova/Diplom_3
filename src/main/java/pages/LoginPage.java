package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private final WebDriver driver;

    // Локатор кнопки "Войти в аккаунт"
    @FindBy(xpath = "//button[text()='Войти в аккаунт']")
    private WebElement loginButton;

    // Локатор кнопки регистрации
    @FindBy(xpath = "//a[@href='/register']")
    private WebElement registrationButton;

    // Локатор кнопки "Личный Кабинет"
    @FindBy(xpath = "//nav//a[@href='/account']")
    private WebElement personalAccountButton;

    // Локатор кнопки "Войти" в форме регистрации
    @FindBy(xpath = "//a[@href='/login']")
    private WebElement registrationLoginButton;

    // Локатор поля ввода email
    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailField;

    // Локатор поля ввода пароля
    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordField;

    // Локатор поля ввода пароля в форме восстановления пароля
    @FindBy(xpath = "//input[@name='recovery-password']")
    private WebElement passwordRecoveryField;

    // Локатор кнопки "Восстановить пароль"
    @FindBy(xpath = "//a[@href='/recover']")
    private WebElement recoverPasswordButton;

    // Локатор кнопки "Войти" в различных формах
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginSubmitButton;

    // Локатор кнопки "Войти" в форме восстановления пароля
    @FindBy(xpath = "//button[@type='submit' and @name='recovery-login']")
    private WebElement recoveryLoginSubmitButton;

    // Локатор кнопки "Конструктор"
    @FindBy(xpath = "//nav//ul//li[1]//a")
    private WebElement builderButton;

    // Локатор кнопки "Выйти"
    @FindBy(xpath = "//button[text()='Выход']")
    private WebElement logoutButton;

    // Локатор логотипа Stellar Burgers
    @FindBy(xpath = "//nav//div[contains(@class, 'logo')]")
    private WebElement stellarBurgersLogo;

    // Конструктор
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Методы для взаимодействия с элементами
    public void clickLoginSubmit() {
        loginSubmitButton.click();
    }

    public void openPersonalAccount() {
        personalAccountButton.click();
    }

    public void openRegistrationLogin() {
        registrationLoginButton.click();
    }

    public void clickRecoverPassword() {
        recoverPasswordButton.click();
    }

    public void inputEmail(String email) {
        emailField.sendKeys(email);
    }

    public void inputPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void inputRecoveryPassword(String password) {
        passwordRecoveryField.sendKeys(password);
    }

    public void clickRecoveryLoginSubmit() {
        recoveryLoginSubmitButton.click();
    }

    public void logout() {
        logoutButton.click();
    }
}