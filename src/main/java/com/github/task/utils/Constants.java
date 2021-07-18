package com.github.task.utils;

import java.util.Map;

public class Constants {

    public static final int MAX_LINE_COUNT = 100000;

    public static final int SERVICE_COUNT = 10;

    public static final int SERVICE_VARIATIONS = 3;

    public static final int QUESTION_TYPE_COUNT = 10;

    public static final int QUESTION_CATEGORIES = 20;

    public static final int QUESTION_SUBCATEGORIES = 5;

    public static final String RESPONSE_TYPE_FIRST = "P";
    
    public static final String RESPONSE_TYPE_NEXT = "N";
    
    public static final String WAITING_TIMELINE = "C";
    
    public static final String QUERY = "D";

    public static final Map<Integer, Integer> SERVICE_MAP = Map.of(
            0, SERVICE_COUNT,
            1, SERVICE_VARIATIONS
    );

    public static final Map<Integer, Integer> QUESTION_MAP = Map.of(
            0, QUESTION_TYPE_COUNT,
            1, QUESTION_CATEGORIES,
            2, QUESTION_SUBCATEGORIES
    );
    
}
