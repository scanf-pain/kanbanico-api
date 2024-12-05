package com.kanbanico.api.model.embeded;

import com.kanbanico.api.util.ValueEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ProjectUserRole implements ValueEnum<String> {
    OWNER("owner"),
    GUEST("guest"),
    REVIEWER("reviewer"),
    VIEWER("viewer");

    private final String value;
}