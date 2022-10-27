package com.final_project.staselko.controllers.server;
import com.final_project.staselko.model.dto.TicketDto;
import com.final_project.staselko.model.entiti.Ticket;
import com.final_project.staselko.servise.entiti.TicketService;
import com.final_project.staselko.utils.entiti.ObjectList;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tickets")
public class TicketController {

    private final TicketService ticketService;

    @PostMapping
    public Ticket createTicket(@Valid @RequestBody TicketDto ticketDto){
        return ticketService.saveTicket(ticketDto);
    }

    @PutMapping("/{id}")
    public Ticket editTicket(@PathVariable(value = "id") Long id,
                             @Valid @RequestBody TicketDto ticketDto){
        return ticketService.updateTicket(id, ticketDto);
    }

    @GetMapping("/{id}")
    public TicketDto getTicketById(@PathVariable(value = "id") Long id){
        return ticketService.getTicketById(id);
    }

    @GetMapping("/all")
    public ObjectList<TicketDto> getAllTickets(Long user_id){
        ObjectList<TicketDto> objectList = new ObjectList<>();
        objectList.setTicketsDto(ticketService.getAllTickets(user_id));
        return objectList;
    }

    @GetMapping
    public ObjectList<TicketDto> getTicketsByUser(Long user_id){
        ObjectList<TicketDto> objectList = new ObjectList<>();
        objectList.setTicketsDto(ticketService.getTicketsByUser(user_id));
        return objectList;
    }


}
