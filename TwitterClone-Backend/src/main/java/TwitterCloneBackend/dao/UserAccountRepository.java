package TwitterCloneBackend.dao;

import TwitterCloneBackend.model.UserAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAccountRepository extends CrudRepository<UserAccount, Integer> {
    UserAccount findUserAccountByUsername(String username);
    boolean existsByUsername(String username);
}
