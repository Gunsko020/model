package com.example.model.services;

import com.example.model.dto.TelevisionDto;
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

    public static TelevisionDto toTelevisionDto(Television television) {
        TelevisionDto dto = new TelevisionDto();
        dto.setType(television.getType());
        dto.setBrand(television.getBrand());
        dto.setName(television.getName());
        dto.setPrice(television.getPrice());
        dto.setAvailableSize(television.getAvailableSize());
        dto.setRefreshRate(television.getRefreshRate());
        dto.setScreenType(television.getScreenType());
        dto.setScreenQuality(television.getScreenQuality());
        dto.setSmartTv(television.getSmartTv());
        dto.setWifi(television.getWifi());
        dto.setVoiceControl(television.getVoiceControl());
        dto.setHdr(television.getHdr());
        dto.setBluetooth(television.getBluetooth());
        dto.setAmbiLight(television.getAmbiLight());
        dto.setOriginalStock(television.getOriginalStock());
        dto.setSold(television.getSold());
        return dto;
    }

    public Television toTelevision(TelevisionDto dto) {
        Television television = new Television();
        television.setType(dto.getType());
        television.setBrand(dto.getBrand());
        television.setName(dto.getName());
        television.setPrice(dto.getPrice());
        television.setAvailableSize(dto.getAvailableSize());
        television.setRefreshRate(dto.getRefreshRate());
        television.setScreenType(dto.getScreenType());
        television.setScreenQuality(dto.getScreenQuality());
        television.setSmartTv(dto.getSmartTv());
        television.setWifi(dto.getWifi());
        television.setVoiceControl(dto.getVoiceControl());
        television.setHdr(dto.getHdr());
        television.setBluetooth(dto.getBluetooth());
        television.setAmbiLight(dto.getAmbiLight());
        television.setOriginalStock(dto.getOriginalStock());
        television.setSold(dto.getSold());
        return television;

    }




}
