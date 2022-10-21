package com.final_project.staselko.model.enums;

public enum State {
    DRAFT(1),
    NEW(2),
    APPROVED(3),
    DECLINED(4),
    IN_PROGRESS(5),
    DONE(6),
    CANCELED(7);

    private Integer code;

    private State(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
