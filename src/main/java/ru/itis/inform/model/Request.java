package ru.itis.inform.model;

import java.sql.Date;

/**
 * Created by artur on 10.07.2017.
 */
public class Request {
    private long id;
    private String reqMessage;
    private String resMessage;
    private Date date;
    private Student student;
    private long attributeId;
    private String status;

    public Request() {
    }

    public Request(Builder builder) {
        this.id = builder.id;
        this.reqMessage = builder.reqMessage;
        this.resMessage = builder.resMessage;
        this.date = builder.date;
        this.student = builder.student;
        this.attributeId = builder.attributeId;
        this.status = builder.status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getReqMessage() {
        return reqMessage;
    }

    public void setReqMessage(String reqMessage) {
        this.reqMessage = reqMessage;
    }

    public String getResMessage() {
        return resMessage;
    }

    public void setResMessage(String resMessage) {
        this.resMessage = resMessage;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public long getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(long attributeId) {
        this.attributeId = attributeId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static class Builder {
        private long id;
        private String reqMessage;
        private String resMessage;
        private Date date;
        private Student student;
        private long attributeId;
        private String status;

        public Builder id(long arg) {
            this.id = arg;
            return this;
        }

        public Builder reqMessage(String arg) {
            this.reqMessage = arg;
            return this;
        }

        public Builder resMessage(String arg) {
            this.resMessage = arg;
            return this;
        }

        public Builder date(Date arg) {
            this.date = arg;
            return this;
        }

        public Builder student(Student arg) {
            this.student = arg;
            return this;
        }

        public Builder attributeId(long arg) {
            this.attributeId = arg;
            return this;
        }

        public Builder status(String arg) {
            this.status = arg;
            return this;
        }

        public Request build() {
            return new Request(this);
        }
    }
}
