package com.final_project.staselko.model.dto;

import com.final_project.staselko.model.entiti.Ticket;
import com.final_project.staselko.utils.annotations.TextValid;
import lombok.Data;

import javax.validation.constraints.Size;

@Data
public class CommentDto {

    @TextValid
    @Size(max = 500, message = "the text exceed the 500 character limit")
    private String text;
    private Long id;
    private String date;
}
