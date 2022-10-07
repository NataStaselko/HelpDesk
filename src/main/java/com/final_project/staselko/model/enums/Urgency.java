package com.final_project.staselko.model.enums;

public enum Urgency {
    CRITICAL("C"),
    HIGH("H"),
    AVERAGE("A"),
    LOW("L");

    private String code;

    private Urgency(String code) {
        this.code = code;
    }
    public String getCode() {
        return code;
    }
}
