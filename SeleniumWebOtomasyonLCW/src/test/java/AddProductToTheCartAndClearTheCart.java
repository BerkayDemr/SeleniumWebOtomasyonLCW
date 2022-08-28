import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class AddProductToTheCartAndClearTheCart extends BaseTest{

    HomePage homePage;
    CategoryPage categoryPage;
    ProductsPage productsPage;
    ProductDetailPage productDetailPage;
    CartPage cartPage;

    @Test
    @Order(1)
    public void goToCategory(){
        homePage = new HomePage(driver);
        categoryPage = new CategoryPage(driver);
        //Cookies bildirimi çıkarsa, cookies'ler kabul edilir.
        homePage.acceptCookies();
        //Kategori seçilir.
        homePage.selectCategory();
        Assertions.assertTrue(categoryPage.checkIfCategoryPage(),
                "The page is not category page!");

    }
    @Test
    @Order(2)
    public void goToProductPage(){
        categoryPage = new CategoryPage(driver);
        productsPage =new ProductsPage(driver);
        //Bir ürün tipi seçilerek, ürünler sayfasına gidilir.
        categoryPage.selectProductType();
        Assertions.assertTrue(productsPage.checkIfProductsPage(),
                "The page is not products page!");

    }
    @Test
    @Order(3)
    public void selectProductAndAddToCart(){
        productsPage =new ProductsPage(driver);
        productDetailPage =new ProductDetailPage(driver);
        //Ürünler sayfasından bir ürün seçilir.
        productsPage.selectProduct();
        Assertions.assertTrue(productDetailPage.checkIfProductDetailPage(),
                "The page is not product detail page!");
        //ürün sepete eklenir.
        productDetailPage.addToCart();

    }
    @Test
    @Order(4)
    public void goToCartPage(){
        homePage = new HomePage(driver);
        cartPage = new CartPage(driver);
        //Sepet sayfasına gidilir.
        homePage.goToCart();
        Assertions.assertTrue(cartPage.checkIfCartPage(),
                "The page is not cart page!");

    }
    @Test
    @Order(5)
    public void backToHomePage(){
        homePage = new HomePage(driver);
        //Ana sayfaya geri dönülür.
        homePage.backToHomePage();
        Assertions.assertTrue(homePage.checkIfHomePage(),
                "The page is not home page!");

    }
}
