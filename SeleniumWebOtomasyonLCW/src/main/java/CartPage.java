import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage extends BaseMethods{

    By checkCartPageLocator = By.xpath("//*[@id=\"ShoppingCartContent\"]/div[1]/div[2]/div[1]/a");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean checkIfCartPage() {
        //Sepet sayfası açılana kadar beklenir.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkCartPageLocator));

        return isDisplayed(checkCartPageLocator);
    }
}
