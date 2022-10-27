package com.final_project.staselko.servise.client;

import com.final_project.staselko.converter.dto.UserConverter;
import com.final_project.staselko.model.dto.CommentDto;
import com.final_project.staselko.model.dto.HistoryDto;
import com.final_project.staselko.model.dto.TicketDto;
import com.final_project.staselko.model.dto.UserDto;
import com.final_project.staselko.model.entiti.*;
import com.final_project.staselko.utils.entiti.ObjectList;
import com.final_project.staselko.utils.entiti.UserProvider;
import com.final_project.staselko.utils.param.DescriptionHistoryCreator;
import com.final_project.staselko.utils.param.ParamCreator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
@RequiredArgsConstructor
@PropertySource("classpath:url.properties")
public class ClientServiceImpl implements ClientService {
    private final UserConverter userConverter;
    private final RestTemplate restTemplate;
    private final UserProvider userProvider;
    private final ParamCreator creator;
    private final DescriptionHistoryCreator descriptionCreator;


    @Value("${post_tickets}")
    private String post_tickets;

    @Value("${post_comments}")
    private String post_comments;

    @Value("${get_categories_name}")
    private String get_categories;

    @Value("${post_histories}")
    private String post_histories;

    @Value("${get(put)_ticket_by_id}")
    private String get_ticket_by_id;

    @Value("${get(put)_comments_by_id}")
    private String get_comments_by_id;

    @Value("${get_tickets_by_user}")
    private String get_tickets_by_user;

    @Value("${get_tickets_all}")
    private String get_tickets_all;

    @Value("${get_histories_by_ticket}")
    private String get_histories_by_ticket;

    @Value("${get_comments_by_ticket}")
    private String get_comments_by_ticket;

    public void createTicket(String description,
                             String desired_resolution_date,
                             String name,
                             String text,
                             String urgency,
                             String state,
                             String category) {

        Category categoryObject = addCategory(category);
        TicketDto ticketDto = addTicketDto(description, desired_resolution_date, name, urgency, state, categoryObject);
        HttpEntity<TicketDto> request = new HttpEntity<>(ticketDto, addHeaders());
        Ticket ticket = restTemplate.postForObject(post_tickets, request, Ticket.class);
        addHistory(state, ticket);
        addComment(text, ticket);
    }

    @Override
    public TicketDto showTicket(final Long id) {
        Map<String, String> params = new HashMap<>();
        params.put("id", String.valueOf(id));
        TicketDto result = restTemplate.getForObject(get_ticket_by_id, TicketDto.class, params);
        return result;
    }

    @Override
    public void editTicket(final Long id,
                           String description,
                           String desired_resolution_date,
                           String name,
                           String text,
                           String urgency,
                           String state,
                           String category) {

        Category categoryObject = addCategory(category);
        TicketDto ticketDto = addTicketDto(description, desired_resolution_date, name, urgency, state, categoryObject);
        Map<String, String> params = new HashMap<>();
        params.put("id", String.valueOf(id));
        HttpEntity<TicketDto> request = new HttpEntity<>(ticketDto, addHeaders());
        ResponseEntity<Ticket> result = restTemplate.exchange(get_ticket_by_id, HttpMethod.PUT, request, Ticket.class, params);
        Ticket ticket = result.getBody();
        addHistory(state, ticket);
        changeComment(text, ticket);
    }

    @Override
    public List<TicketDto> getAllTickets() {
        String uri = get_tickets_all + user().getId();
        ObjectList<TicketDto> objectList = restTemplate.getForObject(uri, ObjectList.class);
        return objectList.getTicketsDto();
    }

    @Override
    public List<TicketDto> getTicketsByUser() {
        String uri = get_tickets_by_user + user().getId();
        ObjectList<TicketDto> objectList = restTemplate.getForObject(uri, ObjectList.class);
        return objectList.getTicketsDto();
    }

    @Override
    public List<HistoryDto> getHistoryByTicket(Long ticket_id) {
        String uri = get_histories_by_ticket + ticket_id;
        ObjectList<HistoryDto> objectList = restTemplate.getForObject(uri, ObjectList.class);
        return objectList.getTicketsDto();
    }

    @Override
    public List<CommentDto> getCommentsByTicket(Long ticket_id) {
        String uri = get_comments_by_ticket + ticket_id;
        ObjectList<CommentDto> objectList = restTemplate.getForObject(uri, ObjectList.class);
        return objectList.getTicketsDto();
    }

    private Category addCategory(String category) {
        HttpEntity<String> request = new HttpEntity<>(addHeaders());
        ResponseEntity<Category> result = restTemplate.
                exchange(get_categories + creator.getParamToURL(category),
                        HttpMethod.GET, request, Category.class);
        return result.getBody();
    }

    private TicketDto addTicketDto(String description,
                                   String desired_resolution_date,
                                   String name,
                                   String urgency,
                                   String state,
                                   Category categoryObject) {
        TicketDto ticketDto = new TicketDto();
        ticketDto.setName(name);
        ticketDto.setOwner(userDto());
        if (description != null) {
            ticketDto.setDescription(description);
        }
        if (desired_resolution_date != null) {
            ticketDto.setDesired_resolution_date(desired_resolution_date);
        } else {
            ticketDto.setDesired_resolution_date(LocalDate.now()
                    .plusDays(Long.parseLong(urgency))
                    .format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        }
        ticketDto.setUrgency(urgency);
        ticketDto.setState(state);
        ticketDto.setCategory(categoryObject);
        return ticketDto;
    }

    private void addHistory(String state, Ticket ticket) {
        if (ticket != null) {
            History history = new History();
            history.setTicket(ticket);
            history.setUser(user());
            if (state.equals("0")) {
                history.setAction(descriptionCreator.actionEdit());
                history.setDescription(descriptionCreator.descriptionEdit());
            }
            if (state.equals("1")) {
                history.setAction(descriptionCreator.actionCreate());
                history.setDescription(descriptionCreator.descriptionCreate());
            }
            HttpEntity<History> request = new HttpEntity<>(history, addHeaders());
            restTemplate.exchange(post_histories, HttpMethod.POST, request, History.class);
        }
    }
    private void addComment(String text, Ticket ticket) {
        if (text != null) {
            Comment comment = new Comment();
            comment.setUser(user());
            comment.setText(text);
            comment.setTicket(ticket);
            HttpEntity<Comment> request = new HttpEntity<>(comment, addHeaders());
            restTemplate.exchange(post_comments, HttpMethod.POST, request, Comment.class);
        }
    }

    private void changeComment(String text, Ticket ticket) {
        if (ticket != null) {
            if (ticket.getComments().isEmpty()) {
                addComment(text, ticket);
            } else {
                Comment comment = ticket.getComments().get(0);
                comment.setText(text);
                Map<String, String> params = new HashMap<>();
                params.put("id", String.valueOf(comment.getId()));
                HttpEntity<Comment> request = new HttpEntity<>(comment, addHeaders());
                restTemplate.exchange(get_comments_by_id, HttpMethod.PUT, request, Comment.class, params);
            }
        }
    }

    private HttpHeaders addHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setBasicAuth("M1@gmail.com", "Mm123*");  //токен
        return headers;
    }
    private String getState(){
        if (user().getRole_id().getCode() == 1){
           return  "1";
        }
        if (user().getRole_id().getCode() == 2){
           return  "3";
        }
        return null;
    }

    private User user() {
        return userProvider.getCurrentUser();
    }

    private UserDto userDto() {
        return userConverter.toUserDto(userProvider.getCurrentUser());
    }

}
