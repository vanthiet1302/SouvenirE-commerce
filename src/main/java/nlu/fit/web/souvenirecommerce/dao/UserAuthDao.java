package nlu.fit.web.souvenirecommerce.dao;

import nlu.fit.web.souvenirecommerce.model.entity.UserAuth;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

public interface UserAuthDao {

    @SqlUpdate("""
    INSERT INTO user_authentications(user_id, provider_id, identifier, credential_hash, created_at)
        VALUES (:userId, :providerId, :identifier, :credentialHash, :createdAt)
    """)
    int insert(@BindBean UserAuth userAuth);

    @SqlQuery("SELECT * FROM users WHERE user_id = :userId AND provider_id = :providerId")
    UserAuth getUserAuth(@Bind("userId") String userId,@Bind("providerId") int providerId);
}
