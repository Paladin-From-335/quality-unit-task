package com.github.task.utils;

import com.github.task.entities.TimelineEntity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class ExpectationCalculation {

    private static String[] service;

    private static String[] question;

    private static String responseType;

    private static String[] date;

    private static Date dateFrom;

    private static Date dateTo;

    public static int expCalculating(TimelineEntity timelineEntity, String query) {
        String[] queryData = query.split(" ");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        service = queryData[1].split("\\.");
        question = queryData[2].split("\\.");
        responseType = queryData[3];
        date = queryData[4].split("-");
        if (date.length == 2) {
            try {
                dateFrom = dateFormat.parse(date[0]);
                dateTo = dateFormat.parse(date[1]);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } else {
            try {
                dateFrom = dateFormat.parse(date[0]);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if (!service[0].equals("*")) {
            int serviceLen = Math.min(service.length, timelineEntity.getServiceId().length);
            for (int i = 0; i < serviceLen; i++) {
                if (Integer.parseInt(service[i]) != Integer.parseInt(timelineEntity.getServiceId()[i])) {
                    throw new IllegalArgumentException("Wrong service" + Arrays.toString(timelineEntity.getServiceId()));
                }
            }
        }
        if (!question[0].equals("*")) {
            int questionLen = Math.min(question.length, timelineEntity.getQuestionTypeId().length);
            for (int i = 0; i < questionLen; i++) {
                if (Integer.parseInt(question[i]) != Integer.parseInt(timelineEntity.getQuestionTypeId()[i])) {
                    throw new IllegalArgumentException("Wrong question" + Arrays.toString(timelineEntity.getQuestionTypeId()));
                }
            }
        }
        if (!responseType.equals(timelineEntity.getResponseType())) {
            throw new IllegalArgumentException("Wrong response type");
        }
        if (date.length == 2) {
            if (!(dateFrom.before(timelineEntity.getDate()) && dateTo.after(timelineEntity.getDate()))) {
                throw new IllegalArgumentException("Wrong date before");
            }
        } else {
            if (!(dateFrom.after(timelineEntity.getDate()) || dateTo.before(timelineEntity.getDate()))) {
                throw new IllegalArgumentException("Unacceptable date after");
            }
        }
        return timelineEntity.getMinutes();
    }
}

