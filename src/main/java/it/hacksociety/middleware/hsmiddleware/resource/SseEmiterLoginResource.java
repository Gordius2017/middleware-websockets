package it.hacksociety.middleware.hsmiddleware.resource;

import it.hacksociety.middleware.hsmiddleware.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;

@RestController
@RequestMapping("/sse")
public class SseEmiterLoginResource {
    @Autowired
    ImageRepository imageRepository;

    @CrossOrigin
    @RequestMapping(path = "/infinite", method = RequestMethod.GET)
    public SseEmitter getFiniteMessages() throws IOException {
        SseEmitter sseEmitter = new SseEmitter();

        Thread t1 = new Thread(() ->{
            while (true) {
                try {
                    Thread.sleep(500);
                    sseEmitter.send(SseEmitter.event().name("frame").data(imageRepository.findTopByOrderByCreatedDesc().getValue()));
                    sseEmitter.complete();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();

        return sseEmitter;
    }
}
