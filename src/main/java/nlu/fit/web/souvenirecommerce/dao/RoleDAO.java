package nlu.fit.web.souvenirecommerce.dao;

import nlu.fit.web.souvenirecommerce.model.entity.Role;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

@RegisterBeanMapper(Role.class)
public interface RoleDAO {
    @SqlUpdate("INSERT INTO roles (name) VALUES (:name)")
    @GetGeneratedKeys
    int insert(@Bind("name") String name);

    @SqlQuery("SELECT * FROM roles WHERE id = :id")
    Role findById(@Bind("id") int id);

    @SqlQuery("SELECT * FROM roles")
    List<Role> findAll();

    @SqlUpdate("UPDATE roles SET name = :name WHERE id = :id")
    void update(@BindBean Role role);

    @SqlUpdate("DELETE FROM roles WHERE id = :id")
    void delete(@Bind("id") int id);
}