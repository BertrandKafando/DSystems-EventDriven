package ma.enset.registrationcommandside.controller;

import lombok.AllArgsConstructor;
import ma.enset.CreateVehicleCommand;
import ma.enset.UpdateVehicleCommand;
import ma.enset.dtos.VehiculeCommandDTO;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/vehicles/command")
@AllArgsConstructor
public class VehicleCommandController {

    private CommandGateway commandGateway;

    @PostMapping("/create")
   public CompletableFuture<String> createVehicle(@RequestBody VehiculeCommandDTO request){
        return commandGateway.send(new CreateVehicleCommand(
                UUID.randomUUID().toString(),
                request.getMatricule(),
                request.getBrand(),
                request.getPuissance(),
                request.getModel(),
                request.getOwner()

        ));
    }

    @PostMapping("/update/{id}")
    public CompletableFuture<String> updateVehicle(@RequestBody VehiculeCommandDTO request, @PathVariable String id){
        return commandGateway.send(new UpdateVehicleCommand(
                id,
                request.getMatricule(),
                request.getBrand(),
                request.getPuissance(),
                request.getModel(),
                request.getOwner()

        ));
    }
}
