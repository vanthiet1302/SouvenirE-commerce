package nlu.fit.web.souvenirecommerce.model;
import lombok.*;

import java.util.List;
import org.jdbi.v3.core.mapper.reflect.ColumnName;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Category {
    private String id; //UUID
    private String name;
    @ColumnName("banner_url")
    private String bannerUrl;
    private List<Product> products;
}
