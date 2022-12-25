package ma.enset.radarqueryside.repositories;

import ma.enset.radarqueryside.entities.Coordonnee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoordonneeRepository extends JpaRepository<Coordonnee, String> {
}
