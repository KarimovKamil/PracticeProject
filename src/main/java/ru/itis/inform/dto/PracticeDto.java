package ru.itis.inform.dto;

import java.util.Date;

/**
 * Created by Kamil Karimov on 14.07.2017.
 */
public class PracticeDto {
    private String name;
    private Date startDate;
    private Date endDate;
    private long teacherId;
    private int course;

    public PracticeDto() {
    }

    public PracticeDto(Builder builder) {
        this.name = builder.name;
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
        this.teacherId = builder.teacherId;
        this.course = builder.course;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(long id) {
        this.teacherId = id;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public static class Builder {
        private String name;
        private Date startDate;
        private Date endDate;
        private long teacherId;
        private int course;

        public Builder name(String arg) {
            this.name = arg;
            return this;
        }

        public Builder startDate(Date arg) {
            this.startDate = arg;
            return this;
        }

        public Builder endDate(Date arg) {
            this.endDate = arg;
            return this;
        }

        public Builder teacher(long arg) {
            this.teacherId = arg;
            return this;
        }

        public Builder course(int arg) {
            this.course = arg;
            return this;
        }

        public PracticeDto build() {
            return new PracticeDto(this);
        }
    }
}
