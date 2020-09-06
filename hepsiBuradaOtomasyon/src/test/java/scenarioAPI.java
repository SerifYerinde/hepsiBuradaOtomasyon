import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners({Listener.class})
public class scenarioAPI {


    @BeforeTest
    public void baseURL(){
        //Restassured testanotationsa bağlı olduğu için teste başlamadan önce public cağrısı yapıldı
        RestAssured.baseURI = "https://generator.swagger.io/";
    }

    //Test annotationsları get/post/delete vb. isteklerde birden fazla servis olabileceği için çoklanma potansiyeline bağlı ayrı oluşturulmuştur
    @Test
    public void scenarioGet(){
        //class içerisindeki get fonksiyonunun çağrısı yapılmıştır
        testAPIFunctıon testAPIFunctıon=new testAPIFunctıon();
        testAPIFunctıon.getAPI();
    }

    @Test
    public void scenarioPOST(){
        //class içerisindeki post fonksiyonunun çağrısı yapılmıştır
        testAPIFunctıon testAPIFunctıon=new testAPIFunctıon();
        testAPIFunctıon.postAPI();
    }


}
