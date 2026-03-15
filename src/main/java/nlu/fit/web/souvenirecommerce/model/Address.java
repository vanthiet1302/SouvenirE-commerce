package nlu.fit.web.souvenirecommerce.model;

import lombok.*;
import nlu.fit.web.souvenirecommerce.model.entity.User;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {
    private String id; //UUID
    private User user;
    private String fullName;
    private String phone;
    private String city;
    private String district;
    private String ward;
    private String details;
}
