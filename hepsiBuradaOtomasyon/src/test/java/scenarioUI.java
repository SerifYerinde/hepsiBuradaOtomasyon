import org.apache.log4j.PropertyConfigurator;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

@Listeners({Listener.class})
public class scenarioUI extends BaseTest {
    public String baseUrl="http://www.hepsiburada.com";

@BeforeTest
public void setUp(){
    //browser değişkeni atandı. Bu sayede aşağıdaki switch case yapısıyla parametrik olarak browser seçimi yapılabilecek
    String browser = System.getProperty("BROWSER");
    if(browser==null)
    {
        browser = System.getenv("BROWSER");
        if(browser==null)
        {
            //parametrik olarak burada değer ataması yapılıyor
            browser= "chrome";
        }
    }
    switch (browser)
    {
/*WebDriver çağrımı değer atamasına bağlı olarak burdan çağrılmaktadır
Burada chrome-edge tarayıcıları için yaptım sadece, çoklanabilir bir yapı ve bunlar dışında bir değer gelirse chrome çağrılacaktır
 */
        case "chrome":
            System.setProperty("webdriver.chrome.driver","C:\\Users\\SerifYerinde\\IdeaProjects\\hepsiBuradaOtomasyon\\Driver\\chromedriver.exe");
            driver=new ChromeDriver();
            break;
        case "edge":
            System.setProperty("webdriver.edge.driver","C:\\Users\\SerifYerinde\\IdeaProjects\\hepsiBuradaOtomasyon\\Driver\\MicrosoftWebDriver.exe");
            driver = new EdgeDriver();
            break;
        default:
            System.setProperty("webdriver.chrome.driver","C:\\Users\\SerifYerinde\\IdeaProjects\\hepsiBuradaOtomasyon\\Driver\\chromedriver.exe");
            driver=new ChromeDriver();
            break;
    }
    log.info("Tarayıcı açılıyor..."+browser);
    //tarayıcıyı tam boy yapma ve çerezleri kapatma
    driver.manage().window().maximize();
    driver.manage().deleteAllCookies();
//dinamik bekleme
    driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
    driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    driver.get(baseUrl);
    log.info("HepsiBurada anasayfasına giriş yapıldı");
}

@Test
public void scenarioUITestCase() throws InterruptedException {
    //fonksiyonlarımız için class ve içindeki methodlar çağrıldı
    testUIFunction searchFunction=new testUIFunction(driver);
    searchFunction.searchTest();
    searchFunction.productSelectTest();
    searchFunction.productReviewsTest();
    searchFunction.yesSelectTest();





    }
}