package com.final_project.staselko.model.entiti;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Data
@Entity
@Table(name = "COMMENTS")
public class Comment implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "Comments_id")
    @Column(name = "ID", nullable = false, updatable = false)
    private Long id;

    @Column(name = "TEXT")
    private String text;

    @Temporal(TemporalType.TIME)
    @Column(name = "DATE")
    private Date data;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TICKET_ID")
    private Ticket ticket;
}
