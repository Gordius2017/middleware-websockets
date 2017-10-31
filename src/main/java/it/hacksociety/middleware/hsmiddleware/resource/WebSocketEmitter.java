package it.hacksociety.middleware.hsmiddleware.resource;

import it.hacksociety.middleware.hsmiddleware.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketEmitter {
    @Autowired
    ImageRepository imageRepository;

    @MessageMapping("/frame")
    @SendTo("/topic/frames")
    public String getFrames() {
        return imageRepository.findTopByOrderByCreatedDesc().getValue();
    }
}