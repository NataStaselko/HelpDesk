package com.final_project.staselko.utils.entiti;

import com.final_project.staselko.model.dto.TicketDto;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class ObjectList<T> {
    private List<T> ticketsDto;

    public ObjectList() {
        ticketsDto = new ArrayList<>();
    }
}
