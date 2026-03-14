package nlu.fit.web.souvenirecommerce.model;

import lombok.*;
import org.jdbi.v3.core.mapper.reflect.ColumnName;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder


public class Product {
    private String id;  //UUID
    @ColumnName("category_id")
    private String categoryId;//FK
    private String name;
    private String description;
    @ColumnName("original_price")
    private double originalPrice;
    @ColumnName("image_url")
    private String imageUrl;
    @ColumnName("stock_quantity")
    private int stockQuantity;
    @ColumnName("total_sold")
    private int totalSold;
    @ColumnName("avg_rating")
    private double avgRating;
    @ColumnName("review_count")
    private int reviewCount;


}
