package ma.enset.radarcommandside.aggregate;

import lombok.extern.slf4j.Slf4j;
import ma.enset.CreateRadarCommand;
import ma.enset.UpdateRadarCommand;
import ma.enset.event.RadarCreatedEvent;
import ma.enset.event.RadarUpdatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
@Slf4j
public class RadarAggregate {
    @AggregateIdentifier
    private String id;
    private Long maxSpeed;
    private String longitude;
    private String latitude;

    public RadarAggregate(){

    }

    @CommandHandler
    public RadarAggregate(CreateRadarCommand command){
        //test règle metier
        log.info("CreatedRadarCommand received");
        AggregateLifecycle.apply(new RadarCreatedEvent(
                command.getId(),
                command.getMaxSpeed(),
                command.getLongitude(),
                command.getLatitude()
        ));
    }

    @EventSourcingHandler
    public  void on(RadarCreatedEvent event){
        log.info("CreatedRadarEvent occured");
        this.id = event.getId();
        this.maxSpeed = event.getMaxSpeed();
        this.latitude = event.getLatitude();
        this.longitude = event.getLongitude();

    }

    //update

    @CommandHandler
    public RadarAggregate(UpdateRadarCommand command){
        //test règle metier
        log.info("UpdatedRadarCommand received");
        AggregateLifecycle.apply(new RadarUpdatedEvent(
                command.getId(),
                command.getMaxSpeed(),
                command.getLongitude(),
                command.getLatitude()
        ));
    }
    @EventSourcingHandler
    public  void on(RadarUpdatedEvent event){
        log.info("UpdatedRadarEvent occured");
        this.id = event.getId();
        this.maxSpeed = event.getMaxSpeed();
        this.latitude = event.getLatitude();
        this.longitude = event.getLongitude();

    }

}
