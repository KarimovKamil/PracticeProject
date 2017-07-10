package ru.itis.inform.model;

/**
 * Created by artur on 10.07.2017.
 */
public class Teacher {
    private long id;
    private String firstName;
    private String middleName;
    private String lastName;

    public Teacher() {

    }

    public Teacher(Builder builder) {
        this.id = builder.id;
        this.firstName = builder.firstName;
        this.middleName = builder.middleName;
        this.lastName = builder.lastName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
        private long id;
        private String firstName;
        private String middleName;
        private String lastName;

        public Builder id(long arg) {
            this.id = arg;
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

        public Teacher build() {
            return new Teacher(this);
        }
    }
}
