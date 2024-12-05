package com.kanbanico.api.model;

import com.kanbanico.api.util.ValueEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ProjectCategory implements ValueEnum<String> {
    SOFTWARE("software"),
    MARKETING("marketing"),
    BUSINESS("business");

    private final String value;
}