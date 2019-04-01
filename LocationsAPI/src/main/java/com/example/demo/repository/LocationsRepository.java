package com.example.demo.repository;

import com.example.demo.entity.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationsRepository extends JpaRepository<Location, Long> {


}
