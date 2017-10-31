package it.hacksociety.middleware.hsmiddleware.service;

import it.hacksociety.middleware.hsmiddleware.model.Image;
import it.hacksociety.middleware.hsmiddleware.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageCaptureService {
    @Autowired
    private ImageRepository imageRepository;

    public void saveImage(Image base64Image) {
        imageRepository.save(base64Image);
    }
}
