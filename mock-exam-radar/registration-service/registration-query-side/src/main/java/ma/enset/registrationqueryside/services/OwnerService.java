package ma.enset.registrationqueryside.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.enset.event.OwnerCreatedEvent;
import ma.enset.event.OwnerUpdatedEvent;
import ma.enset.query.GetAllOwners;
import ma.enset.query.GetOwnerByIdQuery;
import ma.enset.query.GetVehicleByIdQuery;
import ma.enset.registrationqueryside.entities.Owner;
import ma.enset.registrationqueryside.entities.Vehicle;
import ma.enset.registrationqueryside.repositories.OwnerRepository;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
@Slf4j
public class OwnerService {
    private OwnerRepository ownerRepository;

    @EventHandler
    public void on (OwnerCreatedEvent event){
        log.info("********************");
        log.info("OwnerCreatedEvent  received");
        Owner owner = new Owner();
        owner.setId(event.getId());
        owner.setName(event.getName());
        owner.setEmail(event.getEmail());
        ownerRepository.save(owner);
    }

    @EventHandler
    public void on (OwnerUpdatedEvent event){
        log.info("********************");
        log.info("OwnerUpdatedEvent  received");
        Owner owner = new Owner();
        owner.setId(event.getId());
        owner.setName(event.getName());
        owner.setEmail(event.getEmail());
        ownerRepository.save(owner);
    }

    @QueryHandler
    public List<Owner> getAllOwners(GetAllOwners query){
        return ownerRepository.findAll();
    }

    @QueryHandler
    public Owner getOwner (GetOwnerByIdQuery query){
        return ownerRepository.findById(query.getId())
                .orElseThrow(()->new RuntimeException("Owner not found"));
    }
}
