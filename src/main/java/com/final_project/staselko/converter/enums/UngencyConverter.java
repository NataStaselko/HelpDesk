package com.final_project.staselko.converter.enums;
import com.final_project.staselko.model.enums.Urgency;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class UngencyConverter implements AttributeConverter<Urgency, String> {
    @Override
    public String convertToDatabaseColumn(Urgency urgency) {
        if ( urgency == null) {
            return null;
        }
        return urgency.getCode();
    }

    @Override
    public Urgency convertToEntityAttribute(String code) {
        if (code == null) {
            return null;
        }
        return Stream.of(Urgency.values())
                .filter(c -> c.getCode().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
