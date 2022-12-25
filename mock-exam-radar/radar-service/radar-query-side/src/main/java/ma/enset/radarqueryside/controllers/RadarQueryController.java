package ma.enset.radarqueryside.controllers;

import lombok.AllArgsConstructor;
import ma.enset.query.GetAllRadarQuery;
import ma.enset.query.GetRadarByIdQuery;
import ma.enset.radarqueryside.entities.Radar;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/radars/query")
@AllArgsConstructor
public class RadarQueryController {
    private QueryGateway queryGateway;

    @GetMapping("/all")
    CompletableFuture<List<Radar>> getAllRadars(){
        return queryGateway.query(new GetAllRadarQuery(), ResponseTypes.multipleInstancesOf(Radar.class));
    }

    @GetMapping("/byId/{id}")
    public CompletableFuture<Radar> getRadar(@PathVariable String id){
        return queryGateway.query(new GetRadarByIdQuery(id),
                ResponseTypes.instanceOf(Radar.class));
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exceptionHandler(Exception exception){
        ResponseEntity<String > responseEntity=
                new ResponseEntity(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        return responseEntity;
    }
}
