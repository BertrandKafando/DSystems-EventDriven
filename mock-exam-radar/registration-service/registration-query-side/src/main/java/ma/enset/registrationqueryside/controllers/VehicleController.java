package ma.enset.registrationqueryside.controllers;

import lombok.AllArgsConstructor;
import ma.enset.query.GetAllVehiclesQuery;
import ma.enset.query.GetVehicleByIdQuery;
import ma.enset.query.GetVehicleByOwnerQuery;
import ma.enset.registrationqueryside.entities.Vehicle;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@AllArgsConstructor
@RequestMapping("/api/vehicles/query/")
public class VehicleController {

    private QueryGateway queryGateway;

    @GetMapping("/all")
    public CompletableFuture<List<Vehicle>> getAllVehicles (){
        return  queryGateway.query(new GetAllVehiclesQuery(),  ResponseTypes.multipleInstancesOf(Vehicle.class));
    }

    @GetMapping("/byId/{id}")
    public CompletableFuture<Vehicle> getVehicle(@PathVariable String id){
        return  queryGateway.query(new GetVehicleByIdQuery(id),ResponseTypes.instanceOf(Vehicle.class));
    }

    @GetMapping("/owner/{id}")
    public CompletableFuture<Vehicle> getVehicleByOwner(@PathVariable String id){
        return  queryGateway.query(new GetVehicleByOwnerQuery(id),ResponseTypes.instanceOf(Vehicle.class));
    }
}
