package app.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "RESERVATION")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RESERVATIONID")
    private long id;

    @Column(updatable = false, nullable = false)
    private LocalDate dateCreation;

    @Column(nullable = false)
    private double price;


    private double discount;


    @Column(name = "BREAKFIRSTINCLUDED", nullable = false)
    private boolean breakFirstIncluded;

    @Column(nullable = false)
    private LocalDate dateBegin;

    @Column(nullable = false)
    private LocalDate dateEnd;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "chambre id", nullable = false)
    private Chambre chambre;

}
