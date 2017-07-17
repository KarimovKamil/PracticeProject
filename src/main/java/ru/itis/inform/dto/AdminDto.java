package ru.itis.inform.dto;

/**
 * Created by Kamil Karimov on 17.07.2017.
 */
public class AdminDto {
    private String login;
    private String password;
    private String firstName;
    private String middleName;
    private String lastName;

    public AdminDto() {
    }

    public AdminDto(Builder builder) {
        this.login = builder.login;
        this.password = builder.password;
        this.firstName = builder.firstName;
        this.middleName = builder.middleName;
        this.lastName = builder.lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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

    public static class Builder {
        private String login;
        private String password;
        private String firstName;
        private String middleName;
        private String lastName;

        public Builder login(String arg) {
            this.login = arg;
            return this;
        }

        public Builder password(String arg) {
            this.password = arg;
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

        public AdminDto build() {
            return new AdminDto(this);
        }
    }
}
