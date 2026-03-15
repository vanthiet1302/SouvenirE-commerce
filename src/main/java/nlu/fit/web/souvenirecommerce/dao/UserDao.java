package nlu.fit.web.souvenirecommerce.dao;

import nlu.fit.web.souvenirecommerce.model.entity.User;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.customizer.BindBean;

public interface UserDao {

    @SqlUpdate("""
                INSERT INTO users(
                    id, username, last_name, first_name, email,
                    date_of_birth, avatar_url, gender, created_at, updated_at
                )
                VALUES (
                    :id, :username, :lastName, :firstName, :email,
                    :dateOfBirth, :avatarUrl, :gender, :createdAt, :updatedAt
                )
            """)
    int insert(@BindBean User user);

    @SqlUpdate("""
                UPDATE users
                SET 
                    last_name = :lastName,
                    first_name = :firstName,
                    email = :email,
                    date_of_birth = :dateOfBirth,
                    avatar_url = :avatarUrl,
                    gender = :gender,
                    updated_at = :updatedAt
                WHERE id = :id
            """)
    int update(@BindBean User user);

    @SqlUpdate("DELETE FROM users WHERE id = :id")
    int delete(@Bind("id") String id);



}
