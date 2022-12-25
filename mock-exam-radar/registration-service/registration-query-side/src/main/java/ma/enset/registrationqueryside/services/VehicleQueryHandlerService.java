package ma.enset.registrationqueryside.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.enset.query.*;
import ma.enset.registrationqueryside.entities.Owner;
import ma.enset.registrationqueryside.entities.Vehicle;
import ma.enset.registrationqueryside.repositories.VehicleRepository;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
@Slf4j
public class VehicleQueryHandlerService {
    private VehicleRepository repository ;

    @QueryHandler
    public List<Vehicle> getvehicles(GetAllVehiclesQuery query){
        return repository.findAll();
    }

    @QueryHandler
    public Vehicle  getVehicle (GetVehicleByIdQuery query){
        return repository.findById(query.getId())
                .orElseThrow(()->new RuntimeException("Vehicle not found"));
    }

    @QueryHandler
    public Vehicle  getVehicleByOwner (GetVehicleByOwnerQuery query){
        return repository.findByOwnerId(query.getId());
    }


}
