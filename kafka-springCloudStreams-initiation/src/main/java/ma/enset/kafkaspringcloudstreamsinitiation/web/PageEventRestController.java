package ma.enset.kafkaspringcloudstreamsinitiation.web;

import lombok.AllArgsConstructor;
import ma.enset.kafkaspringcloudstreamsinitiation.entities.PageEvent;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@AllArgsConstructor
public class PageEventRestController {
    private final StreamBridge streamBridge;
    @GetMapping("/publish/{topic}/{name}")
    public PageEvent publish(@PathVariable String topic, @PathVariable String name) {
        PageEvent pageEvent = new PageEvent(name, Math.random()>0.5?"U1":"U2", new Random().nextInt(9000), new java.util.Date());
        streamBridge.send(topic, pageEvent);
        return pageEvent;
    }

}
