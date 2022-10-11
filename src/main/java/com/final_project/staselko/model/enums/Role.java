package com.final_project.staselko.model.enums;

public enum Role {
    EMPLOYEE("E"),
    MANAGER("M"),
    ENGINEER("A");
    private String code;

    private Role(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
