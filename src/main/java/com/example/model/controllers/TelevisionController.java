package com.example.model.controllers;



import com.example.model.models.Television;
import com.example.model.services.TelevisionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TelevisionController {

    private final TelevisionService televisionService;

    public TelevisionController(TelevisionService televisionService){
        this.televisionService = televisionService;
    }



    @GetMapping("/televisions")
    public ResponseEntity<List<Television>> getAllTelevisions(){
        return ResponseEntity.ok(televisionService.getAllTelevisions());
    }

    @GetMapping("televisions/{id}")
    public ResponseEntity<Television> getTelevision(@PathVariable Long id){
        televisionService.getTelevision(id);
        return ResponseEntity.ok(televisionService.getTelevision(id));
    }

    @PostMapping("/televisions")
    public ResponseEntity <Television> saveTelevision(@RequestBody Television television){
        return ResponseEntity.status(HttpStatus.CREATED).body(televisionService.saveTelevision(television));
    }

    @DeleteMapping("televisions/{id}")
    public ResponseEntity<Void> deleteTelevision(@PathVariable Long id){
        televisionService.deleteTelevision(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("televisions/{id}")
    public ResponseEntity <Television> updateTelevision(@PathVariable Long id, @RequestBody Television newTelevision){

        Optional<Television> television = televisionService.getTelevisionById(id);

        if (television.isEmpty()){
            throw new RuntimeException("Television not found");
        }
        else {
            Television updatedTelevision = television.get();
            updatedTelevision.setBrand(newTelevision.getBrand());
            updatedTelevision.setPrice(newTelevision.getPrice());
            updatedTelevision.setAvailableSize(newTelevision.getAvailableSize());
            updatedTelevision.setRefreshRate(newTelevision.getRefreshRate());
            updatedTelevision.setScreenType(newTelevision.getScreenType());
            updatedTelevision.setType(newTelevision.getType());
            updatedTelevision.setSold(newTelevision.getSold());
            updatedTelevision.setName(newTelevision.getName());
            updatedTelevision.setAmbiLight(newTelevision.getAmbiLight());
            updatedTelevision.setSmartTv(newTelevision.getSmartTv());
            updatedTelevision.setBluetooth(newTelevision.getBluetooth());
            updatedTelevision.setHdr(newTelevision.getHdr());
            updatedTelevision.setOriginalStock(newTelevision.getOriginalStock());
            updatedTelevision.setWifi(newTelevision.getWifi());
            updatedTelevision.setVoiceControl(newTelevision.getVoiceControl());
            updatedTelevision.setScreenQuality(newTelevision.getScreenQuality());
            Television returnedTelevision = televisionService.saveTelevision(updatedTelevision);
            return ResponseEntity.ok().body(returnedTelevision);
        }


    }




}
