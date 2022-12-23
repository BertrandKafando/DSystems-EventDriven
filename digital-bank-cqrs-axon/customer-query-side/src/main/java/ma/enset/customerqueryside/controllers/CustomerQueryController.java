package ma.enset.customerqueryside.controllers;

import lombok.AllArgsConstructor;
import ma.enset.Customer.query.GetAllCustomersQuerry;
import ma.enset.Customer.query.GetCustomerByIdQuery;
import ma.enset.customerqueryside.entities.Customer;
import org.axonframework.messaging.responsetypes.ResponseType;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/queries/customers")
@AllArgsConstructor
public class CustomerQueryController {
    private QueryGateway queryGateway;

    @GetMapping("/all")
    public CompletableFuture<List<Customer>>customers(){
        return queryGateway.query(new GetAllCustomersQuerry(), ResponseTypes.multipleInstancesOf(Customer.class));
    }
    @GetMapping("/byId/{id}")
    public CompletableFuture<Customer> getCustomer(@PathVariable String id){
        return queryGateway.query(new GetCustomerByIdQuery(id),
                ResponseTypes.instanceOf(Customer.class));
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exceptionHandler(Exception exception){
        ResponseEntity<String > responseEntity=
                new ResponseEntity(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        return responseEntity;
    }
}
