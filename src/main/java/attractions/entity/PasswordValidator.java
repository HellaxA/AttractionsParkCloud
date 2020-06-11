package attractions.entity;

import attractions.hash.HashString;

public class PasswordValidator {
    private String password;

    public PasswordValidator() {
    }

    public PasswordValidator(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
