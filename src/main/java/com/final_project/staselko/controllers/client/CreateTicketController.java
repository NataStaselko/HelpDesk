package com.final_project.staselko.controllers.client;

import com.final_project.staselko.converter.dto.CommentConverter;
import com.final_project.staselko.model.dto.CommentDto;
import com.final_project.staselko.model.dto.TicketDto;
import com.final_project.staselko.model.entiti.Comment;
import com.final_project.staselko.model.entiti.Ticket;
import com.final_project.staselko.model.entiti.User;
import com.final_project.staselko.servise.TicketService;
import com.final_project.staselko.utils.entiti.UserProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.Collections;

@RestController
@RequestMapping("/owner/create")
@RequiredArgsConstructor
public class CreateTicketController {
    private final UserProvider userProvider;
    private final CommentConverter commentConverter;

    private final RestTemplate restTemplate;
  //  private final TicketService ticketService;

    @PostMapping(value = "/draft",produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<Comment> createTicketDraft(@Valid @RequestBody TicketDto ticketDto,
                                                     @RequestParam String text) throws InterruptedException {
        String name = userProvider.getCurrentUser().getEmail();
        String pass = userProvider.getCurrentUser().getPassword();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setBasicAuth(name, "Ee456*");//вопрос с паролем д.б. токен
       // HttpEntity<String> request = new HttpEntity<>(text, headers);
        HttpEntity<TicketDto> req = new HttpEntity<>(ticketDto,headers);
        ticketDto.setUrgency("DRAFT");
       // ticketDto.setOwner(userProvider.getCurrentUser());
        Ticket ticket = restTemplate.postForObject("http://localhost:8080/tickets",req, Ticket.class);

        Comment comment = new Comment();
        //Thread.sleep(1000);
        comment.setUser(userProvider.getCurrentUser());
        comment.setText(text);
        comment.setTicket(ticket);
        HttpEntity<Comment>request = new HttpEntity<>(comment,headers);

        //restTemplate.postForEntity("http://localhost:8080/tickets", ticketDto, Ticket.class);

        return restTemplate.postForEntity("http://localhost:8080/comments", request, Comment.class);
       // return ResponseEntity.status(HttpStatus.OK).body(userProvider.getCurrentUser());

    }

}
