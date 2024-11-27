package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    // Локатор кнопки "Войти в аккаунт"
    @FindBy(xpath = "//button[contains(text(),'Войти в аккаунт')]")
    private WebElement loginButton;

    // Локатор кнопки регистрации
    @FindBy(xpath = "//*[@id='root']/div/main/div/div/p[1]/a")
    private WebElement registrationButton;

    // Локатор кнопки "Личный Кабинет"
    @FindBy(xpath = "//*[@id='root']/div/header/nav/a/p")
    private WebElement personalAccountButton;

    // Локатор кнопки "Войти" в форме регистрации
    @FindBy(xpath = "//a[text()='Войти']")
    private WebElement registrationLoginButton;

    // Локатор поля ввода email
    @FindBy(xpath = "//*[@id='root']/div/main/div/form/fieldset[1]/div/div/input")
    private WebElement emailField;

    // Локатор поля ввода пароля
    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordField;

    // Локатор поля ввода пароля в форме восстановления пароля
    @FindBy(xpath = "//*[@id='root']/div/main/div/form/fieldset/div/div/input")
    private WebElement passwordRecoveryField;

    // Локатор кнопки "Восстановить пароль"
    @FindBy(xpath = "//*[@id='root']/div/main/div/div/p[2]/a")
    private WebElement recoverPasswordButton;

    // Локатор кнопки "Войти" в различных формах
    @FindBy(xpath = "//button[text()='Войти']")
    private WebElement loginSubmitButton;

    // Локатор кнопки "Войти" в форме восстановления пароля
    @FindBy(xpath = "//*[@id='root']/div/main/div/div/p/a")
    private WebElement recoveryLoginSubmitButton;

    // Локатор кнопки "Конструктор"
    @FindBy(xpath = "//*[@id='root']/div/header/nav/ul/li[1]/a/p")
    private WebElement builderButton;

    // Локатор кнопки "Выйти"
    @FindBy(xpath = "//button[text()='Выход']")
    private WebElement logoutButton;

    // Локатор логотипа Stellar Burgers
    @FindBy(xpath = "//*[@id='root']/div/header/nav/div")
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

    public void openBuilder() {
        builderButton.click();
    }

    public void logout() {
        logoutButton.click();
    }

    public void clickOnStellarBurgersLogo() {
        stellarBurgersLogo.click();
    }
}