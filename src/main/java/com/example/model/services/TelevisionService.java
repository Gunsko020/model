package com.example.model.services;

import com.example.model.exceptions.RecordNotFoundException;
import com.example.model.models.Television;
import com.example.model.repositories.TelevisionRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TelevisionService {


    private final TelevisionRepository televisionRepository;


    public TelevisionService(TelevisionRepository televisionRepository) {
        this.televisionRepository = televisionRepository;
    }



    public List<Television> getAllTelevisions() {
        return televisionRepository.findAll();
    }

    public Television getTelevision(Long id){
        Optional<Television> optionalTelevision = televisionRepository.findById(id);
        if (optionalTelevision.isPresent()){
            return optionalTelevision.get();
        }
        else {
            throw new RecordNotFoundException("Television not found");
        }

    }

    public Television saveTelevision(Television television) {
        return televisionRepository.save(television);
    }



    public void deleteTelevision(Long id) {
        televisionRepository.deleteById(id);
    }

    public Optional <Television> getTelevisionById (Long id){
        return televisionRepository.findById(id);

    }

//    public List<Television> getTelevisionsByBrand(String brand) {
//        return televisionRepository.findByBrand(brand);
//    }
}
