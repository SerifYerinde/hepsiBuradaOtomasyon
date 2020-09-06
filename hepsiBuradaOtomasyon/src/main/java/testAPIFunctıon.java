import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class testAPIFunctıon{

    private Response response;
    private int responseCode;
    private  RequestSpecification request = RestAssured.given().config(RestAssured.config().sslConfig(new SSLConfig().allowAllHostnames()));
    public Logger log= LogManager.getLogger(getClass().getName());

    public void getAPI(){
        try{
            //get isteği için url tanımlaması yapıldı
            response = request.when().get("api/gen/clients/ada").then().extract().response();
            //Response dönüşüne bağlı işlem görecek class çağrıldı
           responseStatus();
        }catch(Exception e){
            //İsteğe karılık response alınamazsa loglama yapılacaktır
            log.error("response alınamadı");
        }

    }
    public void postAPI(){
        try{
            //post isteği için url tanımlaması yapıldı
            response = request.when().post("api/gen/servers").then().extract().response();
            //Response dönüşüne bağlı işlem görecek class çağrıldı
            responseStatus();
        }catch(Exception e){
            //İsteğe karşılık response alınamazsa loglama yapılacaktır
            log.error("Sayfaya istek atılamadı");
        }

    }
    public void responseStatus(){
        //response daki body içeriği değişkenie atanmıştır
        ResponseBody responseBody = response.getBody();
        //response içerisinde dönen statü kodu alınmaktadır.
        responseCode = response.getStatusCode();
        //Statu 200 döndüğündende veya 200 dönmediğinde response code ve response body si loglanmaktadır
        if (responseCode==200){
            log.info("BAŞARILI");
        }else {
            log.error("BAŞARISIZ");
        }
        log.info(responseCode);
        log.info(responseBody.asString());
    }
}
