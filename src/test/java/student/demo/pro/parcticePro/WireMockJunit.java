package student.demo.pro.parcticePro;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import java.io.IOException;
import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.Assert.*;


public class WireMockJunit {
    @Rule
    public WireMockRule wireMockRule=new WireMockRule(8084);
    private  WireMockServer wireMockServer;

   @BeforeEach
   void setup(){
       wireMockServer = new WireMockServer();
       configureFor("localhost", 8084);
       wireMockServer.start();

   }

    @Test
    public void TestWireMock() throws IOException {
        stubFor(any((anyUrl())).willReturn(ok()));
       // configureStub();
        OkHttpClient client=new OkHttpClient().newBuilder().build();
        Request request= new Request.Builder().url("http://localhost:8084/getAll").method("GET",null).build();
        Response response=client.newCall(request).execute();
        assertNotNull(response);
    }

//    private void configureStub() {
//        configureFor("localhost",8084);
//        wireMockServer.start();
//        stubFor(get(urlEqualTo("getAll")).willReturn(aResponse().withBody("employee is present"))
//        );
//    }

   @AfterEach
   void after(){

       wireMockServer.stop();
   }


}
