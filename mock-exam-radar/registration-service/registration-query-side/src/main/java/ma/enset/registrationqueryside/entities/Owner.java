package ma.enset.registrationqueryside.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Owner {
    @Id
    private String id;
    private String name;
    private String email;

    @JsonIgnore
    @OneToMany(mappedBy = "owner")
    List<Vehicle> vehicles;
}
