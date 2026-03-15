package nlu.fit.web.souvenirecommerce.dao;

import nlu.fit.web.souvenirecommerce.model.entity.UserAuthentication;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.Optional;

@RegisterBeanMapper(UserAuthentication.class)
public interface UserAuthDAO {
    @SqlUpdate("INSERT INTO user_authentications (user_id, provider_id, identifier, credential_hash, created_at) " +
            "VALUES (:userId, :providerId, :identifier, :credentialHash, NOW())")
    void insert(@BindBean UserAuthentication auth);

    @SqlQuery("SELECT * FROM user_authentications WHERE identifier = :identifier AND provider_id = :providerId")
    Optional<UserAuthentication> findByIdentifier(@Bind("identifier") String identifier, @Bind("providerId") int providerId);

    @SqlUpdate("UPDATE user_authentications SET credential_hash = :newHash WHERE user_id = :userId AND provider_id = :providerId")
    void updatePassword(@Bind("userId") String userId, @Bind("providerId") int providerId, @Bind("newHash") String newHash);

    @SqlUpdate("DELETE FROM user_authentications WHERE user_id = :userId")
    void deleteByUserId(@Bind("userId") String userId);
}
