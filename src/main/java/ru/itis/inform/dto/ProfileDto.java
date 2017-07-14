package ru.itis.inform.dto;

/**
 * Created by The silly end on 7/14/2017.
 */
public class ProfileDto implements Data {
    private long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String group;
    private int course;
    private String lab;
    private String elective;
    private String practice;
    private String teachersFirstName;
    private String teachersLastName;

    public ProfileDto() {
    }

    private ProfileDto(Builder builder) {
        this.id = builder.id;
        this.firstName = builder.firstName;
        this.middleName = builder.middleName;
        this.lastName = builder.lastName;
        this.group = builder.group;
        this.course = builder.course;
        this.lab = builder.lab;
        this.elective = builder.elective;
        this.practice = builder.practice;
        this.teachersFirstName = builder.teachersFirstName;
        this.teachersLastName = builder.teachersLastName;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGroup() {
        return group;
    }

    public int getCourse() {
        return course;
    }

    public String getLab() {
        return lab;
    }

    public String getElective() {
        return elective;
    }

    public String getPractice() {
        return practice;
    }

    public String getTeachersFirstName() {
        return teachersFirstName;
    }

    public String getTeachersLastName() {
        return teachersLastName;
    }

    public static class Builder {
        private long id;
        private String firstName;
        private String middleName;
        private String lastName;
        private String group;
        private int course;
        private String lab;
        private String elective;
        private String practice;
        private String teachersFirstName;
        private String teachersLastName;

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

        public Builder group(String arg) {
            this.group = arg;
            return this;
        }

        public Builder course(int arg) {
            this.course = arg;
            return this;
        }

        public Builder lab(String arg) {
            this.lab = arg;
            return this;
        }

        public Builder elective(String arg) {
            this.elective = arg;
            return this;
        }

        public Builder practice(String arg) {
            this.practice = arg;
            return this;
        }

        public Builder teachersFirstName(String arg) {
            this.teachersFirstName = arg;
            return this;
        }

        public Builder teachersLastName(String arg) {
            this.teachersLastName = arg;
            return this;
        }

        public ProfileDto build() {
            return new ProfileDto(this);
        }
    }
}
