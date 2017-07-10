package ru.itis.inform.model;

/**
 * Created by The silly end on 7/10/2017.
 */
public class Student extends User {
    private long id;
    private String group;
    private int course;
    private long labId;
    private long electiveId;
    private long practiceId;
    private long leaderId;

    public Student() {
    }

    public Student(User.Builder builder) {
        super(builder);
    }

    public Student(Builder builder) {
        super(builder);
        this.id = builder.id;
        this.group = builder.group;
        this.course = builder.course;
        this.labId = builder.labId;
        this.electiveId = builder.electiveId;
        this.practiceId = builder.practiceId;
        this.leaderId = builder.leaderId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public long getLabId() {
        return labId;
    }

    public void setLabId(long labId) {
        this.labId = labId;
    }

    public long getElectiveId() {
        return electiveId;
    }

    public void setElectiveId(long electiveId) {
        this.electiveId = electiveId;
    }

    public long getPracticeId() {
        return practiceId;
    }

    public void setPracticeId(long practiceId) {
        this.practiceId = practiceId;
    }

    public long getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(long leaderId) {
        this.leaderId = leaderId;
    }

    public static class Builder extends User.Builder {
        private long id;
        private String group;
        private int course;
        private long labId;
        private long electiveId;
        private long practiceId;
        private long leaderId;

        public Builder id(long arg) {
            id = arg;
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

        public Builder leaderId(long arg) {
            leaderId = arg;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }
}


