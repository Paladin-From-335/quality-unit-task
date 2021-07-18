package com.github.task.utils;

import com.github.task.entities.TimelineEntity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimelineDecoder {

    private String[] serviceId;

    private String[] questionType;

    private String responseType;

    private Date date;

    private int time;

    public TimelineDecoder() {
    }

    public TimelineDecoder(String[] serviceId, String[] questionType, String responseType, Date date, int time) {
        this.serviceId = serviceId;
        this.questionType = questionType;
        this.responseType = responseType;
        this.date = date;
        this.time = time;
    }

    public TimelineEntity toEntity(String data) {
        String[] array = data.split(" ");
        serviceId = array[1].split("\\.");
        questionType = array[2].split("\\.");
        responseType = array[3];
        try {
            date = new SimpleDateFormat("dd.MM.yyyy").parse(array[4]);
            time = Integer.parseInt(array[5]);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new TimelineEntity(
                serviceId,
                questionType,
                responseType,
                date,
                time
        );
    }
}
