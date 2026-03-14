package nlu.fit.web.souvenirecommerce.model;
import lombok.*;

import java.sql.Timestamp;
import org.jdbi.v3.core.mapper.reflect.ColumnName;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Review {
    private String id; //UUID
    @ColumnName("product_id")
    private String productId; //FK
    @ColumnName("user_id")
    private String userId; //FK
    private int rating;
    private String comment;
    @ColumnName("create_at")
    private Timestamp createAt;

}
