package it.hacksociety.middleware.hsmiddleware.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
@ToString
@Getter
@Setter
public class Image {
    private String value;
    @JsonIgnore
    private Date created = new Date();

    public Image() { }
    public Image(String value) {
        this.value = value;
    }

}
