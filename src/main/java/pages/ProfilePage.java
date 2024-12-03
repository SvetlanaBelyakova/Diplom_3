package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage {
    private final WebDriver webDriver;

    // Упрощенные XPath-локаторы
    private final By constructorButton = By.xpath("//p[contains(@class,'AppHeader_header__linkText') and text()='Конструктор']");
    private final By logoLink = By.xpath("//div[contains(@class,'AppHeader_header__logo')]/a");
    private final By profileNavLink = By.xpath("//a[contains(@class, 'Account_link_active')]");
    private final By logOutLink = By.xpath("//nav[contains(@class, 'Account_nav')]//li/button");
    private final By modalOverlay = By.xpath("//div[contains(@class, 'Modal_modal_overlay')]");

    public ProfilePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void waitAuthFormVisible() {
        new WebDriverWait(webDriver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOfElementLocated(profileNavLink));
    }

    public void waitButtonIsClickable() {
        new WebDriverWait(webDriver, Duration.ofSeconds(30))
                .until(ExpectedConditions.invisibilityOfElementLocated(modalOverlay));
    }

    public void clickConstructorButton() {
        waitButtonIsClickable();
        webDriver.findElement(constructorButton).click();
    }

    public void clickLinkOnLogo() {
        waitButtonIsClickable();
        webDriver.findElement(logoLink).click();
    }

    public void clickLogoutButton() {
        waitButtonIsClickable();
        webDriver.findElement(logOutLink).click();
    }
}
