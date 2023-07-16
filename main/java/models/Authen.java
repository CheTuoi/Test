package models;

import helper.DataGenerator;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@Getter
@Setter

public class Authen {

    private String username;
    private String password;
    private Authen(){
        this.username = "admin";
        this.password = "password123";
    }
    public static Authen getInstance(){
        return new Authen();
    }
}
