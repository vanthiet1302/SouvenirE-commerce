package nlu.fit.web.souvenirecommerce.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SearchSuggestionDTO {
    private int id;
    private String name;
    private Double originalPrice;
    private Double salePrice;
    private Double price;
    private String image;
}