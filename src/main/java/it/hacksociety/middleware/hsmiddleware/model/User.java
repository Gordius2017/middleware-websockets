package it.hacksociety.middleware.hsmiddleware.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@ToString
@Getter
@Setter
public class User {
    private int token;
    private String name;
    private String position;
    private String lastLogin;
}
