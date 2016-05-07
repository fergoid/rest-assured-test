package com.fergoid;

import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import org.junit.Test;

import java.math.BigDecimal;

import static com.jayway.restassured.RestAssured.*;
import static com.jayway.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static com.jayway.restassured.module.mockmvc.RestAssuredMockMvc.*;

/**
 * Created by markferguson on 07/05/2016.
 */
public class RestTest {

    @Test
    public void testThatRestCallReturnsOK() {

        Response res = get("/some-uri/");
        assertEquals(200, res.getStatusCode());

        String json = res.asString();
        JsonPath jp = new JsonPath(json);
        assertEquals("mobile"), jp.get("type"));
        assertEquals("verified", jp.get("status"));
        assertEquals("markf", jp.get("username"));
        assertEquals("1", jp.get("id"));
        jp.
    }

    @Test
    public void testGetWithBuilderSyntax() {
        given().
                pathParam("username", "markf").
                pathParam("type", "mobile").
        when().
                get("/get/{username}/event/{type}").
        then().
                statusCode(200).
                body("status", is("verified");
    }
}

