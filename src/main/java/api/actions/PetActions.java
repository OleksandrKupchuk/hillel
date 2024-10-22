package api.actions;

import api.PetStatus;
import api.models.Category;
import api.models.Pet;
import api.models.Tag;
import com.github.javafaker.Faker;

import java.util.ArrayList;

public class PetActions {
    public Pet createPet(){
        Faker faker = new Faker();
        int petId = faker.number().numberBetween(0, 10000);
        String petName = faker.animal().name();
        String petStatus = PetStatus.AVAILABLE;
        int categoryId = faker.number().numberBetween(0, 10000);
        String categoryName = faker.funnyName().name();
        int tagId = faker.number().numberBetween(0, 10000);
        String tagName = faker.funnyName().name();
        String[] photoUrls = new String[]{"https//some.url"};
        ArrayList<Tag> tags = new ArrayList<>();

        Category category = Category
                .builder()
                .id(categoryId)
                .name(categoryName)
                .build();

        Tag firstTag = Tag
                .builder()
                .id(tagId)
                .name(tagName)
                .build();

        tags.add(firstTag);

        return Pet
                .builder()
                .id(petId)
                .name(petName)
                .category(category)
                .photoUrls(photoUrls)
                .tags(tags)
                .status(petStatus)
                .build();
    }
}
