package com.final_project.staselko.converter.enums;

import com.final_project.staselko.model.enums.Urgency;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class UngencyConverter implements AttributeConverter<Urgency, Integer> {
    @Override
    public Integer convertToDatabaseColumn(Urgency urgency) {
        if (urgency == null) {
            return null;
        }
        return urgency.getCode();
    }

    @Override
    public Urgency convertToEntityAttribute(Integer code) {
        if (code == null) {
            return null;
        }
        return Stream.of(Urgency.values())
                .filter(c -> c.getCode() == (code))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("This category is not defined in the database"));
    }
}
