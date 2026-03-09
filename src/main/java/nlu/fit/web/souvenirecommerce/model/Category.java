package nlu.fit.web.souvenirecommerce.model;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Category {
    private String id; //UUID
    private String name;
    private String bannerUrl;
    private List<Product> products;
}
