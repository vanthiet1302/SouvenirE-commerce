package nlu.fit.web.souvenirecommerce.model.entity;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoleUser {
    private String userId;
    private int roleId;
    private boolean isPrimary;
    private LocalDateTime createdAt;
    private LocalDateTime expiredAt;

    public boolean getIsPrimary() {
        return isPrimary;
    }
}
