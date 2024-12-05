package com.kanbanico.api.model;

import com.kanbanico.api.util.ValueEnum;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum IssuePriority implements ValueEnum<Integer> {
    LOWEST(1),
    LOW(2),
    MEDIUM(3),
    HIGH(4),
    HIGHEST(5);

    private final int value;

    @Override
    public Integer getValue() {
        return value;
    }
}
