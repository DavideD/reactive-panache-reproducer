package org.acme.hibernate.orm.panache;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.text.IsEmptyString.emptyString;

@QuarkusTest
public class FruitsEndpointTest {
	final int REQUESTS = 10;

    @Test
    public void testBlocking() {
		for ( int i = 0; i < REQUESTS; i++ ) {
			Response response = given()
					.get( "/payload/blocking/22" )
					.then()
					.statusCode( 200 )
					.contentType( "application/json" )
					.extract().response();
			assertThat( response.jsonPath().getString( "payload" ) ).isEqualTo( "Source 2" );
			Thread.yield();
		}
	}

	@Test
	public void testReactive() {
		for ( int i = 0; i < REQUESTS; i++ ) {
			Response response = given()
					.get( "/payload/reactive/22" )
					.then()
					.statusCode( 200 )
					.contentType( "application/json" )
					.extract().response();
			assertThat( response.jsonPath().getString( "payload" ) ).isEqualTo( "Source 2" );
		}
	}
}
