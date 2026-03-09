package nlu.fit.web.souvenirecommerce.model;
import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Review {
    private String id; //UUID
    private String productId; //FK
    private String userId; //FK
    private int rating;
    private String comment;
    private Timestamp createAt;

}
