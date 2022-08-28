import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage extends BaseMethods{

    By acceptCookiesLocator = By.xpath("//*[@id=\"cookieseal-banner\"]/div/button[2]");
    By selectCaegoryLocator = By.xpath("//*[@id=\"header__container\"]/header/div[3]/nav/ul/li[1]/a");
    By goToCartLocator = By.xpath("//*[@id=\"header__container\"]/header/div[1]/div[3]/div/div[2]/a");
    By homePageButtonLocator = By.xpath("//*[@id=\"header__container\"]/header/div[1]/div[1]/a");
    By checkHomePageLocator = By.xpath("//*[@id=\"container\"]/div[1]/div/div[2]/div");
    By popUpCloseLocator = By.xpath("//*[@id=\"close-button-1454703513202\"]/span");
    By productQuantityIndicatorLocator = By.xpath("//*[@id=\"header__container\"]/header/div[1]/div[3]/div/div[2]/a/span[2]");
    public HomePage(WebDriver driver) {
        super(driver);
    }

    // Cookies bildirimi çıkarsa, cookies'leri kabul eden metot.
    public void acceptCookies() {
        //Kampanya penceresi açılırsa kapatılır.
        if(isDisplayed(popUpCloseLocator)){
            click(popUpCloseLocator,30);
        }
        List<WebElement> list_acceptCookiesLocator = driver.findElements(acceptCookiesLocator);
        if (list_acceptCookiesLocator.size() != 0) {
            click(acceptCookiesLocator, 30);
        }
    }

    public void selectCategory(){
        click(selectCaegoryLocator,30);
    }

    public void goToCart(){
        //Ürünün sepete eklenmesini bekler.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(productQuantityIndicatorLocator));

        click(goToCartLocator,30);

    }

    public void backToHomePage(){
        click(homePageButtonLocator,30);

    }

    public boolean checkIfHomePage(){
        return isDisplayed(checkHomePageLocator);
    }
}
