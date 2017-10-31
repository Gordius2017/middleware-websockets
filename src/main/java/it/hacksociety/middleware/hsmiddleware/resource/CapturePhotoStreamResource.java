package it.hacksociety.middleware.hsmiddleware.resource;

import it.hacksociety.middleware.hsmiddleware.model.Image;
import it.hacksociety.middleware.hsmiddleware.service.ImageCaptureService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/capture")
public class CapturePhotoStreamResource {
    private ImageCaptureService imageCaptureService;

    CapturePhotoStreamResource(ImageCaptureService imageCaptureService) {
        this.imageCaptureService = imageCaptureService;
    }

    @CrossOrigin
    @RequestMapping(path = "/frame", method = RequestMethod.POST)
    ResponseEntity<?> saveFrame(@RequestBody String body) {
        Image base64Image = new Image(body);
        imageCaptureService.saveImage(base64Image);

        return new ResponseEntity<>("Frame successfully saved into the database",HttpStatus.OK);
    }

}
