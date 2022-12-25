package ma.enset.radarqueryside.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Radar {
    @Id
    private String id;
    private Long speedMax;
    @OneToOne
    private Coordonnee coordonnee;
}
