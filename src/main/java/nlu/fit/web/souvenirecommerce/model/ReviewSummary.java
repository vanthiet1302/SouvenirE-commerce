package nlu.fit.web.souvenirecommerce.model;
import lombok.*;
import org.jdbi.v3.core.mapper.reflect.ColumnName;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ReviewSummary {
    @ColumnName("total_review")
    private int totalReview;
    @ColumnName("avg_rating")
    private double avgRating;
}
