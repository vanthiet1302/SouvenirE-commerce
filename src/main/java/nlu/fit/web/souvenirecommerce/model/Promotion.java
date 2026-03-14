package nlu.fit.web.souvenirecommerce.model;

import lombok.*;
import java.time.LocalDateTime;
import org.jdbi.v3.core.mapper.reflect.ColumnName;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Promotion {
    private String id; //UUID
    @ColumnName("product_id")
    private String productId; //FK
    @ColumnName("discount_percent")
    private int discountPercent;
    @ColumnName("start_date")
    private LocalDateTime startDate;
    @ColumnName("end_date")
    private LocalDateTime endDate;
}
