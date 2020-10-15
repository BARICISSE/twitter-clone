package TwitterCloneBackend.dto;

import TwitterCloneBackend.model.UserAccount;

public class UserAccountDTO {
    private String username;

    public String getUsername() {
        return this.username;
    }

    public UserAccountDTO(String username) {
        this.username = username;
    }
}