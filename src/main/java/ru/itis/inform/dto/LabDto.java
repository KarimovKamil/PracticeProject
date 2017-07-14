package ru.itis.inform.dto;

/**
 * Created by Kamil Karimov on 14.07.2017.
 */
public class LabDto implements Data {
    private String name;
    private long teacherId;

    public LabDto() {
    }

    public LabDto(Builder builder) {
        this.name = builder.name;
        this.teacherId = builder.teacherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getTeacher() {
        return teacherId;
    }

    public void setTeacher(long id) {
        this.teacherId = id;
    }

    public static class Builder {
        private String name;
        private long teacherId;

        public Builder name(String arg) {
            this.name = arg;
            return this;
        }

        public Builder teacherId(long arg) {
            this.teacherId = arg;
            return this;
        }

        public LabDto build() {
            return new LabDto(this);
        }
    }
}
