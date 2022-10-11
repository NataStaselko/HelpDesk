package com.final_project.staselko.model.enums;

public enum Urgency {
    CRITICAL(1),
    HIGH(2),
    AVERAGE(3),
    LOW(4);

    private Integer code;

    private Urgency(Integer code) {
        this.code = code;
    }
    public Integer getCode() {
        return code;
    }
}
