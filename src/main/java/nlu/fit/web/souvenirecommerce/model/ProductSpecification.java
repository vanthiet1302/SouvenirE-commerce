package nlu.fit.web.souvenirecommerce.model;
import lombok.*;
import org.jdbi.v3.core.mapper.reflect.ColumnName;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ProductSpecification {
    private String id; //UUID
    @ColumnName("product_id")
    private String productId; //FK
    @ColumnName("spec_name")
    private String specName; //FK
    @ColumnName("spec_value")
    private String specValue; //FK
}
