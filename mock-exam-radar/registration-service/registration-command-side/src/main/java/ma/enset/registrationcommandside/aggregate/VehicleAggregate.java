package ma.enset.registrationcommandside.aggregate;

import lombok.extern.slf4j.Slf4j;
import ma.enset.CreateVehicleCommand;
import ma.enset.Owner;
import ma.enset.UpdateVehicleCommand;
import ma.enset.event.VehicleCreatedEvent;
import ma.enset.event.VehicleUpdatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
@Slf4j
public class VehicleAggregate {
    @AggregateIdentifier
    private String id;
    private String matricule;
    private String brand;
    private Long puissance;
    private String model;

    private Owner owner;

    public VehicleAggregate() {
    }

    // decision function
    @CommandHandler
    public VehicleAggregate(CreateVehicleCommand command){
        //test metier
        log.info("VehicleCommand received");

        AggregateLifecycle.apply(new VehicleCreatedEvent(
                command.getId(),
                command.getMatricule(),
                command.getBrand(),
                command.getPuissance(),
               command.getModel(),
               command.getOwner()
        ));

    }

    @EventSourcingHandler
    public void on(VehicleCreatedEvent event){
        log.info("CreateVehicleEvent occured");
        this.id = event.getId();
        this.brand = event.getBrand();
        this.matricule = event.getMatricule();
        this.model = event.getModel();
        this.puissance = event.getPuissance();
        this.owner = event.getOwner();
    }

    //update

    // decision function
    @CommandHandler
    public VehicleAggregate(UpdateVehicleCommand command){
        //test metier
        log.info("UpdateVehicleCommand received");

        AggregateLifecycle.apply(new VehicleUpdatedEvent(
                command.getId(),
                command.getMatricule(),
                command.getBrand(),
                command.getModel(),
                command.getPuissance(),
                command.getOwner()
        ));

    }

    @EventSourcingHandler
    public void on(VehicleUpdatedEvent event){
        log.info("VehicleUpdatedEvent occured");
        this.id = event.getId();
        this.brand = event.getBrand();
        this.matricule = event.getMatricule();
        this.model = event.getModel();
        this.puissance = event.getPuissance();
        this.owner = event.getOwner();
    }
}
