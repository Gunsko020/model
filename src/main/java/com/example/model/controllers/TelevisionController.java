package com.example.model.controllers;



import com.example.model.models.Television;
import com.example.model.services.TelevisionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/televisions")
public class TelevisionController {

    private final TelevisionService televisionService;

    public TelevisionController(TelevisionService televisionService){
        this.televisionService = televisionService;
    }


    @PostMapping
    public ResponseEntity <Television> saveTelevision(@RequestBody Television television){
        Television savedTelevision = televisionService.saveTelevision(television);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTelevision);
    }











}
