package nlu.fit.web.souvenirecommerce.service.auth;

import nlu.fit.web.souvenirecommerce.dao.RoleUserDao;
import nlu.fit.web.souvenirecommerce.dao.UserAuthDao;
import nlu.fit.web.souvenirecommerce.dao.UserDao;
import nlu.fit.web.souvenirecommerce.model.entity.Gender;
import nlu.fit.web.souvenirecommerce.model.entity.RoleUser;
import nlu.fit.web.souvenirecommerce.model.entity.User;
import nlu.fit.web.souvenirecommerce.model.entity.UserAuth;
import nlu.fit.web.souvenirecommerce.util.JdbiFactory;
import nlu.fit.web.souvenirecommerce.util.PasswordUtils;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class AuthService {

    public boolean registerUser(
            String lastName,
            String firstName,
            String gender,
            String email,
            String username,
            LocalDate dob,
            String rawPassword,
            int providerId,
            int roleId
    ) throws IOException, ClassNotFoundException {

        String id = UUID.randomUUID().toString();
        String passwordHash = PasswordUtils.hashPassword(rawPassword);

        LocalDateTime now = LocalDateTime.now();

        User user = User.builder()
                .id(id)
                .lastName(lastName)
                .firstName(firstName)
                .gender(parseGender(gender))
                .email(email)
                .username(username)
                .avatarUrl("default-avt.jpg")
                .dateOfBirth(dob)
                .createdAt(now)
                .updatedAt(now)
                .build();

        UserAuth userAuth = UserAuth.builder()
                .userId(id)
                .providerId(providerId)
                .identifier(username)
                .credentialHash(passwordHash)
                .createdAt(now)
                .build();

        RoleUser roleUser = RoleUser.builder()
                .userId(id)
                .roleId(roleId)
                .isPrimary(true)
                .createdAt(now)
                .build();

        return JdbiFactory.getJdbi().inTransaction(handle -> {
            handle.attach(UserDao.class).insert(user);
            handle.attach(UserAuthDao.class).insert(userAuth);
            handle.attach(RoleUserDao.class).insert(roleUser);
            return true;
        });
    }

    private Gender parseGender(String gender) {
        return Gender.valueOf(gender.toUpperCase());
    }
}
