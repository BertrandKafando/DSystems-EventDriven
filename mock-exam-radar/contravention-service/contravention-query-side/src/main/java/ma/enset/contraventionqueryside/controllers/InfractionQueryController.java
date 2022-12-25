package ma.enset.contraventionqueryside.controllers;

import lombok.AllArgsConstructor;
import ma.enset.contraventionqueryside.entities.Infraction;
import ma.enset.contraventionqueryside.repositories.InfractionRepository;
import ma.enset.query.GetAllInfractionsQuery;
import ma.enset.query.GetInfractioByIdQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/infractions/query/")
public class InfractionQueryController {
    private QueryGateway queryGateway;


    @GetMapping("/all")
    public List<Infraction> getAllInfractions(){
        return queryGateway.query(new GetAllInfractionsQuery(),
                ResponseTypes.multipleInstancesOf(Infraction.class)).join();
    }


    @GetMapping("/getInfraction/{id}")
    public Infraction getInfraction(@PathVariable String id){
        return queryGateway.query(new GetInfractioByIdQuery(id),
                ResponseTypes.instanceOf(Infraction.class)).join();
    }


}
