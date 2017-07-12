package ru.itis.inform.models;

/**
 * Created by Kamil Karimov on 06.07.2017.
 */
public class User {
    private long uId;
    private String login;
    private String hashPassword;
    private String token;
    private String firstName;
    private String middleName;
    private String lastName;
    private String role;

    public User() {
    }

    public User(Builder builder) {
        this.uId = builder.uId;
        this.login = builder.login;
        this.hashPassword = builder.hashPassword;
        this.token = builder.token;
        this.firstName = builder.firstName;
        this.middleName = builder.middleName;
        this.lastName = builder.lastName;
        this.role = builder.role;
    }

    public long getuId() {
        return uId;
    }

    public void setuId(long uId) {
        this.uId = uId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHashPassword() {
        return hashPassword;
    }

    public void setHashPassword(String hashPassword) {
        this.hashPassword = hashPassword;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public static class Builder {
        private long uId;
        private String login;
        private String hashPassword;
        private String token;
        private String firstName;
        private String middleName;
        private String lastName;
        private String role;

        public Builder uId(long arg) {
            this.uId = arg;
            return this;
        }

        public Builder login(String arg) {
            this.login = arg;
            return this;
        }

        public Builder hashPassword(String arg) {
            this.hashPassword = arg;
            return this;
        }

        public Builder token(String arg) {
            this.token = arg;
            return this;
        }

        public Builder firstName(String arg) {
            this.firstName = arg;
            return this;
        }

        public Builder middleName(String arg) {
            this.middleName = arg;
            return this;
        }

        public Builder lastName(String arg) {
            this.lastName = arg;
            return this;
        }

        public Builder role(String arg) {
            this.role = arg;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
