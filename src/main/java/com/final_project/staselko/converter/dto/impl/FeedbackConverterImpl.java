package com.final_project.staselko.converter.dto.impl;

import com.final_project.staselko.converter.dto.FeedbackConverter;
import com.final_project.staselko.model.dto.FeedbackDto;
import com.final_project.staselko.model.entiti.Feedback;

import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class FeedbackConverterImpl implements FeedbackConverter {
    @Override
    public Feedback toFeedback(FeedbackDto feedbackDto) {
        Feedback feedback = new Feedback();
        feedback.setRate(Integer.parseInt(feedbackDto.getRate()));
        feedback.setText(feedback.getText());
        return feedback;
    }

    @Override
    public FeedbackDto toFeedbackDto(Feedback feedback) {
        FeedbackDto feedbackDto = new FeedbackDto();
        feedbackDto.setRate(String.valueOf(feedback.getRate()));
        feedbackDto.setDate(feedback.getDate().format(DateTimeFormatter
                .ofPattern("MMM dd, yyyy HH:mm:ss").localizedBy(Locale.ENGLISH)));
        feedbackDto.setText(feedbackDto.getText());
        return feedbackDto;
    }
}
