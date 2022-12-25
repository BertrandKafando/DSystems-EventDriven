package ma.enset.contraventionqueryside.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Infraction {
    @Id
    private String id;
    private Date date;
    private Double montant;
    private String matriculeVehicle;
    private String radarNumber;
    private Double speedVehicle;
    private Double radarSpeedMax;

    @Transient
    private Vehicle vehicle;
    @Transient
    private Radar radar;
}

