package ma.enset.registrationcommandside.aggregate;

import lombok.extern.slf4j.Slf4j;
import ma.enset.CreateOwnerCommand;
import ma.enset.UpdateOwnerCommand;
import ma.enset.event.OwnerCreatedEvent;
import ma.enset.event.OwnerUpdatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
@Slf4j
public class OwnerAggregate {
    @AggregateIdentifier
    private String id;
    private  String name;
    private String email;

    public OwnerAggregate() {
    }

    @CommandHandler
    public OwnerAggregate(CreateOwnerCommand command){
        log.info("******************");
        log.info("CreateOwnerCommand Received");
        //test
        AggregateLifecycle.apply(new OwnerCreatedEvent(
                command.getId(),
                command.getName(),
                command.getEmail()
        ));
    }

    @EventSourcingHandler
    public  void on(OwnerCreatedEvent event){
        log.info("****************************");
        log.info("OwnerCreatedEvent occured");
        //test
        this.id = event.getId();
        this.name = event.getName();
        this.email = event.getEmail();
    }

    @CommandHandler
    public OwnerAggregate(UpdateOwnerCommand command){
        log.info("******************");
        log.info("UpdateOwnerCommand Received");
        //test
        AggregateLifecycle.apply(new OwnerUpdatedEvent(
                command.getId(),
                command.getName(),
                command.getEmail()
        ));
    }

    @EventSourcingHandler
    public  void on(OwnerUpdatedEvent event){
        log.info("****************************");
        log.info("OwnerUpdatedEvent occured");
        //test
        this.id = event.getId();
        this.name = event.getName();
        this.email = event.getEmail();
    }

}
