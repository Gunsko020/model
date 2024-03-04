package com.example.model.services;

import com.example.model.dto.TelevisionInputDto;
import com.example.model.dto.TelevisionOutputDto;
import com.example.model.exceptions.RecordNotFoundException;
import com.example.model.models.Television;
import com.example.model.repositories.TelevisionRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class TelevisionService {


    private final TelevisionRepository televisionRepository;


    public TelevisionService(TelevisionRepository televisionRepository) {
        this.televisionRepository = televisionRepository;
    }



    public List<TelevisionOutputDto> getAllTelevisions() {
        List <Television> television = televisionRepository.findAll();
        List <TelevisionOutputDto> televisionOutputDtos = new ArrayList<>();
        for (Television tv : television){
            TelevisionOutputDto dto = toTelevisionDto(tv);
            televisionOutputDtos.add(dto);
        }

        return televisionOutputDtos;

    }

    public TelevisionOutputDto getTelevision(Long id){
        Optional<Television> optionalTelevision = televisionRepository.findById(id);
        if (optionalTelevision.isPresent()){
            return toTelevisionDto(optionalTelevision.get());
        }
        else {
                throw new RecordNotFoundException("Television not found");

        }

    }

    public Television saveTelevision(TelevisionInputDto dto) {

        return televisionRepository.save(toTelevision(dto));
    }

    public TelevisionOutputDto updateTelevision(Long id, TelevisionInputDto newTelevision){
        Optional<Television> television = televisionRepository.findById(id);

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
            Television returnedTelevision = televisionRepository.save(updatedTelevision);
            return toTelevisionDto(returnedTelevision);
        }

    }

    public void deleteTelevision(Long id) {
        televisionRepository.deleteById(id);
    }

    public Optional <Television> getTelevisionById (Long id){
        return televisionRepository.findById(id);

    }
    private TelevisionOutputDto toTelevisionDto(Television television) {
        TelevisionOutputDto dto = new TelevisionOutputDto();
        dto.setId(television.getId());
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
        return dto;
    }


    public Television toTelevision(TelevisionInputDto dto) {

        Television television = new Television();
        television.setId(dto.getId());
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
