package it.hacksociety.middleware.hsmiddleware.config;

import it.hacksociety.middleware.hsmiddleware.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class WebSocketScheduler {
    @Autowired
    private SimpMessagingTemplate template;

    @Autowired
    ImageRepository imageRepository;

    @Scheduled(fixedDelay = 3)
    public void publishUpdates(){
        template.convertAndSend("/topic/frames", imageRepository.findTopByOrderByCreatedDesc().getValue());
    }
}
