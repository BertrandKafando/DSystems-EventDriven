package ma.enset.radarqueryside.repositories;

import ma.enset.radarqueryside.entities.Radar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RadarRepository extends JpaRepository<Radar,String> {
}
