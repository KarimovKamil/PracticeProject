package ru.itis.inform.model;

/**
 * Created by artur on 10.07.2017.
 */
public class Elective {
    private long id;
    private String name;
    private Teacher teacher;
    private int course;

    public Elective() {

    }

    public Elective(Builder builder) {

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
