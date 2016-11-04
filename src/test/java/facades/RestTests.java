/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.parsing.Parser;
import static org.hamcrest.Matchers.*;

/**
 *
 * @author Staal
 */
public class RestTests {

    public RestTests() {
    }

    @BeforeClass
    public static void setUpClass() {

        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8084;
        RestAssured.basePath = "/CA3";
        RestAssured.defaultParser = Parser.JSON;

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void serverIsRunningV2() {
        given().when().get().then().statusCode(200);

    }

    @Test
    public void GetUserByUsername() {
        given().param("username", "Thomas")
                .when()
                .get("http://localhost:8084/api/user/userByUsername/{username}")
                .then().statusCode(200).
                body("username", equalTo("Thomas"));
                
                
    }

}
