package com.github.task.entities;

import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

public class TimelineEntity {

    private String[] serviceId;

    private String[] questionTypeId;

    private String responseType;

    private Date date;

    private int minutes;

    public TimelineEntity() {
    }

    public TimelineEntity(String[] serviceId, String[] questionTypeId, String responseType, Date date, int minutes) {
        this.serviceId = serviceId;
        this.questionTypeId = questionTypeId;
        this.responseType = responseType;
        this.date = date;
        this.minutes = minutes;
    }

    public String[] getServiceId() {
        return serviceId;
    }

    public void setServiceId(String[] serviceId) {
        this.serviceId = serviceId;
    }

    public String[] getQuestionTypeId() {
        return questionTypeId;
    }

    public void setQuestionTypeId(String[] questionTypeId) {
        this.questionTypeId = questionTypeId;
    }

    public String getResponseType() {
        return responseType;
    }

    public void setResponseType(String responseType) {
        this.responseType = responseType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimelineEntity that = (TimelineEntity) o;
        return minutes == that.minutes && Arrays.equals(serviceId, that.serviceId) && Arrays.equals(questionTypeId, that.questionTypeId) && Objects.equals(responseType, that.responseType) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(responseType, date, minutes);
        result = 31 * result + Arrays.hashCode(serviceId);
        result = 31 * result + Arrays.hashCode(questionTypeId);
        return result;
    }

    @Override
    public String toString() {
        return "TimelineEntity{" +
                "serviceId=" + Arrays.toString(serviceId) +
                ", questionTypeId=" + Arrays.toString(questionTypeId) +
                ", responseType='" + responseType + '\'' +
                ", date=" + date +
                ", minutes=" + minutes +
                '}';
    }
}