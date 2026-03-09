package nlu.fit.web.souvenirecommerce.model;

import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Promotion {
    private String id; //UUID
    private String productId; //FK
    private int discountPercent;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
