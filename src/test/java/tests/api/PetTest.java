package tests.api;

import api.PetApi;
import api.PetStatus;
import api.actions.PetActions;
import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import api.models.Pet;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PetTest {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://petstore3.swagger.io/api/v3";
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .addHeader("Content-Type", "application/json")
                .build();
    }

    @Test
    public void creteAndDeletePetWithModel() {
        PetActions petActions = new PetActions();
        PetApi petApi = new PetApi();
        Pet pet = petActions.getGeneratedPet();

        Pet createdPet = petApi.createPet(pet).as(Pet.class);

        Assert.assertEquals(pet.getId(), createdPet.getId());

        Response deletePet = petApi.deletePet(pet.getId());
        Assert.assertEquals(200, deletePet.statusCode());
    }

    @Test
    public void updatePetWithBody() {
        Faker faker = new Faker();
        String petNameEdited = faker.animal().name();
        String petStatusEdited = PetStatus.PENDING;
        PetActions petActions = new PetActions();
        PetApi petApi = new PetApi();
        Pet pet = petActions.getGeneratedPet();

        Pet createdPet = petApi.createPet(pet).as(Pet.class);
        createdPet.setName(petNameEdited);
        createdPet.setStatus(petStatusEdited);

        Pet updatedPet = petApi.updatePet(pet).as(Pet.class);

        Assert.assertEquals(pet.getName(), updatedPet.getName());
        Assert.assertEquals(pet.getStatus(), updatedPet.getStatus());

        Response deletePet = petApi.deletePet(pet.getId());
        Assert.assertEquals(200, deletePet.statusCode());
    }

    @Test
    public void updatePetWithFormParams() {
        Faker faker = new Faker();
        String petNameEdited = faker.animal().name();
        PetActions petActions = new PetActions();
        PetApi petApi = new PetApi();
        Pet pet = petActions.getGeneratedPet();

        petApi.createPet(pet).as(Pet.class);

        Pet updatedPet = petApi.updatePet(pet.getId(), petNameEdited, PetStatus.SOLD).as(Pet.class);

        Assert.assertEquals(pet.getId(), updatedPet.getId());

        Response deletePet = petApi.deletePet(pet.getId());
        Assert.assertEquals(200, deletePet.statusCode());
    }
}
