package ma.enset.registrationqueryside.repositories;

import ma.enset.registrationqueryside.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle,String> {

    public Vehicle findByOwnerId(String id);
}
