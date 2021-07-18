package com.github.task.controller;

import com.github.task.entities.TimelineEntity;
import com.github.task.service.TimelineService;
import com.github.task.utils.TimelineValidation;

import java.util.List;

public class TimelineController {

    private TimelineService timelineService;

    private TimelineValidation timelineValidation;

    public TimelineController(TimelineService timelineService, TimelineValidation timelineValidation) {
        this.timelineService = timelineService;
        this.timelineValidation = timelineValidation;
    }

    public void saveTimeline(String data) {
        TimelineEntity timelineEntity = timelineValidation.validateTimeline(data);
        timelineService.saveEntityToList(timelineEntity);
    }

    public List<TimelineEntity> readAllTimelines() {
        return timelineService.getInfo();
    }
}
