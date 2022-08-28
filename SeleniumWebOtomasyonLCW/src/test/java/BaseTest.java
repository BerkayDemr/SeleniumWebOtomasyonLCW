import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;
import java.util.Arrays;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BaseTest {
    WebDriver driver;
    @BeforeAll
    public void setup(){
        ChromeOptions options = new ChromeOptions();
        //Chrome otomasyon aracı tarafından çalıştırılıyor bildirimini engeller.
        options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
        // bildirimleri engeller
        options.addArguments("--disable-notifications");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.get("https://www.lcwaikiki.com/tr-TR/TR");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }


    @AfterAll
    public void tearDown(){
        //Test bittiğinde veya hataya düştüğünde pencereleri kapatır.
        driver.quit();
    }


}