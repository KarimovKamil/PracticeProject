package ru.itis.inform.model;

/**
 * Created by The silly end on 7/10/2017.
 */
public class Lab {
    private long id;
    private String name;
    private Teacher teacher;
    private int course;

    public Lab() {
    }

    public Lab(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.teacher = builder.teacher;
        this.course = builder.course;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public static class Builder {
        private long id;
        private String name;
        private Teacher teacher;
        private int course;

        public Builder id(long arg) {
            this.id = arg;
            return this;
        }

        public Builder name(String arg) {
            this.name = arg;
            return this;
        }

        public Builder teacher(Teacher arg) {
            this.teacher = arg;
            return this;
        }

        public Builder course(int arg) {
            this.course = arg;
            return this;
        }

        public Lab build() {
            return new Lab(this);
        }
    }
}
