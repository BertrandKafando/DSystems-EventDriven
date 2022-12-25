package ma.enset.registrationqueryside.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.enset.event.VehicleCreatedEvent;
import ma.enset.event.VehicleUpdatedEvent;
import ma.enset.registrationqueryside.entities.Owner;
import ma.enset.registrationqueryside.entities.Vehicle;
import ma.enset.registrationqueryside.repositories.OwnerRepository;
import ma.enset.registrationqueryside.repositories.VehicleRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Service;

import java.util.UUID;

@AllArgsConstructor
@Service
@Slf4j
public class VehicleEventHandlerService {
    private OwnerRepository ownerRepository;
    private VehicleRepository vehicleRepository;

    @EventHandler
    public void on (VehicleCreatedEvent event){
        log.info("******************************");
        log.info("VehicleCreated Event received");
        Owner owner= ownerRepository.getById(event.getOwner().getId());
        Vehicle vehicle = new Vehicle();
        vehicle.setId(event.getId());
        vehicle.setMatricule(event.getMatricule());
        vehicle.setModel(event.getModel());
        vehicle.setPuissance(event.getPuissance());
        vehicle.setOwner(owner);
        vehicle.setBrand(event.getBrand());
        vehicleRepository.save(vehicle);

    }

    @EventHandler
    public void on (VehicleUpdatedEvent event){
        log.info("******************************");
        log.info("VehicleCreated Event received");
        Owner owner= ownerRepository.getById(event.getId());
        Vehicle vehicle = new Vehicle();
        vehicle.setId(event.getId());
        vehicle.setMatricule(event.getMatricule());
        vehicle.setModel(event.getModel());
        vehicle.setPuissance(event.getPuissance());
        vehicle.setOwner(owner);
        vehicle.setBrand(event.getBrand());
        vehicleRepository.save(vehicle);

    }
}
