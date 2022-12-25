package ma.enset.registrationqueryside.controllers;

import lombok.AllArgsConstructor;
import ma.enset.query.GetAllOwners;
import ma.enset.query.GetAllVehiclesQuery;
import ma.enset.query.GetOwnerByIdQuery;
import ma.enset.query.GetVehicleByIdQuery;
import ma.enset.registrationqueryside.entities.Owner;
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
@RequestMapping("/api/owners/query/")
public class OwnerController {
    private QueryGateway queryGateway;

    @GetMapping("/all")
    public CompletableFuture<List<Owner>> getAllOwners (){
        return  queryGateway.query(new GetAllOwners(),  ResponseTypes.multipleInstancesOf(Owner.class));
    }

    @GetMapping("/byId/{id}")
    public CompletableFuture<Owner> getOwner(@PathVariable String id){
        return  queryGateway.query(new GetOwnerByIdQuery(id),ResponseTypes.instanceOf(Owner.class));
    }
}
