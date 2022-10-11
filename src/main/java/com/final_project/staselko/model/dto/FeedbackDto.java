package com.final_project.staselko.model.dto;

import com.final_project.staselko.utils.annotations.TextValid;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class FeedbackDto {

    private String date;

    @NotEmpty(message = "the rate cannot be empty")
    private String rate;

    @TextValid
    @Size(max = 500, message = "the text exceed the 500 character limit")
    private String text;

}
