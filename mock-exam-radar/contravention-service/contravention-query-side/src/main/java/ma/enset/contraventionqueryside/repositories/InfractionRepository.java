package ma.enset.contraventionqueryside.repositories;

import ma.enset.contraventionqueryside.entities.Infraction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfractionRepository extends JpaRepository<Infraction,String> {

}
