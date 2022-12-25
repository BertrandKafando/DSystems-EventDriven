package ma.enset.radarcommandside.controller;

import lombok.AllArgsConstructor;
import ma.enset.CreateRadarCommand;
import ma.enset.UpdateRadarCommand;
import ma.enset.dtos.RadarCommandDTO;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/radars/command")
@AllArgsConstructor
public class RadarCommandController {
    private CommandGateway commandGateway;

     @PostMapping("/create")
    public CompletableFuture<String> createRadar(@RequestBody RadarCommandDTO request){
         CompletableFuture<String> response = commandGateway.send(new CreateRadarCommand(
                 UUID.randomUUID().toString(),
                 request.getMaxSpeed(),
                 request.getLongitude(),
                 request.getLatitude()
         ));
          return  response;
     }
    @PutMapping("/update/{id}")
    public CompletableFuture<String> updateRadar(@RequestBody RadarCommandDTO request, @PathVariable String id){
        CompletableFuture<String> response = commandGateway.send(new UpdateRadarCommand(
                id,
                request.getMaxSpeed(),
                request.getLongitude(),
                request.getLatitude()
        ));
        return  response;
    }
}
