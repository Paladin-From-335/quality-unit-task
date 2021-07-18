package com.github.task.handler;

import com.github.task.controller.TimelineController;
import com.github.task.entities.TimelineEntity;
import com.github.task.service.TimelineService;
import com.github.task.utils.ExpectationCalculation;
import com.github.task.utils.TimelineDecoder;
import com.github.task.utils.TimelineValidation;

import java.io.IOException;
import java.util.List;

import static com.github.task.utils.Constants.*;
import static com.github.task.utils.InputScanner.inputLine;

public class InputHandler {
    
    private static TimelineController timelineController = new TimelineController(new TimelineService(),
            new TimelineValidation(new TimelineDecoder()));

    public InputHandler() {
    }

    public void readInputData() {
        try {
            int count = checkInt(inputLine().trim());
            if (count > MAX_LINE_COUNT || count < 1) {
                System.out.println("Wrong count, try again");
                count = Integer.parseInt(inputLine().trim());
            }
            for (int i = 0; i < count; i++) {
                String line = inputLine();
                if (line.startsWith(WAITING_TIMELINE)) {
                    if (!checkInputLen(line)) {
                        i--;
                        System.out.println("Wrong timeline length");
                    }
                    timelineHandler(line);
                }
                if (line.startsWith(QUERY)) {
                    queryHandler(line);
                }
                if (!line.startsWith(WAITING_TIMELINE) && !line.startsWith(QUERY)) {
                    System.out.println("Wrong request, try again");
                    i--;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void timelineHandler(String data) {
        try {
            timelineController.saveTimeline(data);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

    private static void queryHandler(String data) {
        List<TimelineEntity> entityList = timelineController.readAllTimelines();
        int queryQuantity = 0;
        int averageWaitingTime = 0;
        for (TimelineEntity timelineEntity : entityList) {
            try {
                int result = ExpectationCalculation.expCalculating(timelineEntity, data);
                queryQuantity++;
                averageWaitingTime = (averageWaitingTime + result) / queryQuantity;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        if (averageWaitingTime == 0) {
            System.out.println("-");
        } else {
            System.out.println(averageWaitingTime);
        }
    }

    public int checkInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
            return -1;
        }
    }

    public boolean checkInputLen(String str) {
        if (str.split(" ").length == 6) {
            return true;
        } else {
            return false;
        }
    }
}
