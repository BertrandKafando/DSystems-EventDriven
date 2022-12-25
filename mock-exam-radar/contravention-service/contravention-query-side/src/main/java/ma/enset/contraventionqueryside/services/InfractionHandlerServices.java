package ma.enset.contraventionqueryside.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.enset.contraventionqueryside.entities.Infraction;
import ma.enset.contraventionqueryside.repositories.InfractionRepository;
import ma.enset.event.InfractionCreatedEvent;
import ma.enset.query.GetAllInfractionsQuery;
import ma.enset.query.GetInfractioByIdQuery;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class InfractionHandlerServices {

    private InfractionRepository infractionRepository;

    @EventHandler
    public void on(InfractionCreatedEvent event){
        log.info("**************************");
        log.info("InfractionCreatedEvent received");
        Infraction infraction = new Infraction();
        infraction.setId(event.getId());
        infraction.setDate(event.getDate());
        infraction.setMontant(event.getMontant());
        infraction.setMatriculeVehicle(event.getMatriculeVehicle());
        infraction.setRadarSpeedMax(event.getRadarSpeedMax());
        infraction.setSpeedVehicle(event.getSpeedVehicle());
        infraction.setRadarNumber(event.getRadarNumber());
        infractionRepository.save(infraction);
    }


    @QueryHandler
    public Infraction on(GetInfractioByIdQuery query){
        return infractionRepository.findById(query
                .getId()).get();
    }


    @QueryHandler
    public List<Infraction> on(GetAllInfractionsQuery query){
        return infractionRepository.findAll();
    }
}
