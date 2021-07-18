package com.github.task.service;

import com.github.task.entities.TimelineEntity;

import java.util.ArrayList;
import java.util.List;

public class TimelineService {

    private List<TimelineEntity> timelineEntityList = new ArrayList<>();

    public void saveEntityToList(TimelineEntity payload) {
        this.timelineEntityList.add(payload);
    }

    public List<TimelineEntity> getInfo() {
        return this.timelineEntityList;
    }
}
