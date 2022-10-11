package com.final_project.staselko.converter.dto;

import com.final_project.staselko.model.dto.FeedbackDto;
import com.final_project.staselko.model.entiti.Feedback;

public interface FeedbackConverter {
    Feedback toFeedback(FeedbackDto feedbackDto);

    FeedbackDto toFeedbackDto(Feedback feedback);
}
