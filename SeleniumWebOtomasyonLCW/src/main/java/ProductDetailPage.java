import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage extends BaseMethods{
    By getStockPopUpLocator = By.id("evamToolTipTop");
    By closeGetStockPopUpLocator = By.xpath("//*[@id=\"root\"]/div/div[14]");
    By addToCartButtonLocator = By.className("add-to-cart-container");


    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    public boolean checkIfProductDetailPage() {
        //Stok uyarısı çıktımı kontrolü. Eğer çıktıysa kapanması için bir yere tıklanır.
        if(isDisplayed(getStockPopUpLocator)){
            click(closeGetStockPopUpLocator,30);
        }
        return isDisplayed(addToCartButtonLocator);
    }

    public void addToCart() {
        //Sepete eklenmek istenen ürünün stoklarda bulunup bulunmadığı kontrol edilir.
        //Stoklarda bulunan beden seçimi yapılır.

        //Ürün detay sayfasından gösterilen beden sayısını bulur.
        Long SizeCount = driver.findElements(By.id("option-size")).get(0).getText().lines().count();
        Integer IntSizeCount = Math.toIntExact(SizeCount);

        //En fazla bulunan beden sayısı kadar dönülür ve stoğu olan bir beden bulduğunda döngüden çıkılır.
        for (Integer i=1; i<IntSizeCount; i++){

            String SizeQuantity = driver.findElement(By.xpath("//*[@id=\"option-size\"]/a["+i+"]")).getAttribute("data-stock");
            Integer IntSizeQuantity = Integer.valueOf(SizeQuantity);
            if(IntSizeQuantity > 0){
                click(By.xpath("//*[@id=\"option-size\"]/a["+i+"]"),30);
                break;
            }


        }
        click(addToCartButtonLocator,30);
    }
}
