package student.demo.pro.parcticePro;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import student.demo.pro.parcticePro.Model.EmpReq;
import student.demo.pro.parcticePro.entity.Employee;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureTestDatabase
@ActiveProfiles("test")
@TestPropertySource(locations ="classpath:application-test.properties")
public class EmpserviceImplTest {

    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() throws Exception {
        RestAssured.baseURI = "http://localhost:";
        RestAssured.port = 8084;
    }

    @Test
    final void testCreateEmployee() {
        Employee employee = dummyRecord();
        Response response = given().
                contentType("application/json").
                accept("application/json").
                body(employee).
                when().
                post(baseURI + port + "/employee").
                then().
                statusCode(200).
                contentType("application/json").
                extract().response();
        String name = response.jsonPath().getString("name");
        assertNotNull(name);

    }

        @Test
    final void testUpdateEmployee(){
    Employee employee = dummyRecord();

    String baseUrl = "http://localhost:" + port;

    Response response = given()
            .contentType("application/json")
            .accept("application/json")
            .body(employee)
            .when()
            .post(baseUrl + "/updateEmp/3")
            .then()
            .statusCode(405)
            .extract()
            .response();
}
    @Test
    final void  testAllEmployee(){
        Response response=given().
                contentType("application/json").
                accept("application/json").
                when().
                get(baseURI+port+"/getAll").
                then().
                statusCode(200).
                contentType("application/json").
                extract().response();
       // String name=response.jsonPath().getString("name");
        assertNotNull(response);

    }

    public static Employee dummyRecord() {
        Employee employee=new Employee();
        employee.setId(1);
        employee.setAge(23);
        employee.setName("Hari");
        return employee;
    }
}

