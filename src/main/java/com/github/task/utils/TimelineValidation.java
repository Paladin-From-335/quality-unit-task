package com.github.task.utils;

import com.github.task.entities.TimelineEntity;

import static com.github.task.utils.Constants.*;

public class TimelineValidation {

    private final TimelineDecoder timelineDecoder;

    public TimelineValidation(TimelineDecoder timelineDecoder) {
        this.timelineDecoder = timelineDecoder;
    }

    public TimelineEntity validateTimeline(String data) {

        TimelineEntity timelineEntity = timelineDecoder.toEntity(data);
        String respType = timelineEntity.getResponseType();

        for (int i = 0; i < timelineEntity.getServiceId().length; i++) {
            if (Integer.parseInt(timelineEntity.getServiceId()[i]) > SERVICE_MAP.get(i) || Integer.parseInt(timelineEntity.getServiceId()[i]) < 1) {
                throw new IllegalArgumentException("Wrong service");
            }
        }
        for (int i = 0; i < timelineEntity.getQuestionTypeId().length; i++) {
            if (Integer.parseInt(timelineEntity.getQuestionTypeId()[i]) > QUESTION_MAP.get(i) || Integer.parseInt(timelineEntity.getQuestionTypeId()[i]) < 1) {
                throw new IllegalArgumentException("Illegal question");
            }
        }

        if (!(respType.equals(RESPONSE_TYPE_FIRST) || respType.equals(RESPONSE_TYPE_NEXT))) {
            throw new IllegalArgumentException("Wrong response type");
        }
        if (timelineEntity.getMinutes() < 1) {
            throw new IllegalArgumentException("Incorrect time");
        }
        return timelineEntity;
    }
}
