package com.final_project.staselko.model.enums;

public enum State {
    DRAFT("DR"),
    NEW("NW"),
    APPROVED("AP"),
    DECLINED("DC"),
    IN_PROGRESS("PR"),
    DONE("DN"),
    CANCELED("CN");

    private String code;

    private State(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
