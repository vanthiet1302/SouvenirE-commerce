package nlu.fit.web.souvenirecommerce.dto;
import lombok.*;
import nlu.fit.web.souvenirecommerce.model.Category;
import nlu.fit.web.souvenirecommerce.model.Product;

import java.util.List;
@Getter
@Setter

public class CategoryWithProductDTO {
    private Category category;
    private List<Product> products;

    public CategoryWithProductDTO(Category category, List<Product> products) {
        this.category = category;
        this.products = products;
    }
}
