package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class RegistrationPage {
    private WebDriver driver;

    // Локатор кнопки "Войти в аккаунт"
    @FindBy(xpath = "//button[contains(text(),'Войти в аккаунт')]")
    private WebElement loginButton;

    // Локатор кнопки регистрации
    @FindBy(xpath = "//*[@id='root']/div/main/div/div/p[1]/a")
    private WebElement registerButton;

    // Локатор поля ввода имени
    @FindBy(xpath = "//input[@name='name']")
    private WebElement nameField;

    // Локатор поля ввода email
    @FindBy(xpath = "//*[@id='root']/div/main/div/form/fieldset[2]/div/div/input")
    private WebElement emailField;

    // Локатор поля ввода пароля
    @FindBy(xpath = "//*[@id='root']/div/main/div/form/fieldset[3]/div/div/input")
    private WebElement passwordField;

    // Локатор кнопки "Зарегистрироваться"
    @FindBy(xpath = "//*[@id='root']/div/main/div/form/button")
    private WebElement registerButtonClick;

    // Локатор сообщения об ошибке пароля
    @FindBy(xpath = "//*[@id='root']/div/main/div/form/fieldset[3]/div/p")
    private WebElement passwordErrorMessage;

    // Конструктор
    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Ожидание появления поля ввода имени
    public void waitForNameField() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(nameField));
    }

    // Ожидание появления поля ввода email
    public void waitForEmailField() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(emailField));
    }

    // Ожидание появления поля ввода пароля
    public void waitForPasswordField() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(passwordField));
    }

    // Прокрутка к кнопке регистрации
    public void scrollToRegisterLink() {
        WebElement registerLink = driver.findElement(By.xpath("//*[@id='root']/div/main/div/div/p[1]/a"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", registerLink);
    }

    // Методы для взаимодействия с элементами
    public void clickLoginButton() {
        loginButton.click();
    }

    public void clickRegisterLink() {
        registerButton.click();
    }

    public void inputName(String name) {
        nameField.sendKeys(name);
    }

    public void inputEmail(String email) {
        emailField.sendKeys(email);
    }

    public void inputPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickRegisterButton() {
        registerButtonClick.click();
    }

    public boolean isPasswordErrorVisible() {
        return passwordErrorMessage.isDisplayed();
    }

    public String getPasswordErrorMessage() {
        return passwordErrorMessage.getText();
    }
}