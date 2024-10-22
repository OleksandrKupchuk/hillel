package api;
import api.models.Pet;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PetApi {

    public Response createPet(Pet body){
        return RestAssured
                .given()
                .body(body)
                .post("/pet");
    }

    public Response updatePet(Pet body){
        return RestAssured
                .given()
                .body(body)
                .put("/pet");
    }

    public Response updatePet(int id, String name, String status){
        return  RestAssured.given()
                        .pathParams("id", id)
                        .queryParam("name", name)
                        .queryParam("status", status)
                        .request("POST", "/pet/{id}");
    }

    public Response deletePet(int petId){
        return RestAssured
                .given()
                .delete("/pet/{id}", petId);
    }
}
