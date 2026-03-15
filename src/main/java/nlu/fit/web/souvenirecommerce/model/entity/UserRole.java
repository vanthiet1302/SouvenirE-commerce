package nlu.fit.web.souvenirecommerce.model.entity;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRole {
    private String userId;
    private int roleId;
    private Role role;
    private boolean isPrimary;
    private LocalDateTime createdAt;
    private LocalDateTime expiredAt;

    public boolean isActive() {
        if (expiredAt == null) return true;
        return expiredAt.isAfter(LocalDateTime.now());
    }

    public boolean getIsPrimary() {
        return isPrimary;
    }
}