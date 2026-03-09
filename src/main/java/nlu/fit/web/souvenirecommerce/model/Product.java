package nlu.fit.web.souvenirecommerce.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder


public class Product {
    private String id;  //UUID
    private String categoryId;  //FK
    private String name;
    private String description;
    private double originalPrice;
    private String imageUrl;
    private int stockQuantity;
    private int totalSold;
    private double avgRating;
    private int reviewCount;


}
