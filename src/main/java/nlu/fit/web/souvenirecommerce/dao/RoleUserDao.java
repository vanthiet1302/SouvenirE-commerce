package nlu.fit.web.souvenirecommerce.dao;

import nlu.fit.web.souvenirecommerce.model.entity.RoleUser;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

public interface RoleUserDao {

    @SqlUpdate("""
                INSERT INTO role_users(user_id, role_id, is_primary, created_at, expired_at)
                VALUES (:userId, :roleId, :isPrimary, :createdAt, :expiredAt)
            """)
    int insert(@BindBean RoleUser roleUser);

    @SqlQuery("SELECT * FROM role_users WHERE user_id = :userId AND provider_id = :providerId")
    RoleUserDao getRoleUser(@Bind("userId") String userId, @Bind("providerId") int providerId);
}
