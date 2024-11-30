package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
    private final WebDriver driver;

    // Локатор кнопки "Войти в аккаунт"
    @FindBy(xpath = "//button[text()='Войти в аккаунт']")
    private WebElement loginButton;

    // Локатор кнопки регистрации
    @FindBy(xpath = "//p/a[@href='/register']")
    private WebElement registerButton;

    // Локатор поля ввода имени
    @FindBy(xpath = "//input[@name='name']")
    private WebElement nameField;

    // Локатор поля ввода email
    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailField;

    // Локатор поля ввода пароля
    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordField;

    // Локатор кнопки "Зарегистрироваться"
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement registerButtonClick;

    // Локатор сообщения об ошибке пароля
    @FindBy(xpath = "//fieldset[3]//div//p")
    private WebElement passwordErrorMessage;

    // Конструктор
    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Прокрутка к кнопке регистрации
    public void scrollToRegisterLink() {
        WebElement registerLink = driver.findElement(By.xpath("//p/a[@href='/register']"));
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