package ma.enset.radarqueryside.services;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.enset.event.RadarCreatedEvent;
import ma.enset.event.RadarUpdatedEvent;
import ma.enset.radarqueryside.entities.Coordonnee;
import ma.enset.radarqueryside.entities.Radar;
import ma.enset.radarqueryside.repositories.CoordonneeRepository;
import ma.enset.radarqueryside.repositories.RadarRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Service
@AllArgsConstructor
@Slf4j
public class RadarEventHandlerService {
    private RadarRepository radarRepository;
    private CoordonneeRepository coordonneeRepository;

    @EventHandler
    public void on(RadarCreatedEvent event){
        log.info("************************");
        log.info("RadarCreatedEvent received");
        Coordonnee coordonnee = new Coordonnee();
        coordonnee.setLongitude(event.getLongitude());
        coordonnee.setLatitude(event.getLatitude());
       Coordonnee savedCoordonne=  coordonneeRepository.save(coordonnee);
       Radar radar = new Radar();
       radar.setId(event.getId());
       radar.setSpeedMax(event.getMaxSpeed());
       radar.setCoordonnee(savedCoordonne);
       radarRepository.save(radar);
    }

    @EventHandler
    public void on(RadarUpdatedEvent event){
        log.info("************************");
        log.info("RadarUpdatedEvent received");
        Coordonnee coordonnee = new Coordonnee();
        coordonnee.setLongitude(event.getLongitude());
        coordonnee.setLatitude(event.getLatitude());
        Coordonnee savedCoordonne=  coordonneeRepository.save(coordonnee);
        Radar radar = new Radar();
        radar.setId(event.getId());
        radar.setSpeedMax(event.getMaxSpeed());
        radar.setCoordonnee(savedCoordonne);
        radarRepository.save(radar);
    }
}
