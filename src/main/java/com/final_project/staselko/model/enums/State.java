package com.final_project.staselko.model.enums;

public enum State {
    DRAFT(0),
    NEW(1),
    APPROVED(2),
    DECLINED(3),
    IN_PROGRESS(4),
    DONE(5),
    CANCELED(6);

    private Integer code;

    private State(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
