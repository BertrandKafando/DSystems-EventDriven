package ma.enset.contraventionqueryside.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Radar {
    private String id;
    private Long speedMax;
    private double longtitude;
    private double latitude;
}
