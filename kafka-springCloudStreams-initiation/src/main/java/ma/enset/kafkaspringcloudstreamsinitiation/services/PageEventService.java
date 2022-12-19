package ma.enset.kafkaspringcloudstreamsinitiation.services;

import ma.enset.kafkaspringcloudstreamsinitiation.entities.PageEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@Service
public class PageEventService {
    // le framework fait le suscribe automatiquement
    @Bean
    public Consumer<PageEvent> pageEventConsumer(){
        return (input) -> {
            System.out.println("**************");
            System.out.println(input.toString());
            System.out.println("**************");
        };
    }
    @Bean
    public Supplier<PageEvent> pageEventSupplier (){
        return () -> new PageEvent(Math.random()>0.5?"P1":"P2", Math.random()>0.5?"U1":"U2", new Random().nextInt(9000), new java.util.Date());
    }
    @Bean
    public Function<PageEvent,PageEvent> pageEventFunction (){
        return (input) -> {
            input.setName("PageEventFunction");
            input.setUser("UUU");
            return input;
        };
    }


}
