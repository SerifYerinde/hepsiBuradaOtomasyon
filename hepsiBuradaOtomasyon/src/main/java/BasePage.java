import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;


public class BasePage {
    protected WebDriver driver;//web driver tanımlandı
    public Logger log= LogManager.getLogger(getClass().getName());

    public BasePage(WebDriver driver) {
        //UI Function classlarındaki loglama için properties dosyasının yolu gösterilmiştir.
        PropertyConfigurator.configure("C:\\Users\\SerifYerinde\\IdeaProjects\\hepsiBuradaOtomasyon\\src\\test\\java\\resources\\log4j.properties");        //Testten gelen web driver için null dönmemesi gerektiğinden ve program ilk yüklendiğinde driver hazır olması için (constructor) tanımlandı.
        this.driver = driver;
        }


    public WebElement element(By Locator){
        //Web element için global değişken tanımlandı.
        // Element bekleme süresi ayarlandı
        // Parametre olarak verdiğimiz locatorı bulup o web elementi bize dönecektir
        WebDriverWait wait =new WebDriverWait(driver, 90);
        return wait.until(ExpectedConditions.elementToBeClickable(Locator));

        //return driver.findElement(Locator);
    }




    public void sendKeys(By Locator, String value){
        //Element içine yazı yazma için global değişken tanımlandı
        element(Locator).sendKeys(value);
    }

    public void clicks(By Locator){

        //Elementlere tıklama için global değişken tanımlandı
        element(Locator).click();
    }




}
