package tests.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MoviesTest {

    @Test
    public void getAllMovies() {
        Response movies = RestAssured
                .given()
                .log()
                .all()
                .when()
                .get("https://dummyapi.online/api/movies");

        movies.then().statusCode(200);
        movies.prettyPrint();
    }

    @Test
    public void getMovieById() {
        Response movie = RestAssured
                .given()
                .log()
                .all()
                .when()
                .get("https://dummyapi.online/api/movies/{id}", 7);

        movie.then().statusCode(200);
        movie.prettyPrint();
        String movieName = movie.jsonPath().get("movie");

        Assert.assertEquals("Fight Club", movieName);
    }
}
