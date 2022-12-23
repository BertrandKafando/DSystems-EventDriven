package ma.enset.cqrsaxionfwk.commands.controllers;

import lombok.AllArgsConstructor;
import ma.enset.cqrsaxionfwk.commands.dtos.CreateAccountRequestDTO;
import ma.enset.cqrsaxionfwk.commonapi.commands.CreateAccountCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/commands/accounts")
@AllArgsConstructor
public class AccountCommandController {
    //cree des commandes
    private CommandGateway commandGateway;

   @PostMapping("/create")
    public CompletableFuture<String> createAccount(@RequestBody CreateAccountRequestDTO createAccountRequestDTO){
     CompletableFuture<String>  response = commandGateway.send( new CreateAccountCommand(
               UUID.randomUUID().toString(),
               createAccountRequestDTO.getInitialBalance(),
               createAccountRequestDTO.getCurrency())
       );
      return  response;
    }


}
