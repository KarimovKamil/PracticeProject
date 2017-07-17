package ru.itis.inform.dto;

/**
 * Created by Kamil Karimov on 14.07.2017.
 */
public class StudentDto implements Data {
    private String firstName;
    private String middleName;
    private String lastName;
    private String group;
    private String login;
    private String password;
    private int course;
    private long labId;
    private long electiveId;
    private long practiceId;
    private long teacherId;

    public StudentDto() {
    }

    public StudentDto(Builder builder) {
        this.firstName = builder.firstName;
        this.middleName = builder.middleName;
        this.lastName = builder.lastName;
        this.group = builder.group;
        this.course = builder.course;
        this.login = builder.login;
        this.password = builder.password;
        this.labId = builder.labId;
        this.electiveId = builder.electiveId;
        this.practiceId = builder.practiceId;
        this.teacherId = builder.teacherId;
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

    public long getLabId() {
        return labId;
    }

    public long getElectiveId() {
        return electiveId;
    }

    public long getPracticeId() {
        return practiceId;
    }

    public long getTeacherId() {
        return teacherId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLabId(long labId) {
        this.labId = labId;
    }

    public void setElectiveId(long electiveId) {
        this.electiveId = electiveId;
    }

    public void setPracticeId(long practiceId) {
        this.practiceId = practiceId;
    }

    public void setTeacherId(long teacherId) {
        this.teacherId = teacherId;
    }

    public static class Builder {
        private String firstName;
        private String middleName;
        private String lastName;
        private String group;
        private String login;
        private String password;
        private int course;
        private long labId;
        private long electiveId;
        private long practiceId;
        private long teacherId;

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

        public Builder login(String arg) {
            this.login = arg;
            return this;
        }

        public Builder password(String arg) {
            this.password = arg;
            return this;
        }

        public Builder group(String arg) {
            group = arg;
            return this;
        }

        public Builder course(int arg) {
            this.course = arg;
            return this;
        }

        public Builder labId(long arg) {
            this.labId = arg;
            return this;
        }

        public Builder electiveId(long arg) {
            this.electiveId = arg;
            return this;
        }

        public Builder practiceId(long arg) {
            this.practiceId = arg;
            return this;
        }

        public Builder teacherId(long arg) {
            this.teacherId = arg;
            return this;
        }

        public StudentDto build() {
            return new StudentDto(this);
        }
    }
}
