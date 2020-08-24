package com.company;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TypeRepository extends JpaRepository<AircraftType, Integer> {

    Optional<AircraftType> findAircraftTypeByType(String type);

}



