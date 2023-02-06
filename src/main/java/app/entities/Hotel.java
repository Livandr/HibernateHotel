package app.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "HOTEL")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "HOTELID")
    private Long id;

    @Column(name = "STARS", length = 1,nullable = false)
    private int stars;

    @Column(name = "NAME", length = 100, nullable = false)
    private String name;

    @Column(name = "ADRESS", length = 100, nullable = false)
    private String adress;

    @OneToMany(mappedBy = "hotel")
    private Set<Chambre> chambres = new LinkedHashSet<>();

    @OneToOne
    @JoinColumn(
            name = "director_id",
            unique = true,
            nullable = false
    )
    private Employee directeur;
    @OneToMany(mappedBy = "hotel")
    private Set<WorkDetail> details = new LinkedHashSet<>();
    @ManyToMany(mappedBy = "favorites")
    private Set<Customer> fidels = new LinkedHashSet<>();





}
