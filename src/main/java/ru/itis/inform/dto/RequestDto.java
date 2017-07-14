package ru.itis.inform.dto;

import ru.itis.inform.models.Student;

/**
 * Created by artur on 14.07.2017.
 */
public class RequestDto implements Data {
    private Student student;
    private String type;
    private long attributeId;

    public RequestDto() {
    }

    public RequestDto(Builder builder) {
        this.student = builder.student;
        this.type = builder.type;
        this.attributeId = builder.attributeId;
    }

    public Student getStudent() {
        return student;
    }

    public String getType() {
        return type;
    }

    public long getAttributeId() {
        return attributeId;
    }

    public static class Builder {
        private Student student;
        private String type;
        private long attributeId;

        public Builder student(Student arg) {
            this.student = arg;
            return this;
        }

        public Builder type(String arg) {
            this.type = arg;
            return this;
        }

        public Builder attributeId(long arg) {
            this.attributeId = arg;
            return this;
        }

        public RequestDto build() {
            return new RequestDto(this);
        }
    }
}
