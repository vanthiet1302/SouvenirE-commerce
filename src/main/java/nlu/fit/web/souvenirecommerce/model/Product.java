package nlu.fit.web.souvenirecommerce.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    private int id;
    private Integer categoryId;
    private String categoryName;
    private String name;
    private String description;
    private String shortDescription;
    private double originalPrice;
    private int discountPercent = 0;
    private Double salePrice;
    private String image;
    private int stockQuantity;
    private int totalSold;
    private double avgRating;
    private int reviewCount;

    public Product(int id, Integer categoryId, String name, String description,
                   double originalPrice, String image, int stockQuantity,
                   int totalSold, double avgRating, int reviewCount) {
        this.id = id;
        this.categoryId = categoryId;
        this.name = name;
        this.description = description;
        this.originalPrice = originalPrice;
        this.image = image;
        this.stockQuantity = stockQuantity;
        this.totalSold = totalSold;
        this.avgRating = avgRating;
        this.reviewCount = reviewCount;
    }
}
