package TwitterCloneBackend.service;

import TwitterCloneBackend.dao.UserAccountRepository;
import TwitterCloneBackend.model.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static java.util.Collections.emptyList;

@Service
public class UserAccountService implements UserDetailsService {
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserAccountRepository userAccountRepository;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Transactional
    public UserAccount createUserAccount(String username, String encodedPassword){
        if(username==null || username.trim().length()==0) {
            throw new IllegalArgumentException("Username cannot be null");
        }
        if(userAccountRepository.existsByUsername(username)){
            throw new IllegalArgumentException("Username: " + username + " already exists");
        }
        UserAccount userAccount = new UserAccount();
        userAccount.setUsername(username);
        userAccount.setPassword(encodedPassword);

        userAccountRepository.save(userAccount);

        return userAccount;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAccount userAccount = userAccountRepository.findUserAccountByUsername(username);
        if (userAccount == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(userAccount.getUsername(), userAccount.getPassword(), emptyList());
    }


}
