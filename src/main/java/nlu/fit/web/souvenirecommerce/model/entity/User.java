package nlu.fit.web.souvenirecommerce.model.entity;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    private String id;
    private String username;
    private String lastName;
    private String firstName;
    private String email;
    private LocalDate dateOfBirth;
    private Gender gender;
    private String avatarUrl;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
