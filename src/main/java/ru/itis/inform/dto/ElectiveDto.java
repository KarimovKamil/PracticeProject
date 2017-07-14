package ru.itis.inform.dto;

/**
 * Created by Kamil Karimov on 14.07.2017.
 */
public class ElectiveDto implements Data {
    private String name;
    private long teacherId;
    private int course;

    public ElectiveDto() {
    }

    public ElectiveDto(Builder builder) {
        this.name = builder.name;
        this.teacherId = builder.teacherId;
        this.course = builder.course;
    }

    public String getName() {
        return name;
    }

    public long getTeacherId() {
        return teacherId;
    }

    public int getCourse() {
        return course;
    }

    public static class Builder {
        private String name;
        private long teacherId;
        private int course;

        public Builder name(String arg) {
            this.name = arg;
            return this;
        }

        public Builder teacherId(long arg) {
            this.teacherId = arg;
            return this;
        }

        public Builder course(int arg) {
            this.course = arg;
            return this;
        }

        public ElectiveDto build() {
            return new ElectiveDto(this);
        }
    }
}
