package ru.itis.inform.models;

import ru.itis.inform.dto.Data;

/**
 * Created by The silly end on 7/10/2017.
 */
public class Lab implements Data {
    private long id;
    private String name;
    private Teacher teacher;

    public Lab() {
    }

    public Lab(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.teacher = builder.teacher;
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

    public static class Builder {
        private long id;
        private String name;
        private Teacher teacher;

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

        public Lab build() {
            return new Lab(this);
        }
    }
}
