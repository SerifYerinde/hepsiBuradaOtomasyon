import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.concurrent.TimeUnit;

public class Listener extends BaseTest implements ITestListener {

    public void onTestStart(ITestResult ıTestResult) {}

    public void onTestSuccess(ITestResult ıTestResult) {//Test başarılı ise return bilgisi loglanmaktadır
        log.info(ıTestResult); }

    public void onTestFailure(ITestResult ıTestResult) {//Test başarısız ise return bilgisi loglanmaktadır
        log.error(ıTestResult.getThrowable()); }

    public void onTestSkipped(ITestResult ıTestResult) {  log.warn(ıTestResult); }

    public void onTestFailedButWithinSuccessPercentage(ITestResult ıTestResult) { }



    public void onFinish(ITestContext ıTestContext) {//test herhangi bir sebeple bitirildiğinde burdaki komutlar çalışacaktır
        //driver.quit();
        log.info("Browser kapatıldı");
    }


    public void onStart(ITestContext ıTestContext) {//kod çalışmaya burdan başlayacak

//loglama yapılmaya başlanması için properties dosyasının yolu belirtildi
        PropertyConfigurator.configure("C:\\Users\\SerifYerinde\\IdeaProjects\\hepsiBuradaOtomasyon\\src\\test\\java\\resources\\log4j.properties");



    }
}
