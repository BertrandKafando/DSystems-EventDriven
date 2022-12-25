package ma.enset.contraventioncommandside.controllers;

import lombok.AllArgsConstructor;
import ma.enset.CreateInfractionCommand;
import ma.enset.dtos.InfractionDTO;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@AllArgsConstructor
@RequestMapping("/api/infractions/command")
public class InfractionCommandController {
    private CommandGateway commandGateway;

    @PostMapping("/create")
    public CompletableFuture<String> createInfraction(@RequestBody InfractionDTO request){
        return  commandGateway.send( new CreateInfractionCommand(
                UUID.randomUUID().toString(),
                request.getDate(),
                request.getRadarNumber(),
                request.getMatriculeVehicle(),
                request.getSpeedVehicle(),
                request.getRadarSpeedMax(),
                request.getMontant()
        ));
    }
}
