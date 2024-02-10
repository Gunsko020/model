package com.example.model.repositories;

import com.example.model.models.Television;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TelevisionRepository extends JpaRepository<Television, Long>{

    List<Television> findByBrand(String brand);


}
