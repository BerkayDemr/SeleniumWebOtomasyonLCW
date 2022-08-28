import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CategoryPage extends BaseMethods{
    By selectProductTypeLocator = By.xpath("//*[@id=\"landingPageContainer\"]/div/div[1]/div[1]/a[2]");
    By selectAnotherProductTypeLocator = By.xpath("//*[@id=\"landingPageContainer\"]/div/div[2]/div[1]/a[2]");
    By scrollAnotherProductTypeLocater = By.xpath("//*[@id=\"landingPageContainer\"]/div/div[2]");
    By checkCategoryPageLocator = By.id("container");

    public CategoryPage(WebDriver driver) {
        super(driver);
    }

    public void selectProductType() {
        //Kategori sayfasında üst tarafında bazen gelen kategori alanının gelip gelmediğini kontrol edilerek
        // ona göre kategori seçimi yapılır.
        List<WebElement> list_selectProductTypeLocator = driver.findElements(selectProductTypeLocator);
        if(list_selectProductTypeLocator.size() != 0){
            click(selectProductTypeLocator,30);
        }
        else{
            scrollToElement(scrollAnotherProductTypeLocater);
            click(selectAnotherProductTypeLocator,30);
        }

    }

    public boolean checkIfCategoryPage() {
        return isDisplayed(checkCategoryPageLocator);
    }
}
