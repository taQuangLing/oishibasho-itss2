package dev.hikari.oishibasho.app.endpoint.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin
@RestController
public class Controller {
    @GetMapping("/")
    public String welcomeToApp(){
        return "<h1>Hello my friend, Welcome to Oishibasho!</h1>";
    }

}
