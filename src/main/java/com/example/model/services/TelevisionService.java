package com.example.model.services;

import com.example.model.models.Television;
import com.example.model.repositories.TelevisionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TelevisionService {


    private final TelevisionRepository televisionRepository;

    public TelevisionService(TelevisionRepository televisionRepository) {
        this.televisionRepository = televisionRepository;
    }

    public List<Television> getAllTelevisions(){
        return televisionRepository.findAll();
    }

    public Television saveTelevision(Television television){
        return televisionRepository.save(television);
    }




}
