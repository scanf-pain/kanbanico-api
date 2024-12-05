package com.kanbanico.api.model;

import com.kanbanico.api.util.ValueEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum IssueStatus implements ValueEnum<String> {
    BACKLOG("backlog"),
    SELECTED("selected"),
    PROGRESS("progress"),
    DONE("done");

    private final String value;
}
