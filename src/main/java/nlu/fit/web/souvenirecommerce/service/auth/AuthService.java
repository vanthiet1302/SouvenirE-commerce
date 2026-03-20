package nlu.fit.web.souvenirecommerce.service.auth;

import nlu.fit.web.souvenirecommerce.dao.UserAuthDAO;
import nlu.fit.web.souvenirecommerce.dao.UserDAO;
import nlu.fit.web.souvenirecommerce.dao.UserRoleDAO;
import nlu.fit.web.souvenirecommerce.model.entity.Gender;
import nlu.fit.web.souvenirecommerce.model.entity.User;
import nlu.fit.web.souvenirecommerce.model.entity.UserAuthentication;
import nlu.fit.web.souvenirecommerce.model.entity.UserRole;
import nlu.fit.web.souvenirecommerce.util.JdbiUtil;
import nlu.fit.web.souvenirecommerce.util.PasswordUtil;

import java.time.LocalDate;
import java.util.UUID;

public class AuthService {

    public boolean registerCustomer(String username, String email, String password,
                                    String firstName, String lastName, Gender gender,
                                    LocalDate dateOfBirth) {
        return JdbiUtil.getJdbi().inTransaction(handle -> {
            UserDAO userDAO = handle.attach(UserDAO.class);
            UserAuthDAO authDAO = handle.attach(UserAuthDAO.class);
            UserRoleDAO roleDAO = handle.attach(UserRoleDAO.class);

            String userId = UUID.randomUUID().toString();
            String hashPassword = PasswordUtil.hashPassword(password);
            String avatarUrl = "default-avt.jpg";

            User user = User.builder()
                    .id(userId)
                    .username(username)
                    .firstName(firstName)
                    .lastName(lastName)
                    .gender(gender)
                    .dateOfBirth(dateOfBirth)
                    .email(email)
                    .avatarUrl(avatarUrl)
                    .build();
            userDAO.insert(user);

            UserAuthentication auth = UserAuthentication.builder()
                    .userId(userId)
                    .providerId(1) // 1 - Username: Password
                    .identifier(username)
                    .credentialHash(hashPassword)
                    .build();
            authDAO.insert(auth);

            UserRole userRole = UserRole.builder()
                    .userId(userId)
                    .roleId(1)  // 1 - Customer
                    .isPrimary(true)
                    .build();
            roleDAO.addRoleToUser(userRole);

            return true;
        });
    }

}
