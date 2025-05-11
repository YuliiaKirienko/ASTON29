import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class PostmanEchoTest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://postman-echo.com";
    }

    @Test
    public void testGetRequest() {
        Response response = given()
                .when()
                .get("/get?foo1=bar1&foo2=bar2")
                .then()
                .extract().response();

        assertEquals(200, response.getStatusCode());
        assertEquals("bar1", response.jsonPath().getString("args.foo1"));
        assertEquals("bar2", response.jsonPath().getString("args.foo2"));
        assertEquals("https://postman-echo.com/get?foo1=bar1&foo2=bar2", response.jsonPath().getString("url"));
    }

    @Test
    public void testPostRawText() {
        String rawText = "This is a raw text request";

        Response response = given()
                .contentType("text/plain")  // Указываем Content-Type для raw text
                .body(rawText)             // Передаём текст напрямую
                .when()
                .post("/post")
                .then()
                .extract().response();

        assertEquals(200, response.getStatusCode());
        assertEquals(rawText, response.jsonPath().getString("data"));

    }

    @Test
    public void testPostFormData() {
        Map<String, String> formParams = new HashMap<>();
        formParams.put("username", "testuser");
        formParams.put("password", "testpass123");
        formParams.put("rememberMe", "true");

        Response response = given()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .formParams(formParams)  // Передаём параметры формы
                .when()
                .post("/post")
                .then()
                .extract().response();

        assertEquals(200, response.getStatusCode());
        assertEquals("testuser", response.jsonPath().getString("form.username"));
        assertEquals("testpass123", response.jsonPath().getString("form.password"));
        assertEquals("true", response.jsonPath().getString("form.rememberMe"));
    }

    @Test
    public void testPutRequest() {
        Response response = given()
                .contentType("application/json")
                .body("{\"updated\":true}")
                .when()
                .put("/put")
                .then()
                .extract().response();

        assertEquals(200, response.getStatusCode());
        assertTrue(response.jsonPath().getBoolean("json.updated"));
    }

    @Test
    public void testPatchRequest() {
        String requestBody = "{\"name\":\"updatedValue\",\"active\":false}";

        Response response = given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .patch("/patch")
                .then()
                .extract().response();

        assertEquals(200, response.getStatusCode());
        assertEquals("updatedValue", response.jsonPath().getString("json.name"));
        assertFalse(response.jsonPath().getBoolean("json.active"));
        assertEquals("https://postman-echo.com/patch", response.jsonPath().getString("url"));
    }

    @Test
    public void testDeleteRequest() {
        Response response = given()
                .when()
                .delete("/delete")
                .then()
                .extract().response();

        assertEquals(200, response.getStatusCode());
        assertEquals("https://postman-echo.com/delete", response.jsonPath().getString("url"));
    }

}