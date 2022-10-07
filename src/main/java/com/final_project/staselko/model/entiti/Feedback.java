package com.final_project.staselko.model.entiti;
import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "FEEDBACKS")
public class Feedback implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "Feedbacks_id")
    @Column(name = "ID", nullable = false, updatable = false)
    private Long id;

    @Column(name = "RATE")
    private int rate;

    @Temporal(TemporalType.TIME)
    @Column(name = "Date")
    private Date date;

    @Column(name = "TEXT")
    private String text;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TICKET_ID")
    private Ticket ticket;

}
