package it.hacksociety.middleware.hsmiddleware.resource;

import it.hacksociety.middleware.hsmiddleware.model.User;
import it.hacksociety.middleware.hsmiddleware.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notification")
public class NotificationResource {
    @Autowired
    private SimpMessagingTemplate template;

    @Autowired
    private UserRepository userRepository;

    @CrossOrigin
    @RequestMapping(path = "/grantaccess", method = RequestMethod.POST)
    public ResponseEntity grantAccess() {
        template.convertAndSend("/topic/notification", "grant");

        return new ResponseEntity(HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(path = "/denyaccess", method = RequestMethod.POST)
    public ResponseEntity denyAccess() {
        template.convertAndSend("/topic/notification", "deny");

        return new ResponseEntity(HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(path = "/updatedetails", method = RequestMethod.POST)
    public ResponseEntity updateUserDetails(@RequestBody String body) {
        if(body != null) {
            User user = userRepository.findByName(body);

            if (user != null) {
                template.convertAndSend("/topic/account", userRepository.findByName(body));

            }
        }

        return new ResponseEntity(HttpStatus.OK);
    }
}
