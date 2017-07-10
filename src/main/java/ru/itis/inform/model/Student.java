package ru.itis.inform.model;

/**
 * Created by The silly end on 7/10/2017.
 */
public class Student extends User {
    private long id;
    private String group;
    private int course;
    private Lab lab;
    private Elective elective;
    private Practice practice;
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
        this.elective = builder.elective;
        this.practice = builder.practice;
        this.teacher = builder.teacher;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
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

    public Lab getLab() {
        return lab;
    }

    public void setLab(Lab lab) {
        this.lab = lab;
    }

    public Elective getElective() {
        return elective;
    }

    public void setElective(Elective elective) {
        this.elective = elective;
    }

    public Practice getPractice() {
        return practice;
    }

    public void setPractice(Practice practice) {
        this.practice = practice;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public static class Builder extends User.Builder {
        private long id;
        private String group;
        private int course;
        private Lab lab;
        private Elective elective;
        private Practice practice;
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

        public Builder lab(Lab arg) {
            lab = arg;
            return this;
        }

        public Builder elective(Elective arg) {
            elective = arg;
            return this;
        }

        public Builder practice(Practice arg) {
            practice = arg;
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


