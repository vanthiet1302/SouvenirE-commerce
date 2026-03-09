package nlu.fit.web.souvenirecommerce.model;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ProductSpecification {
    private String id; //UUID
    private String productId; //FK
    private String specName; //FK
    private String specValue; //FK
}
