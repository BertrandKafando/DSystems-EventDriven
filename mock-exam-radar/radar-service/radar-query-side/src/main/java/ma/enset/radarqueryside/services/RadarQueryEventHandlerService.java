package ma.enset.radarqueryside.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.enset.query.GetAllRadarQuery;
import ma.enset.query.GetRadarByIdQuery;
import ma.enset.radarqueryside.entities.Radar;
import ma.enset.radarqueryside.repositories.CoordonneeRepository;
import ma.enset.radarqueryside.repositories.RadarRepository;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class RadarQueryEventHandlerService {
    private RadarRepository radarRepository;
    @QueryHandler
    public List<Radar> radarList(GetAllRadarQuery query){
        return radarRepository.findAll();
    }
    @QueryHandler
    public Radar radarById(GetRadarByIdQuery query){
        return radarRepository.findById(query.getId())
                .orElseThrow(()->new RuntimeException("Radar not fount"));
    }
}
