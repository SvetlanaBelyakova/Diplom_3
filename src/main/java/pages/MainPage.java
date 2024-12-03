package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private final WebDriver webDriver;

    // Упрощенные XPath-локаторы
    private final By constructorButton = By.xpath("//p[contains(@class,'AppHeader_header__linkText') and text()='Конструктор']");
    private final By orderFeedButton = By.xpath("//p[contains(@class,'AppHeader_header__linkText') and text()='Лента заказов']");

    private final By profileButton = By.xpath(".//p[starts-with(@class,'AppHeader_header__linkText') and text()='Личный Кабинет']");
    private final By bunsButton = By.xpath("//span[text()='Булки']");
    private final By saucesButton = By.xpath("//span[text()='Соусы']");
    private final By fillingsButton = By.xpath("//span[text()='Начинки']");

    private final By bunsTypes = By.xpath("//h2[text()='Булки']");
    private final By saucesTypes = By.xpath("//h2[text()='Соусы']");
    private final By fillingsTypes = By.xpath("//h2[text()='Начинки']");

    private final By authButton = By.xpath(".//div[starts-with(@class,'BurgerConstructor_basket__container')]/button");
    private final By header = By.xpath("//h1[text()='Соберите бургер']");
    private final By modalOverlay = By.xpath(".//div[starts-with(@class, 'App_App')]/div/div[starts-with(@class, 'Modal_modal_overlay')]");

    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void clickAuthButton() {
        waitButtonIsClickable();
        webDriver.findElement(authButton).click();
    }

    public void waitButtonIsClickable() {
        new WebDriverWait(webDriver, Duration.ofSeconds(30))
                .until(ExpectedConditions.invisibilityOfElementLocated(modalOverlay));
    }

    public void waitHeaderIsVisible() {
        new WebDriverWait(webDriver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOfElementLocated(header));
    }

    public void scrollToElementAndWait(By elementLocator) {
        WebElement element = new WebDriverWait(webDriver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOfElementLocated(elementLocator));

        new Actions(webDriver)
                .moveToElement(element)
                .perform();

        new WebDriverWait(webDriver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOf(element));
    }

    public void clickConstructorButton() {
        waitButtonIsClickable();
        webDriver.findElement(constructorButton).click();
    }

    public void clickOrderFeedButton() {
        waitButtonIsClickable();
        webDriver.findElement(orderFeedButton).click();
    }

    public void clickLinkToProfile() {
        waitButtonIsClickable();
        webDriver.findElement(profileButton).click();
    }

    public String getAuthButtonText() {
        return webDriver.findElement(authButton).getText();
    }

    public void clickBunsButton() {
        waitButtonIsClickable();
        webDriver.findElement(bunsButton).click();
        scrollToElementAndWait(bunsTypes);
    }

    public void clickSaucesButton() {
        waitButtonIsClickable();
        webDriver.findElement(saucesButton).click();
        scrollToElementAndWait(saucesTypes);
    }

    public void clickFillingsButton() {
        waitButtonIsClickable();
        webDriver.findElement(fillingsButton).click();
        scrollToElementAndWait(fillingsTypes);
    }
    // Геттер для типов 'Булки'
    public By getBunsTypes() {
        return bunsTypes;
    }

    // Геттер для типов 'Соусы'
    public By getSaucesTypes() {
        return saucesTypes;
    }

    // Геттер для типов 'Начинки'
    public By getFillingsTypes() {
        return fillingsTypes;
    }
}
