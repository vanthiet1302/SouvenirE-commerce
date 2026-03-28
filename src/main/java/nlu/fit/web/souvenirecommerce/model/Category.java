package nlu.fit.web.souvenirecommerce.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category {
    private int id;
    private String category_name;
    private String image;
    private List<Product> products;

    public Category(int id, String name) {
        this.id = id;
        this.category_name = name;
        this.products = new ArrayList<>();
    }
    public Category(int id, String name, String image) {
        this.id = id;
        this.category_name = name;
        this.image = image;
    }
}

