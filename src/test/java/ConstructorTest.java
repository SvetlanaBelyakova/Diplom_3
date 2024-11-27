
import io.qameta.allure.Description;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.Browser;

import java.util.Collection;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ConstructorTest extends BaseTest {

    @Parameterized.Parameters
    public static Collection<Object[]> parameters() {
        return Browser.getBrowserData(); // Получение параметров из внешнего класса
    }

    public ConstructorTest(String selectedBrowser) {
        super(selectedBrowser);
    }

    @Test
    @Description("Проверка перехода в раздел 'Соусы'")
    public void selectSaucesSection() {
        constructorPage.selectSaucesSection();
        assertEquals("Соусы", constructorPage.retrieveSaucesHeaderText());
    }

    @Test
    @Description("Проверка перехода в раздел 'Начинки'")
    public void selectFillingsSection() {
        constructorPage.selectFillingsSection();
        assertEquals("Начинки", constructorPage.retrieveFillingsHeaderText());
    }

    @Test
    @Description("Проверка перехода в раздел 'Булки'")
    public void selectBunsSection() {
        constructorPage.selectSaucesSection();
        constructorPage.selectBunsSection();
        assertEquals("Булки", constructorPage.retrieveBunsHeaderText());
    }
}