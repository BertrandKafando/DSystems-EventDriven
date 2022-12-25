package ma.enset.registrationqueryside.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {
    @Id
    private String id;
    private String matricule;
    private String brand;
    private Long puissance;
    private String model;
    @ManyToOne
    private Owner owner;
}
