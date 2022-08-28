import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BaseMethods{

    By selectProductLocator = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[5]/div/div[2]/div[1]");
    By filterAreaLocator = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/button");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean checkIfProductsPage() {
        return isDisplayed(filterAreaLocator);
    }

    public void selectProduct() {
        scrollToElement(selectProductLocator);
        click(selectProductLocator,30);
    }
}
