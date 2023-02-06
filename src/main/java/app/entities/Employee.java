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
public class Employee extends Personn{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EMPLOYEE_ID")
    private long id;

    @Column(length = 300, nullable = false)
    private String adress;

    @OneToMany(mappedBy = "employee")
    private Set<WorkDetail> workDetails = new LinkedHashSet<>();

//    @OneToOne(mappedBy = "director")
//    private Hotel isDirectorId;


}
