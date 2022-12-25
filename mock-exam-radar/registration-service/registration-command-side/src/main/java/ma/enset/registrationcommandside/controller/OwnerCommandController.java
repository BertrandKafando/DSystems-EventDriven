package ma.enset.registrationcommandside.controller;

import lombok.AllArgsConstructor;
import ma.enset.CreateOwnerCommand;
import ma.enset.UpdateOwnerCommand;
import ma.enset.dtos.OwnerDTO;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/owners/command")
@AllArgsConstructor
public class OwnerCommandController {
    private CommandGateway commandGateway;

    @PostMapping("/create")
    public CompletableFuture<String> createOwner (@RequestBody OwnerDTO ownerDTO){
        return  commandGateway.send(new CreateOwnerCommand(
                UUID.randomUUID().toString(),
                ownerDTO.getName(),
                ownerDTO.getEmail()
        ));
    }

    @PostMapping("/update")
    public CompletableFuture<String> updateOwner (@RequestBody OwnerDTO ownerDTO, @PathVariable String id){
        return  commandGateway.send(new UpdateOwnerCommand(
                id,
                ownerDTO.getName(),
                ownerDTO.getEmail()
        ));
    }
}
