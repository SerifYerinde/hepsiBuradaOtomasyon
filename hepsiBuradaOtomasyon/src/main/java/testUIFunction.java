import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.xml.sax.Locator;

import java.util.concurrent.TimeUnit;

public class testUIFunction extends BasePage{
    //Web element ayarlamaları yapıldığı için BasePage classından kalıtım alınmıştır

    //Web element ve genel tanımlar aşağıda yapılmıştır
    private By searchText=By.xpath("//input[@value='']");
    private By searchButton=By.cssSelector(".SearchBoxOld-buttonContainer");
    private By productCount=By.cssSelector(".totalCount");
    private By productText=By.cssSelector(".search-item:nth-child(2) .product-title span");
    private By productClick=By.xpath("//a[@data-position='1']");
    private By productName=By.id("product-name");
    private By productReviews=By.xpath("//a[@id='productReviewsTab']");
    private By body=By.xpath("/html/body");
    private By yesSelect=By.xpath("//div[5]/div/div/button/span");
    private By thanksText=By.cssSelector(".ReviewCard-module-34AJ_:nth-child(1) .ReviewCard-module-1ZiTv");
    private By basaDon=By.linkText("Başa dön");
    private By searchSuccessResult=By.cssSelector(".keyword");
    private By searchFailResult=By.cssSelector("b:nth-child(1)");
    public testUIFunction(WebDriver driver) {
        super(driver);


    }
//Burada POM(Her sayfa için bir class yapısı) kullanabilirdim. Fakat küçük bir case olması her bir sayfada tek fonksiyon olması nedeniyle tek classda yönettim
//Her sayfa için ayrı function yapıları kullanıldığından daha sonra classlara ayrılması daha basit olacaktır

    public void searchTest(){

        //arama alanına value değerini yazmaktadır.
        sendKeys(searchText,"iphone");
        //Ara butonuna tıklama yapılmaktadır
        clicks(searchButton);

        //Aranacak değer güncellenirse eğer hataya düşmemesi ve sonucu bize yönlendirmesi yapılmıştır
        try {
            //Ürün dönüşü yapılmışsa eğer dönen ürün sayısını loglamaktadır
            log.info(element(searchSuccessResult).getText()+" aramaıza istinaden "+element(productCount).getText()+" tane ürün bulunmuştur");
        }catch (Exception e){
            //Ürün dönüşü olmamışsa eğer hatayı loglamaktadır.
            log.info(element(searchFailResult).getText()+" aramanıza istinaden ürün bulunamamıştır");
        }
    }
    public void productSelectTest() throws InterruptedException {

        //Dönen ürünlerde ilk sıradakine tıklanmaktadır.
        log.info(element(productText).getText()+" ürününe gidilecektir.");
        clicks(productClick);
        log.info(element(productName).getText()+" ürünü sayfasındasınız");
        //ürün sayfasına geçiş sağlandıktan sonra sayfa dinamik yüklendiği için sayfanın sonuna gidilip başa dönmektedir.
        //Burada  işlemlerin sağlıklı yapılabilmesi için bekleme süresi konmalıdır. Çünkü element yüklenmesine rağmen sayfada gecikme söz konusudur.
        Thread.sleep(150);
       element(body).sendKeys(Keys.END);
        Thread.sleep(150);
       clicks(basaDon);
        Thread.sleep(150);

    }
    public void productReviewsTest(){

        //Ürünün değerlendirmeler tabına tıklamaktadır
        clicks(productReviews);

    }
    public void yesSelectTest() {
try{
    //İlk yorumdaki Evet butonuna tıklamaktadır
    clicks(yesSelect);
    log.info("Evet butonuna tıklanmıştır");
    //Gelen yazı ile beklenen yazı karşılaştırılmaktadır
   Assert.assertEquals(element(thanksText).getText(),"Teşekkür Ederiz.");
   //Beklenen yazı olduğu göstermek amacıyla loglama yapılmıştır
    log.info(element(thanksText).getText()+ " yazısı geldiği gözlenmiştir.");

}catch (Exception e){
    //Hata loglaması yapılmıştır
    log.error(e);

}
        

    }

}
