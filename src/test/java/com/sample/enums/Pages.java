package com.sample.enums;

public enum Pages {
    DATE_PICKER_PAGE("datepicker"),
    CHECKBOX_PAGE("checkbox");

    private final String value;

    private static final String BASE_URL = "https://formy-project.herokuapp.com";

    Pages(String value) {
        this.value = value;
    }

    public String getValue() {
        return "%s/%s".formatted(BASE_URL, value);
    }
}
