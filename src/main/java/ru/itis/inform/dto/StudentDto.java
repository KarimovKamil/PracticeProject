package ru.itis.inform.dto;

/**
 * Created by Kamil Karimov on 14.07.2017.
 */
public class StudentDto implements Data {
    private String firstName;
    private String middleName;
    private String lastName;
    private String group;
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
        this.labId = builder.labId;
        this.electiveId = builder.practiceId;
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

    public static class Builder {
        private String firstName;
        private String middleName;
        private String lastName;
        private String group;
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

        public Builder group(String arg) {
            group = arg;
            return this;
        }

        public Builder course(int arg) {
            course = arg;
            return this;
        }

        public Builder labId(long arg) {
            labId = arg;
            return this;
        }

        public Builder electiveId(long arg) {
            electiveId = arg;
            return this;
        }

        public Builder practiceId(long arg) {
            practiceId = arg;
            return this;
        }

        public Builder teacherId(long arg) {
            teacherId = arg;
            return this;
        }

        public StudentDto build() {
            return new StudentDto(this);
        }
    }
}
