package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConstructorPage {
    private final WebDriver driver;

    // Локатор для раздела "Булки"
    @FindBy(xpath = "//span[text()='Булки']")
    private WebElement bunsSection;

    // Локатор для раздела "Соусы"
    @FindBy(xpath = "//span[text()='Соусы']")
    private WebElement saucesSection;

    // Локатор для раздела "Начинки"
    @FindBy(xpath = "//span[text()='Начинки']")
    private WebElement fillingsSection;

    // Локатор заголовка активного раздела "Соусы"
    @FindBy(xpath = "(//h2)[2]") // Предполагается, что заголовки идут по порядку
    private WebElement activeSaucesHeader;

    // Локатор заголовка активного раздела "Начинки"
    @FindBy(xpath = "(//h2)[3]") // Предполагается, что заголовки идут по порядку
    private WebElement activeFillingsHeader;

    // Локатор заголовка активного раздела "Булки"
    @FindBy(xpath = "(//h2)[1]") // Предполагается, что заголовки идут по порядку
    private WebElement activeBunsHeader;

    // Конструктор
    public ConstructorPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Методы для взаимодействия с элементами
    public void selectSaucesSection() {
        saucesSection.click();
    }

    public String retrieveSaucesHeaderText() {
        return activeSaucesHeader.getText();
    }

    public void selectFillingsSection() {
        fillingsSection.click();
    }

    public String retrieveFillingsHeaderText() {
        return activeFillingsHeader.getText();
    }

    public void selectBunsSection() {
        bunsSection.click();
    }

    public String retrieveBunsHeaderText() {
        return activeBunsHeader.getText();
    }
}