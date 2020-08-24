package com.company;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SizeRepository extends JpaRepository<AircraftSize, Integer> {
    Optional<AircraftSize> findAircraftSizeBySize(String size);


}