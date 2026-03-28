package nlu.fit.web.souvenirecommerce.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User implements Serializable {

    private int id;
    private String fullName;
    private String email;
    private String password;
    private String phone;
    private String createdAt;
    private String avatar;
    private String status;
    private String role;
    private String gender;
    private String dob;
}