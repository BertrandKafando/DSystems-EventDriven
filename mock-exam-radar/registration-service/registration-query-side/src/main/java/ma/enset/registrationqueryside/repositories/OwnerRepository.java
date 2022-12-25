package ma.enset.registrationqueryside.repositories;

import ma.enset.registrationqueryside.entities.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends JpaRepository<Owner,String> {
}
