import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//Ortak methotların kullanıldığı sınıf.

public class BaseMethods {
    WebDriver driver;

    public BaseMethods(WebDriver driver) {
        this.driver = driver;
    }
    //İlgili elemente scroll'lama işlemi yapan metot.
    public void scrollToElement(By locator){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //İstenilen web elementi görüntülene kadar scroll işlemi sürer
        WebElement webelement_locator = driver.findElement(locator);
        js.executeScript("arguments[0].scrollIntoView();", webelement_locator);

    }
    //İlgili elementin üzerine gider.
    public void moveToElement(By locator){
        WebElement element = driver.findElement(locator);
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }
    //Web elementini bulan metot.
    public WebElement find(By locator){
        return driver.findElement(locator);
    }

    //Tıklama işlemini yapan metot.
    public void click(By locator, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    //Var olan bir elementin ekranda gösterilip gösterilmediğini kontrol eder.
    public Boolean isDisplayed(By locator){
        return find(locator).isDisplayed();
    }
}