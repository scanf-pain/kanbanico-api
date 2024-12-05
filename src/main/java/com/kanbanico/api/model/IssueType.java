package com.kanbanico.api.model;

import com.kanbanico.api.util.ValueEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum IssueType implements ValueEnum<String> {
    BUG("Bug"),
    FEATURE("Feature"),
    TASK("Task");

    private final String value;

}
