package ru.itis.inform.models;

import java.util.Date;

/**
 * Created by The silly end on 7/10/2017.
 */
public class Practice {
    private long id;
    private String name;
    private Date startDate;
    private Date endDate;
    private Teacher teacher;
    private int course;

    public Practice() {
    }

    public Practice(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
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
        private Date startDate;
        private Date endDate;
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

        public Builder startDate(Date arg) {
            this.startDate = arg;
            return this;
        }

        public Builder endDate(Date arg) {
            this.endDate = arg;
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

        public Practice build() {
            return new Practice(this);
        }
    }
}
