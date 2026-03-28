package nlu.fit.web.souvenirecommerce.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewSummary {
    private int totalReviews;
    private double avgRating;
}
