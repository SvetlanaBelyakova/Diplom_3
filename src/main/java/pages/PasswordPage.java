package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PasswordPage {
    private final WebDriver webDriver;

    // Упрощенные XPath-локаторы
    private final By authLink = By.xpath("//a[contains(@class,'Auth_link')]");
    private final By modalOverlay = By.xpath("//div[contains(@class, 'Modal_modal')]");

    public PasswordPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void clickAuthLink() {
        waitButtonIsClickable();
        webDriver.findElement(authLink).click();
    }

    private void waitButtonIsClickable() {
        new WebDriverWait(webDriver, Duration.ofSeconds(20))
                .until(ExpectedConditions.invisibilityOfElementLocated(modalOverlay));
    }
}
