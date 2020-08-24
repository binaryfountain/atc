package com.company;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AircraftSize {

    @Id
    private int id;
    private String size;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
