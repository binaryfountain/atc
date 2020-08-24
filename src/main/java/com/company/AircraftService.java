package com.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AircraftService {

    private AircraftRepository aircraftRepository;
    private TypeRepository typeRepository;
    private SizeRepository sizeRepository;

    enum Type {
        EMERGENCY, VIP, PASSENGER, CARGO;
    }

    enum Size {
        LARGE, SMALL;
    }

    Type c1;
    Size c2;

    public int getPriority(Aircraft aircraft) {
        int priority = 0;

        if (aircraft.getType().toUpperCase().equals(c1.EMERGENCY)) {
            if (aircraft.getSize().toUpperCase().equals(c2.LARGE)) {
                priority = 1;
            } else if (aircraft.getSize().toUpperCase().equals(c2.SMALL)) {
                priority = 2;
            }
        } else if (aircraft.getType().toUpperCase().equals(c1.VIP)) {
            if (aircraft.getSize().toUpperCase().equals(c2.LARGE)) {
                priority = 3;
            } else if (aircraft.getType().toUpperCase().equals(c2.SMALL)) {
                priority = 4;
            }
        } else if (aircraft.getType().toUpperCase().equals(c1.PASSENGER)) {
            if (aircraft.getSize().toUpperCase().equals(c2.LARGE)) {
                priority = 5;
            } else if (aircraft.getSize().toUpperCase().equals(c2.SMALL)) {
                priority = 6;
            }
        } else if (aircraft.getType().toUpperCase().equals(c1.CARGO)) {
            if (aircraft.getSize().toUpperCase().equals(c2.LARGE)) {
                priority = 7;
            } else if (aircraft.getSize().toUpperCase().equals(c2.SMALL)) {
                priority = 8;
            }
        }
        return priority;
    }

    private int compare(Aircraft a1, Aircraft a2) {
        int a1priority = getPriority(a1);
        int a2priority = getPriority(a2);

        if (a1priority < a2priority) {
            return -1;
        } else if (a1priority > a2priority) {
            return 1;
        } else {
            return 0;
        }

    }

    @Autowired
    public AircraftService(AircraftRepository aircraftRepository,
                           TypeRepository typeRepository,
                           SizeRepository sizeRepository) {
        this.aircraftRepository = aircraftRepository;
        this.typeRepository = typeRepository;
        this.sizeRepository = sizeRepository;
    }

    public List<Aircraft> list() {
        System.out.println("list");
        List<Aircraft> dbaircraft = aircraftRepository.findAll();
        dbaircraft.sort(this::compare);
        return dbaircraft;
    }

    public Aircraft enqueue(Aircraft aircraft) {
        System.out.println("enqueue");

        Optional<AircraftType> aircraftTypeOptional = typeRepository.findAircraftTypeByType(aircraft.getType());
        Optional<AircraftSize> aircraftSizeOptional = sizeRepository.findAircraftSizeBySize(aircraft.getSize());

        if (aircraftTypeOptional.isPresent() && aircraftSizeOptional.isPresent()) {
            aircraftRepository.save(aircraft);
            return aircraft;
        } else {
            return new Aircraft();
        }
    }

    //EL>ES>VL>VS>PL>PS>CL>CS
    public Aircraft dequeue() {
        System.out.println("dequeue");
        List<Aircraft> dbaircraft = list();
        aircraftRepository.delete(dbaircraft.get(0));
        return dbaircraft.get(0);

    }

}