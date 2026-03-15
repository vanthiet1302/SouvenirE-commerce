package nlu.fit.web.souvenirecommerce.dao;

import nlu.fit.web.souvenirecommerce.model.entity.User;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.customizer.BindBean;

import java.util.List;
import java.util.Optional;

@RegisterBeanMapper(User.class)
public interface UserDAO {
    @SqlUpdate("INSERT INTO users (id, username, first_name, last_name, email, avatar_url, gender, date_of_birth, created_at) " +
            "VALUES (:id, :username, :firstName, :lastName, :email, :avatarUrl, :gender, :dateOfBirth, NOW())")
    void insert(@BindBean User user);

    @SqlQuery("SELECT * FROM users WHERE id = :id")
    Optional<User> findById(@Bind("id") String id);

    @SqlQuery("SELECT * FROM users")
    List<User> findAll();

    @SqlUpdate("UPDATE users SET first_name = :firstName, last_name = :lastName, email = :email, " +
            "avatar_url = :avatarUrl, gender = :gender,date_of_birth = :dateOfBirth, updated_at = NOW() WHERE id = :id")
    void update(@BindBean User user);

    @SqlUpdate("DELETE FROM users WHERE id = :id")
    void delete(@Bind("id") String id);
}
