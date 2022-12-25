package ma.enset.radarqueryside.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Coordonnee {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String longitude;
    private String latitude;
    @OneToOne
    private Radar radar;
}
