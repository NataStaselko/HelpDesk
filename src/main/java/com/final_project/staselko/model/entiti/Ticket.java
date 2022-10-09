package com.final_project.staselko.model.entiti;

import com.final_project.staselko.model.enums.State;
import com.final_project.staselko.model.enums.Urgency;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "TICKETS")
public class Ticket implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "Tickets_id")
    @Column(name = "ID", nullable = false, updatable = false)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "CREATED_ON")
    private LocalDate created_on = LocalDate.now();

    @Column(name = "DESIRED_RESOLUTION_DATE")
    private LocalDate desired_resolution_date;

    @Column(name = "STATE_ID")
    private State state_id;

    @Column(name = "URGENCY_ID")
    private Urgency urgency_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ASSIGNEE_ID")
    private User engineer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OWNER_ID")
    private User owner;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "APPROVER_ID")
    private User manager;

    @OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Feedback> feedbacks = new ArrayList<>();

    @OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<History> histories = new ArrayList<>();

    @OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Attachment> attachments = new ArrayList<>();

}
