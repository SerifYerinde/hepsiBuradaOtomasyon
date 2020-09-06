import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;


public class BaseTest {
    //UI testleri için üst class oluşturulmuştur. Farklı UI testleri yapılırken driver dönüş ayarlamaları BasePage classından buraya aktarılmaktadırç
    public static WebDriver driver;
    public Logger log= LogManager.getLogger(getClass().getName());

}
