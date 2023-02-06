package app.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Chambre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CHAMBRE_ID")
    private long id;

    @Column(name = "NUMERO", length = 5, nullable = false)
    private long numero;

    @Column(nullable = false)
    private int etage;

    @Column(nullable = false)
    private int size;

    @Column(nullable = false)
    private int capacity;

    @Column(nullable = false)
    private boolean available;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RoomType type;

    @ManyToOne
    @JoinColumn(
            name = "hotel_id",
            nullable = false
    )
    private Hotel hotel;

    @OneToMany(mappedBy = "chambre")
    private Set<Reservation> reservations = new LinkedHashSet<>();



}
