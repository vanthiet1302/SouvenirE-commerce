package nlu.fit.web.souvenirecommerce.model.entity;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserAuth {
    private String userId;
    private int providerId;
    private String identifier; // username or key
    private String credentialHash; // hashed pass or value
    private LocalDateTime createdAt;
}
