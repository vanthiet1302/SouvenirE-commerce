package nlu.fit.web.souvenirecommerce.dao;

import nlu.fit.web.souvenirecommerce.model.entity.Role;
import nlu.fit.web.souvenirecommerce.model.entity.UserRole;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

@RegisterBeanMapper(UserRole.class)
@RegisterBeanMapper(Role.class)
public interface UserRoleDAO {
    @SqlUpdate("INSERT INTO role_users (user_id, role_id, is_primary, created_at, expired_at) " +
            "VALUES (:userId, :roleId, :isPrimary, NOW(), :expiredAt)")
    void addRoleToUser(@BindBean UserRole userRole);

    @SqlQuery("SELECT ru.*, r.id AS r_id, r.name AS r_name " +
            "FROM role_users ru " +
            "JOIN roles r ON ru.role_id = r.id " +
            "WHERE ru.user_id = :userId")
    @RegisterBeanMapper(value = Role.class, prefix = "r")
    List<UserRole> findRolesByUserId(@Bind("userId") String userId);

    @SqlUpdate("DELETE FROM role_users WHERE user_id = :userId AND role_id = :roleId")
    void removeRoleFromUser(@Bind("userId") String userId, @Bind("roleId") int roleId);
}