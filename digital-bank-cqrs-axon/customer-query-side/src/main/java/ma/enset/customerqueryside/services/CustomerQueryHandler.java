package ma.enset.customerqueryside.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.enset.Customer.query.GetAllCustomersQuerry;
import ma.enset.Customer.query.GetCustomerByIdQuery;
import ma.enset.customerqueryside.entities.Customer;
import ma.enset.customerqueryside.repositories.CustomerRepository;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class CustomerQueryHandler {
    public CustomerRepository customerRepository;

    @QueryHandler
    public List<Customer> customerList(GetAllCustomersQuerry query){
        return customerRepository.findAll();
    }
    @QueryHandler
    public Customer customerList(GetCustomerByIdQuery query){
        return customerRepository.findById(query.getId())
                .orElseThrow(()->new RuntimeException("Customer not fount"));
    }
}
