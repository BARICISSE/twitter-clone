package TwitterCloneBackend.controller;

import TwitterCloneBackend.dto.UserAccountDTO;
import TwitterCloneBackend.model.UserAccount;
import TwitterCloneBackend.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
public class Controller {

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserAccountService userAccountService;

    public Controller(BCryptPasswordEncoder bCryptPasswordEncoder)
    {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("/register")
    public UserAccountDTO signUp(@RequestBody UserAccount user)
    {
        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        UserAccount userAccount = userAccountService.createUserAccount(user.getUsername(), encodedPassword);

        return new UserAccountDTO(user.getUsername());
    }

}
