package api.models;

import lombok.*;

import java.util.ArrayList;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Pet {
    private int id;
    private String name;
    private Category category;
    private String[] photoUrls;
    private ArrayList<Tag> tags;
    private String status;
}
