## Initiation to CQRS Pattern with axion Framework

### stack & packages

```
-lambock
-spring web & data jpa
-mysql driver
-axon framework

```


## Create commands  package command
```
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
```
### Ceation d'un command Handler pour traiter la commande
```




## Create des query package query



## create common api

