package ru.itis.inform.dto;

/**
 * Created by Kamil Karimov on 14.07.2017.
 */
public class TeacherDto implements Data {
    private String firstName;
    private String middleName;
    private String lastName;

    public TeacherDto() {
    }

    public TeacherDto(Builder builder) {
        this.firstName = builder.firstName;
        this.middleName = builder.middleName;
        this.lastName = builder.lastName;
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
        private String firstName;
        private String middleName;
        private String lastName;

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

        public TeacherDto build() {
            return new TeacherDto(this);
        }
    }
}
