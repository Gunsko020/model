package com.example.model.controllers;



import com.example.model.dto.TelevisionInputDto;
import com.example.model.dto.TelevisionOutputDto;
import com.example.model.models.Television;
import com.example.model.services.TelevisionService;
import jakarta.validation.Valid;
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
    public ResponseEntity<List<TelevisionOutputDto>> getAllTelevisions(){
        return ResponseEntity.ok(televisionService.getAllTelevisions());
    }

    @GetMapping("televisions/{id}")
    public ResponseEntity<TelevisionOutputDto> getTelevision(@PathVariable Long id){
        TelevisionOutputDto television = televisionService.getTelevision(id);
        return ResponseEntity.ok(television);
    }

    @PostMapping("/televisions")
    public ResponseEntity <Long> saveTelevision(@Valid @RequestBody TelevisionInputDto dto){
        Television television = televisionService.saveTelevision(dto);
        return ResponseEntity.created(null).body(television.getId());
    }

    @DeleteMapping("televisions/{id}")
    public ResponseEntity<Void> deleteTelevision(@PathVariable Long id){
        televisionService.deleteTelevision(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("televisions/{id}")
    public ResponseEntity <TelevisionOutputDto> updateTelevision(@PathVariable Long id,@Valid @RequestBody TelevisionInputDto newTelevision){

        TelevisionOutputDto dto = televisionService.updateTelevision(id,newTelevision);
        return ResponseEntity.ok().body(dto);
    }


}
