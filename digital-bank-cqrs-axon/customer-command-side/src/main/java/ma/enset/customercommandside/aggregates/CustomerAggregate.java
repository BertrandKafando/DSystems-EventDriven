package ma.enset.customercommandside.aggregates;

import lombok.extern.slf4j.Slf4j;
import ma.enset.Customer.command.CreateCustomerCommand;
import ma.enset.Customer.event.CustomerCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
@Slf4j
public class CustomerAggregate {
    @AggregateIdentifier
    private String customerId;
    private String name;
    private String email;

    public CustomerAggregate() {
        //require by axon
    }
    // decision function
    @CommandHandler
    public CustomerAggregate(CreateCustomerCommand command) {
        //test before create event (business rule)
        log.info("CreateCustomerCommand received");
        AggregateLifecycle.apply(new CustomerCreatedEvent(
                command.getId(),
                command.getName(),
                command.getEmail()
        ));
    }

    //evolution function
    @EventSourcingHandler
    public void on(CustomerCreatedEvent event){
        log.info("CustomerCreatedEvent occured");
        this.customerId=event.getId();
        this.name=event.getName();
        this.email=event.getEmail();
    }


}
