package com.final_project.staselko.model.dto;

import com.final_project.staselko.model.entiti.Category;
import com.final_project.staselko.model.enums.Urgency;
import com.final_project.staselko.utils.annotations.DateValid;
import com.final_project.staselko.utils.annotations.TextValid;
import lombok.Data;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class TicketDto {
    private String name;

    @TextValid
    @Size(max = 500, message = "the description exceed the 500 character limit")
    private String description;

    private String created_on;

    @DateValid
    private String desired_resolution_date;

    @NotEmpty (message = "the category cannot be empty")
    private Category category;

    @NotEmpty (message = "the urgency cannot be empty")
    private Urgency urgency_id;
}
