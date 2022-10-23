package com.final_project.staselko.servise.client;

import com.final_project.staselko.converter.dto.UserConverter;
import com.final_project.staselko.model.dto.TicketDto;
import com.final_project.staselko.model.dto.UserDto;
import com.final_project.staselko.model.entiti.*;
import com.final_project.staselko.utils.entiti.UserProvider;
import com.final_project.staselko.utils.param.DescriptionHistoryCreator;
import com.final_project.staselko.utils.param.ParamCreator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
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

    @Value("${get_ticket_by_id}")
    private String get_ticket_by_id;


    public void createTicket(String description,
                             String desired_resolution_date,
                             String name,
                             String text,
                             String urgency,
                             String state,
                             String category) {

        HttpEntity<String> req1 = new HttpEntity<>(addHeaders());
        ResponseEntity<Category> result = restTemplate.
                exchange(get_categories + creator.getParamToURL(category),
                        HttpMethod.GET, req1, Category.class);
        Category categoryObject = result.getBody();

        TicketDto ticketDto = new TicketDto();
        ticketDto.setCategory(categoryObject);
        ticketDto.setOwner(ownerDto());
        ticketDto.setName(name);
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
        HttpEntity<TicketDto> req2 = new HttpEntity<>(ticketDto, addHeaders());
        Ticket ticket = restTemplate.postForObject(post_tickets, req2, Ticket.class);

        if (state.equals("1")) {
        History history = new History();
        history.setTicket(ticket);
        history.setUser(owner());
        history.setAction(descriptionCreator.actionCreate());
        history.setDescription(descriptionCreator.descriptionCreate());
        HttpEntity<History> req3 = new HttpEntity<>(history, addHeaders());
        restTemplate.exchange(post_histories, HttpMethod.POST, req3, History.class);
        }

        if (text != null) {
            Comment comment = new Comment();
            comment.setUser(owner());
            comment.setText(text);
            comment.setTicket(ticket);
            HttpEntity<Comment> req4 = new HttpEntity<>(comment, addHeaders());
            restTemplate.exchange(post_comments, HttpMethod.POST, req4, Comment.class);
        }
    }

    @Override
    public ResponseEntity<TicketDto> showTicket(final Long id) {
        HttpEntity<String> req = new HttpEntity<>(addHeaders());
        Map<String, String> params = new HashMap<>();
        params.put("id", String.valueOf(id));
        ResponseEntity<TicketDto> result = restTemplate.getForEntity(get_ticket_by_id, TicketDto.class, params);
        return result;
    }

    private HttpHeaders addHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setBasicAuth("A2@gmail.com", "Ee456*");
        return headers;
    }

    private User owner() {
        return userProvider.getCurrentUser();
    }

    private UserDto ownerDto() {
        return userConverter.toUserDto(userProvider.getCurrentUser());
    }
}
