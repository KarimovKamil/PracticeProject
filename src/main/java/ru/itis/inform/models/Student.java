package ru.itis.inform.models;

/**
 * Created by The silly end on 7/10/2017.
 */
public class Student extends User {
    private long id;
    private String group;
    private int course;
    private String lab;
    private long labId;
    private String elective;
    private long electiveId;
    private String practice;
    private long practiceId;
    private Teacher teacher;

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
        this.lab = builder.lab;
        this.labId = builder.labId;
        this.elective = builder.elective;
        this.electiveId = builder.electiveId;
        this.practice = builder.practice;
        this.practiceId = builder.practiceId;
        this.teacher = builder.teacher;
    }

    @Override
    public long getuId() {
        return id;
    }

    @Override
    public void setuId(long uId) {
        this.id = uId;
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

    public String getLab() {
        return lab;
    }

    public void setLab(String lab) {
        this.lab = lab;
    }

    public String getElective() {
        return elective;
    }

    public void setElective(String elective) {
        this.elective = elective;
    }

    public String getPractice() {
        return practice;
    }

    public void setPractice(String practice) {
        this.practice = practice;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public static class Builder extends User.Builder {
        private long id;
        private String group;
        private int course;
        private String lab;
        private long labId;
        private String elective;
        private long electiveId;
        private String practice;
        private long practiceId;
        private Teacher teacher;

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

        public Builder lab(String arg) {
            lab = arg;
            return this;
        }

        public Builder labId(long arg) {
            labId = arg;
            return this;
        }

        public Builder elective(String arg) {
            elective = arg;
            return this;
        }

        public Builder electiveId(long arg) {
            electiveId = arg;
            return this;
        }

        public Builder practice(String arg) {
            practice = arg;
            return this;
        }

        public Builder practiceId(long arg) {
            practiceId = arg;
            return this;
        }

        public Builder teacher(Teacher arg) {
            teacher = arg;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }
}


