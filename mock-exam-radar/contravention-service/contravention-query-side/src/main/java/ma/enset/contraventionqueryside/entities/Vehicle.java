package ma.enset.contraventionqueryside.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
    private String ownerId;
}
