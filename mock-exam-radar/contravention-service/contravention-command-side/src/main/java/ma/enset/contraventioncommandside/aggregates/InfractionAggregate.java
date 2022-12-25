package ma.enset.contraventioncommandside.aggregates;

import lombok.extern.slf4j.Slf4j;
import ma.enset.CreateInfractionCommand;
import ma.enset.event.InfractionCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.Date;

@Aggregate
@Slf4j
public class InfractionAggregate {
    @AggregateIdentifier
    private String id;
    private Date date;
    private String radarNumer;
    private String matriculeVehcle;
    private Double speedVehicle;
    private Double radarSpeedMax ;
    private Double montant;


    public InfractionAggregate() {
    }

    @CommandHandler
    public InfractionAggregate (CreateInfractionCommand command){
        log.info("******************************");
        log.info("CreateInfractionCommand received");

        //test

        AggregateLifecycle.apply(new InfractionCreatedEvent(
                command.getId(),
                command.getDate(),
                command.getRadarNumber(),
                command.getMatriculeVehicle(),
                command.getSpeedVehicle(),
                command.getRadarSpeedMax(),
                command.getMontant()
        ));

    }

    @EventSourcingHandler
    public void  on (InfractionCreatedEvent event){
        log.info("******************************");
        log.info("InfractionCreatedEvent occured");
        this.id = event.getId();
        this.date = event.getDate();
        this.radarNumer = event.getRadarNumber();
        this.radarSpeedMax = event.getRadarSpeedMax();
        this.matriculeVehcle = event.getMatriculeVehicle();
        this.speedVehicle = event.getSpeedVehicle();
        this.montant = event.getMontant();
    }
}
