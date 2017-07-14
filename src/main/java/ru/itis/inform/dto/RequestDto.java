package ru.itis.inform.dto;

/**
 * Created by artur on 14.07.2017.
 */
public class RequestDto implements Data {
    private long studentId;
    private String type;
    private long attributeId;

    public RequestDto() {
    }

    public RequestDto(Builder builder) {
        this.studentId = builder.studentId;
        this.type = builder.type;
        this.attributeId = builder.attributeId;
    }

    public long getStudentId() {
        return studentId;
    }

    public String getType() {
        return type;
    }

    public long getAttributeId() {
        return attributeId;
    }

    public static class Builder {
        private long studentId;
        private String type;
        private long attributeId;

        public Builder studentId(long arg) {
            this.studentId = arg;
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
